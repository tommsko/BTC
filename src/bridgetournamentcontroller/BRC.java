/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgetournamentcontroller;

import java.util.Arrays;
import dataManagment.BoardData;
import dataManagment.DealProcessor;
import java.util.ArrayList;
import java.util.HashMap;
import dataManagment.DatabaseConnector;

/**
 *
 * @author tomas
 */
public class BRC {

    String dealFile = "";
    String playableFile = "";
    ArrayList<Integer> OK = new ArrayList<Integer>();
    
    public ArrayList<Double> ERR = new ArrayList<Double>();
    int errlimit = 2;
    
    //LINE ERROR HAS VALUE OF 5
    
    public BRC(String dealFile, String playableFile, ArrayList<Integer> ok) {
    this.dealFile=dealFile;
    this.playableFile=playableFile;
    this.OK = ok;
    }
    
    
    public void precheck(ArrayList<Integer> ok) {
    for(int i = 0; i < 1000; i++) ERR.add(i,0.0);
    
    for(int i = 0; i < ok.size(); i++) ERR.set(ok.get(i), -999.0);
    }
    
    
    // DONE
    public String lineError(BoardData[] bd, int mode) {
       
        /*
        Method - detection if contract was played on good line (NS, EW)
               - check all played boards and test if played contract type and contract lines are OK
        
        Result - if a board found another board with same contract type and contract lines, it is probable that result is OK
               - if board doesn't have any other board with same contract type and contract lines, error is shown
        */
        String result = "";
        for(int i = 0; i < bd.length; i++) {
            if(OK.contains(bd[i].ID)) continue;
            
        boolean OK = false;
        boolean colorPlayed = false;
        // v 2.0 - if color wasn't played before - > ignore
           
            for(int ii = 0; ii < bd.length; ii++) {
                if(bd[i].ID == bd[ii].ID) continue;
        if(bd[i].contractType.equals(bd[ii].contractType) && bd[i].contractLine.equals(bd[ii].contractLine) && bd[i].ID!=bd[ii].ID) {OK = true;}
        if(bd[i].contractType.equals(bd[ii].contractType)) {colorPlayed = true;}
            }
            
            if(OK == false && colorPlayed==true && mode == 0) {
                ERR.add(bd[i].ID, ERR.get(bd[i].ID)+2);
            } 
            if(OK == false && colorPlayed==true && mode == 1 && ERR.get(bd[i].ID) >=errlimit) {  
               result+=("ERROR LINES board nb. #"+bd[i].boardID+" with result ID "+bd[i].ID+" "+colorPlayed+"\n"); 
            }             
            
        }
        
        
        return result;
    }
    
    // DONE
    public String contractError(BoardData[] bd, int mode) {
         /*
        Method - playableError without deal data
               - check if contract was played on specific line / more lines
               - yet only check for same contracts
        
        Result - 
               -
        */
        String result = "";
        double NTNS = 0; double NTEW = 0;
        double SNS = 0;  double SEW = 0;
        double HNS = 0;  double HEW = 0;
        double DNS = 0;  double DEW = 0;
        double CNS = 0;  double CEW = 0;
        
        for(int i = 0; i < bd.length; i++) {
            if(OK.contains(bd[i].ID)) continue;
       switch(bd[i].contractType) {
           case "NT":
               if(bd[i].contractLine.equals("NS")) NTNS++; else NTEW++;
               break;
          case "S":
               if(bd[i].contractLine.equals("NS")) SNS++; else SEW++;
               break;
          case "H":
               if(bd[i].contractLine.equals("NS")) HNS++; else HEW++;
               break;
          case "D":
               if(bd[i].contractLine.equals("NS")) DNS++; else DEW++;
               break;
          case "C":
               if(bd[i].contractLine.equals("NS")) CNS++; else CEW++;
               break;
           
       }
      }
        // percentual played contracts over all on specific board
        NTNS = (NTNS/bd.length)*100; NTEW = (NTEW/bd.length)*100;
        SNS = (SNS/bd.length)*100; SEW = (SEW/bd.length)*100;
        HNS = (HNS/bd.length)*100; HEW = (HEW/bd.length)*100;
        DNS = (DNS/bd.length)*100; DEW = (DEW/bd.length)*100;
        CNS = (CNS/bd.length)*100; CEW = (CEW/bd.length)*100;
        
        if(NTNS > 0 && NTEW > 0 && mode == 0)
          ERR.add(bd[0].ID, ERR.get(bd[0].ID)+2);
        if(SNS > 0 && SEW > 0 && mode == 0)
           ERR.add(bd[0].ID, ERR.get(bd[0].ID)+2);
        if(HNS > 0 && HEW > 0 && mode == 0)
           ERR.add(bd[0].ID, ERR.get(bd[0].ID)+2);
        if(DNS > 0 && DEW > 0 && mode == 0)
          ERR.add(bd[0].ID, ERR.get(bd[0].ID)+2);
        if(SNS > 0 && SEW > 0 && mode == 0)
           ERR.add(bd[0].ID, ERR.get(bd[0].ID)+2);
        
        if(NTNS > 0 && NTEW > 0 && mode == 1 && ERR.get(bd[0].ID) >=errlimit)
          result+=("ERROR on board nb. #"+bd[0].boardID+" detected more results in NT on both lines\n");
        if(SNS > 0 && SEW > 0 && mode == 1 && ERR.get(bd[0].ID) >=errlimit)
          result+=("ERROR on board nb. #"+bd[0].boardID+" detected more results in S on both lines\n");
        if(HNS > 0 && HEW > 0 && mode == 1 && ERR.get(bd[0].ID) >=errlimit)
          result+=("ERROR on board nb. #"+bd[0].boardID+" detected more results in H on both lines\n");
        if(DNS > 0 && DEW > 0 && mode == 1 && ERR.get(bd[0].ID) >=errlimit)
          result+=("ERROR on board nb. #"+bd[0].boardID+" detected more results in D on both lines");
        if(SNS > 0 && SEW > 0 && mode == 1 && ERR.get(bd[0].ID) >=errlimit)
          result+=("ERROR on board nb. #"+bd[0].boardID+" detected more results in S on both lines\n");
        
        return result;
    }
    
    // DONE
    public String contractSizeError(BoardData[] bd, int mode) {
     /*
        Method - playableError without deal data
               - check if played contract sizes were about same, so 2H and 3H are ok, 3H and 5H are not
               - +- 1
               - returns 2 boardDatas, 1 that is incorrect from look of 1. result, and secont that is incorrect from look of incorrect result.
        
        Result -
               - 
        */
        String result = "";
        for(int i = 0; i < bd.length; i++) {
            if(OK.contains(bd[i].ID)) continue;
        boolean OK = false;
           
            for(int ii = 0; ii < bd.length; ii++) {
        if(bd[i].contractType.equals(bd[ii].contractType) && bd[i].contractLine.equals(bd[ii].contractLine) && bd[i].ID != bd[ii].ID && Math.abs(bd[i].contractSize-bd[ii].contractSize) <= 1) {OK = true;}
            }
            
            if(OK == false && mode == 0) {
                ERR.add(bd[i].ID, ERR.get(bd[i].ID)+1);
            } 
            if(OK == false && mode == 1 && ERR.get(bd[i].ID) >=errlimit) {  
               result+=("ERROR CONTRACT_SIZE board nb. #"+bd[i].boardID+" with result ID "+bd[i].ID+"\n");
            } 
            
        }
        
        return result;
    }
    
    // DONE
    public String contractResultError(BoardData[] bd, int mode) {
     /*
        Method - playableError without deal data
               - check if played contract result is +- 3 than average.
               - returns 2 boardDatas, 1 that is incorrect from look of 1. result, and secont that is incorrect from look of incorrect result.
        
        Result - 
               - 
        */
        String result = "";
        for(int i = 0; i < bd.length; i++) {
            if(OK.contains(bd[i].ID)) continue;
        boolean OK = false;
           
            for(int ii = 0; ii < bd.length; ii++) {
        if(bd[i].contractType.equals(bd[ii].contractType) && bd[i].contractLine.equals(bd[ii].contractLine) && bd[i].ID != bd[ii].ID && (Math.abs(bd[i].contractResult)+Math.abs(bd[ii].contractResult)) <= 2) {OK = true;}
            }
            
            if(OK == false && mode == 0) {
                ERR.add(bd[i].ID, ERR.get(bd[i].ID)+0.5);
            } 
            if(OK == false && mode == 1 && ERR.get(bd[i].ID) >=errlimit) {  
                result+=("ERROR CONTRACT_RESULT board nb. #"+bd[i].boardID+" with result ID "+bd[i].ID+"\n");
            } 
            
        }
        return result;
    }
    
    // DONE
    public String leadError(BoardData[] bd, int mode) {
    // REQ deal data
        
        /*
        Method - check, if lead on specific board, at specific seat (N, S, E, W) is possible
               - check if player's hand contains specific card
        
        Result - 
               -
        */
        String result = "";
        
         for(int i = 0; i < bd.length; i++) {
           
           if(OK.contains(bd[i].ID)) continue;
            DealProcessor dp = new DealProcessor();
            char declarer = bd[i].contractDeclarer;
            String data = "";
            
            switch(declarer) {
                case 'N':
                    // lead East
                     data = dp.decodeDeal(bd[i].boardID, dealFile).split("\\$")[2];
                    break;
                    
                case 'S':
                    // lead West
                     data = dp.decodeDeal(bd[i].boardID, dealFile).split("\\$")[3];
                    break;
                    
                case 'E':
                    // lead South
                     data = dp.decodeDeal(bd[i].boardID, dealFile).split("\\$")[1];   
                    break;
                    
                case 'W':
                    // lead North
                     data = dp.decodeDeal(bd[i].boardID, dealFile).split("\\$")[0];
                    break;
            
            }
            
            data=data.replace("p", "S").replace("s", "H").replace("k", "D").replace("t", "C");
                     
            if(!data.contains(bd[i].leadType+bd[i].leadCard) && mode == 0) {
                ERR.add(bd[i].ID, ERR.get(bd[i].ID)+0.5);
            } 
            if(!data.contains(bd[i].leadType+bd[i].leadCard) && mode == 1 && ERR.get(bd[i].ID) >=errlimit) {  
               result+=("ERROR LEAD board nb. #"+bd[i].boardID+" with result ID "+bd[i].ID+"\n");
            } 
            
            
            
           
        
    }
         return result;
    }     
    
    // DONE
    public String playableError(BoardData[] bd, int mode) {
    // REQ deal data
     
        /*
        Method - by deal data, check if contract is playable on specific line
               - check if contract color, line is playable and if tricks won are less or equal than in deal data
               - tricks won are generated by 6+(contractSize)-(contractResult)
               - carefull about contract too low
        
        Result - 
               -
        */
       String result = ""; 
        for(int i = 0; i < bd.length; i++) {
           if(OK.contains(bd[i].ID)) continue;
           
            DealProcessor dp = new DealProcessor();
            char declarer = bd[i].contractDeclarer;
            String contractType = bd[i].contractType;
            String data = "";
            int playableTricks = 0;
            int playedTricks = 6+bd[i].contractSize+bd[i].contractResult;
                
            switch(declarer) {
                case 'N':
                     data = dp.decodePlayable(bd[i].boardID, playableFile).split("\\$")[0];
                    switch(contractType) {
                        case "NT":
                            playableTricks= Integer.parseInt(data.split(" ")[0]);
                            break;
                        case "S":
                            playableTricks= Integer.parseInt(data.split(" ")[1]);
                            break;
                        case "H":
                            playableTricks= Integer.parseInt(data.split(" ")[2]);
                            break;
                        case "D":
                            playableTricks= Integer.parseInt(data.split(" ")[3]);
                            break;
                        case "C":
                            playableTricks= Integer.parseInt(data.split(" ")[4]);
                            break;
                    }
                    break;
                    
                case 'S':
                     data = dp.decodePlayable(bd[i].boardID, playableFile).split("\\$")[1];
                    switch(contractType) {
                        case "NT":
                            playableTricks= Integer.parseInt(data.split(" ")[0]);
                            break;
                        case "S":
                            playableTricks= Integer.parseInt(data.split(" ")[1]);
                            break;
                        case "H":
                            playableTricks= Integer.parseInt(data.split(" ")[2]);
                            break;
                        case "D":
                            playableTricks= Integer.parseInt(data.split(" ")[3]);
                            break;
                        case "C":
                            playableTricks= Integer.parseInt(data.split(" ")[4]);
                            break;
                    }
                    break;
                    
                case 'E':
                     data = dp.decodePlayable(bd[i].boardID, playableFile).split("\\$")[2];
                    switch(contractType) {
                        case "NT":
                            playableTricks= Integer.parseInt(data.split(" ")[0]);
                            break;
                        case "S":
                            playableTricks= Integer.parseInt(data.split(" ")[1]);
                            break;
                        case "H":
                            playableTricks= Integer.parseInt(data.split(" ")[2]);
                            break;
                        case "D":
                            playableTricks= Integer.parseInt(data.split(" ")[3]);
                            break;
                        case "C":
                            playableTricks= Integer.parseInt(data.split(" ")[4]);
                            break;
                    }
                    break;
                    
                case 'W':
                     data = dp.decodePlayable(bd[i].boardID, playableFile).split("\\$")[3];
                    switch(contractType) {
                        case "NT":
                            playableTricks= Integer.parseInt(data.split(" ")[0]);
                            break;
                        case "S":
                            playableTricks= Integer.parseInt(data.split(" ")[1]);
                            break;
                        case "H":
                            playableTricks= Integer.parseInt(data.split(" ")[2]);
                            break;
                        case "D":
                            playableTricks= Integer.parseInt(data.split(" ")[3]);
                            break;
                        case "C":
                            playableTricks= Integer.parseInt(data.split(" ")[4]);
                            break;
                    }
                    break;
            
            }
            
             if(!(playedTricks <= playableTricks) && mode == 0) {
                ERR.add(bd[i].ID, ERR.get(bd[i].ID)+1);
            } 
            if(!(playedTricks <= playableTricks) && mode == 1 && ERR.get(bd[i].ID) >=errlimit) {  
               result+=("ERROR PLAYABLE board nb. #"+bd[i].boardID+" with result ID "+bd[i].ID+"\n");
            }  
            
             if(playedTricks <= playableTricks && playableTricks-playedTricks > 2 && mode == 0) {
                ERR.add(bd[i].ID, ERR.get(bd[i].ID)+1);
            } 
            if(playedTricks <= playableTricks && playableTricks-playedTricks > 2 && mode == 1 && ERR.get(bd[i].ID) >=errlimit) {  
               result+=("ERROR PLAYABLE board nb. #"+bd[i].boardID+" with result ID "+bd[i].ID+"\n");
            }  
            
            
            
     
        }
        
         
        
        return result;
    }
   
    // TODO
    public String trumphError(BoardData[] bd, int mode) {
    // REQ deal data
        
        /*
        Method - check, if played contract has requied number of trumphs (by contract colour), so no 3H with only 5H on line
        
        Result - 
               -
        */
        String result = "";
        for(int i = 0; i < bd.length; i++) {
           if(bd[i].contractType.equals("NT")) continue;
           if(OK.contains(bd[i].ID)) continue;
           
            DealProcessor dp = new DealProcessor();
            String line = bd[i].contractLine;
            String data1 = "";
            String data2 = "";
            
            switch(line) {
                case "NS":
                     data1 = dp.decodeDeal(bd[i].boardID, dealFile).split("\\$")[0];
                     data2 = dp.decodeDeal(bd[i].boardID, dealFile).split("\\$")[1];
                    break;
                    
                case "EW":
                     data1 = dp.decodeDeal(bd[i].boardID, dealFile).split("\\$")[2];
                     data1 = dp.decodeDeal(bd[i].boardID, dealFile).split("\\$")[3];
                    break;

            }
            
            data1=data1.replace("p", "S").replace("s", "H").replace("k", "D").replace("t", "C");
            data2=data2.replace("p", "S").replace("s", "H").replace("k", "D").replace("t", "C");
            
            
            int trumphs = 0;
            String finalDeal=data1+data2;
           
            
            for(int ii = 0; ii < finalDeal.length(); ii++) {
            if(finalDeal.charAt(ii)==bd[i].contractType.charAt(0)) trumphs++;
            }
            
             if(trumphs < 5 && mode == 0) {
                ERR.add(bd[i].ID, ERR.get(bd[i].ID)+0.5);
            } 
            if(trumphs < 5 && mode == 1 && ERR.get(bd[i].ID) >=errlimit) {  
               result+=("ERROR TRUMPHS board nb. #"+bd[i].boardID+" with result ID "+bd[i].ID+"\n");
            }   
            
        }
        return result;
    }
    
    // TODO
    public String contractPointError(BoardData[] bd) {
    // REQ deal data
        
         /*
             Method - check if there are enought points on line to play contract at specific size
                    - careful on slams and grant slams, less carefull with low-level contracts
        
            Result  - 
                    - 
        */
        
        return null;
    }
    
    // TODO
    public String scoreError(BoardData[] bd) {
    // REQ contract scorer
        
        /*
             Method - check for scores on lines, so, if someone won 600 on NS and somebody 900 on EW, there is a problem
        
            Result  - 
                    - 
        */
        
        return null;
    }
    
    // TODO - score error enchanted
    public String frequencyError(BoardData[] bd) {
    // REQ contract scorer
        
        /*
             Method - check for scores on lines, so, if someone won 600 on NS and somebody 900 on EW, there is a problem
        
            Result  - 
                    - 
        */
        
        return null;
    }
    
    
    // TODO -BIG -SLOW
    public String anomalyError(BoardData[] bd) {
    // REQ contract scorer, deal data, active play data
        
        /*
             Method - to keep Tournament Director a little bit busy, check for anomalies in every gatherable datas
                    - boardNb
                    - players (pairs - numbers) - their skill over boards, average MP per board, average MP on this board
                    - contract type             - sudden change of contract type played - used by boardData ID // even only 1 contract in specific contract type
                    - contract size             - slow/sudden increase of contract size played - possible changed cards
                    - contract result           - slow/sudden change of contract result
                    - lead                      - sudden change of lead (possibility of entering bad leads) - used by boardData ID
                    - contract lines            - sudden change of contract line played, even same contract on both lines
                    - played time               - change of play time of board in long term 
                    - ereased boards            - detect if boards with simillar results were ereased
        
            Result  - check if there are enought anomalies to warn TD, if there are, ask for immediate board check
                    - very specific error, possible slow - after every round anomalies should be showed
        */
        
        return null;
    }
    
    
}
