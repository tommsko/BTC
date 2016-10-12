/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoring;

import dataManagment.BoardData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author uzivatel
 */
public class MPScore {
    
    ContractScorer cs = new ContractScorer();
    
    public void scoreBoard(int board) {
        ArrayList<BoardData> bd = bridgetournamentcontroller.BridgeTorunamentController.ac.bdata.get(board);
        ArrayList<Integer> MP_NS = new ArrayList<Integer>();
        ArrayList<Integer> MP_EW = new ArrayList<Integer>();
       
        boolean VULNS = false;
        boolean VULEW = false;
        
        int tmpPlus = 0;
            while(true) {
                if(board+tmpPlus == 1) {VULNS=false; VULEW=false; break;}
                if(board+tmpPlus == 2) {VULNS=true; VULEW=false; break;}
                if(board+tmpPlus == 3) {VULNS=false; VULEW=true; break;}
                if(board+tmpPlus == 4) {VULNS=true; VULEW=true; break;}
                if(board+tmpPlus == 5) {VULNS=true; VULEW=false; break;}
                if(board+tmpPlus == 6) {VULNS=false; VULEW=true; break;}
                if(board+tmpPlus == 7) {VULNS=true; VULEW=true; break;}
                if(board+tmpPlus == 8) {VULNS=false; VULEW=false; break;}
                if(board+tmpPlus == 9) {VULNS=false; VULEW=true; break;}
                if(board+tmpPlus == 10) {VULNS=true; VULEW=true; break;}
                if(board+tmpPlus == 11) {VULNS=false; VULEW=false; break;}
                if(board+tmpPlus == 12) {VULNS=true; VULEW=false; break;}
                if(board+tmpPlus == 13) {VULNS=true; VULEW=true; break;}
                if(board+tmpPlus == 14) {VULNS=false; VULEW=false; break;}
                if(board+tmpPlus == 15) {VULNS=true; VULEW=false; break;}
                if(board+tmpPlus == 16) {VULNS=false; VULEW=true; break;}
                tmpPlus+=16;
                    }
        
        
        for(int i = 0; i < bd.size(); i++) {
            String contract;
            if (bd.get(i).contractResult >=1)
             contract = bd.get(i).contractSize+ bd.get(i).contractType+ bd.get(i).contractDeclarer+"+"+bd.get(i).contractResult;
            else
             contract = bd.get(i).contractSize+ bd.get(i).contractType+ bd.get(i).contractDeclarer+""+bd.get(i).contractResult;
           contract.replaceAll("0", "=");
            int score = cs.scoreNS(contract, VULNS, VULEW, bd.get(i).contractMultiplier);
            
            if(bd.get(i).contractLine == "NS"){MP_NS.add(score); MP_EW.add(score*-1);}
            if(bd.get(i).contractLine == "EW"){MP_NS.add(score*-1); MP_EW.add(score);}
        }
        

Integer[] scoreNS = MP_NS.toArray(new Integer[MP_NS.size()]); Arrays.sort(scoreNS); ArrayUtils.reverse(scoreNS);
Integer[] scoreEW = MP_EW.toArray(new Integer[MP_EW.size()]); Arrays.sort(scoreEW); ArrayUtils.reverse(scoreEW);
        

        
        HashMap<Integer, Integer> MP_GIVE_NS = new HashMap<Integer, Integer>();
        
        int MP = 0;
        for(int i = 0; i<scoreNS.length; i++) {
            for(int a = i+1; a<scoreNS.length; a++) {
                 if(scoreNS[i] > scoreNS[a]) MP+=2;
                 if(scoreNS[i] == scoreNS[a]) MP+=1;
            }
            MP_GIVE_NS.put(scoreNS[i], MP);
            MP=0;
        
        }
        
        HashMap<Integer, Integer> MP_GIVE_EW = new HashMap<Integer, Integer>();
        
        MP = 0;
        for(int i = 0; i<scoreEW.length; i++) {
            for(int a = i+1; a<scoreEW.length; a++) {
                 if(scoreEW[i] > scoreEW[a]) MP+=2;
                 if(scoreEW[i] == scoreEW[a]) MP+=1;
            }
            MP_GIVE_EW.put(scoreEW[i], MP);
            MP=0;
        
        }
        
        
        System.out.println("NS");
        System.out.println(Arrays.toString(scoreNS));
        for (Integer name: MP_GIVE_NS.keySet()){

            String key =name.toString();
            String value = MP_GIVE_NS.get(name).toString();  
            System.out.println(key + " -> " + value);  
            } 
        
        System.out.println("EW");
        System.out.println(Arrays.toString(scoreEW));
        for (Integer name: MP_GIVE_EW.keySet()){

            String key =name.toString();
            String value = MP_GIVE_EW.get(name).toString();  
            System.out.println(key + " -> " + value);  
            } 
        
        for(int i = 0; i < bd.size(); i++) {
            int PairNS = bd.get(i).pairNS;
            int PairEW = bd.get(i).pairEW;
            String contract;
            if (bd.get(i).contractResult >=1)
             contract = bd.get(i).contractSize+ bd.get(i).contractType+ bd.get(i).contractDeclarer+"+"+bd.get(i).contractResult;
            else
             contract = bd.get(i).contractSize+ bd.get(i).contractType+ bd.get(i).contractDeclarer+""+bd.get(i).contractResult;
           contract.replaceAll("0", "=");
            int score = cs.scoreNS(contract, VULNS, VULEW, bd.get(i).contractMultiplier);
            String dec = bd.get(i).contractLine;
            
            if(dec=="NS") {
            double NSOLD = 0;
                if(bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.get(PairNS)!=null)
                 NSOLD = bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.get(PairNS);
            double EWOLD = 0;    
                if(bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.get(PairEW)!=null)
                 EWOLD = bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.get(PairEW);
                
            if(bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.get(PairNS)!=null)
                bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.remove(PairNS);
            if(bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.get(PairEW)!=null)
                bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.remove(PairEW);
            NSOLD+=MP_GIVE_NS.get(score);
            EWOLD+=MP_GIVE_EW.get(score*-1);
            bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.put(PairNS, NSOLD);
            bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.put(PairEW, EWOLD);
            }
            
            if(dec=="EW") {
            double NSOLD = 0; 
                    if(bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.get(PairNS)!=null)
                    NSOLD= bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.get(PairNS);
            double EWOLD=0;
                    if(bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.get(PairEW)!=null)      
                     EWOLD= bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.get(PairEW);
            
            if(bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.get(PairNS)!=null)
                 bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.remove(PairNS);
            if(bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.get(PairEW)!=null)
                 bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.remove(PairEW);
            EWOLD+=MP_GIVE_EW.get(score);
            NSOLD+=MP_GIVE_NS.get(score*-1);
            bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.put(PairNS, NSOLD);
            bridgetournamentcontroller.BridgeTorunamentController.ac.pm.score.put(PairEW, EWOLD);
            }
        }
        
        
    }
}
