/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgetournamentcontroller;

import dataManagment.DataCollector;
import GUI.mainGUI;
import dataManagment.ArtificialDatabase;
import dataManagment.BMImputCreator;
import dataManagment.VariableManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import dataManagment.BoardData;
import dataManagment.DatabaseConnector;
import dataManagment.DealProcessor;

/**
 *
 * @author tomas
 */
public class BridgeTorunamentController {

    /**
     * 
     */
    public static DataCollector dc = new DataCollector();
    public static VariableManager vm = new VariableManager();
    
    public static ArtificialDatabase ac = new ArtificialDatabase();
    
    
    public static int logLevel = 5; // 5 - all, 
    
    
    public static void main(String[] args) throws SQLException {
        
        String dealFile = "310516.dlm";
        String playableFile = "310516.kbl";
        String databasefile = "C:\\PairsScorer\\Databases\\Event137-May31-2016.bws";
        int highBoard = 26;
        
       
        System.out.println("Starting BTC...");
        
        
        mainGUI gui = new mainGUI();
        gui.setVisible(true);
        
        
/*        
      BRC brc = new BRC(dealFile,playableFile);
      
      BoardData[] bd1 = new BoardData[6];
      bd1[0] = new BoardData(0,1, "C", 2, "NS",'N', 0, "D", "J");
      bd1[1] = new BoardData(1,1, "C", 2, "NS",'N', -1, "D", "J");
      bd1[2] = new BoardData(2,1, "C", 1, "NS",'N', 0, "D", "J");
      bd1[3] = new BoardData(3,1, "C", 1, "NS",'N', 0, "D", "J");
      bd1[4] = new BoardData(4,1, "H", 1, "EW",'E', 0, "S", "K");
      bd1[5] = new BoardData(5,1, "H", 1, "EW",'E', 0, "S", "K");
      
     brc.lineError(bd1);
     brc.contractError(bd1);
     brc.contractSizeError(bd1);
     brc.contractResultError(bd1);
     brc.playableError(bd1);
     brc.leadError(bd1);
     brc.trumphError(bd1); 
     brc.contractPointError(bd1); // TODO
     brc.scoreError(bd1); // TODO
     */ 
/*
        DatabaseConnector dc = new DatabaseConnector();
        HashMap<Integer,ArrayList<BoardData>> bdata= dc.readDatabase(databasefile, 28, 100);
        
        ArrayList<Integer> ISOK_ID = new ArrayList<Integer>();
        ISOK_ID.add(21); // WORKS
        
        
       for(int i = 1; i <= highBoard; i++) { 
        if(bdata.get(i) == null) continue;
        BoardData[] bdx = new BoardData[bdata.get(i).size()];
        bdx = bdata.get(i).toArray(bdx);

 BRC brc = new BRC(dealFile,playableFile, ISOK_ID);

     brc.lineError(bdx);
     brc.contractError(bdx);
     brc.contractSizeError(bdx);
     brc.contractResultError(bdx);
     brc.playableError(bdx);
     brc.leadError(bdx);
     brc.trumphError(bdx); 
     brc.contractPointError(bdx); // TODO
     brc.scoreError(bdx); // TODO

       }
     */
    }
    
}
