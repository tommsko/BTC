/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManagment;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import tournamentManagment.Movement;
import java.nio.file.Files;
import tournamentManagment.PairManager;

/**
 *
 * @author uzivatel
 */
public class ArtificialDatabase {
    

    public HashMap<Integer,ArrayList<BoardData>> bdata = new HashMap<Integer,ArrayList<BoardData>>();
    public Movement m;
    public PairManager pm;
    private  Thread databaseRead = null;
    
    public static boolean enableAutoRead = true;
    public static int autoReadSeconds = 60;
    
    public void start() {   
     pm = new PairManager();     
    }
    
    
    public void stop() {
        if(databaseRead != null)
    databaseRead.stop();
    }
    
    public void tickRead() {
        
        
         databaseRead = new Thread(new Runnable() {
            @Override
            public void run() {
                int tmp = 0;
                File f = new File("./databases/tmp/"); 
                if(f.isDirectory() && f.exists()) deleteFolder(f);
                 f.mkdir(); f.deleteOnExit();
           while(enableAutoRead) {

               try {
                   
                   Files.copy(new File(bridgetournamentcontroller.BridgeTorunamentController.vm.databasePath).toPath(),
                           new File("./databases/tmp/tmp"+tmp+".bws").toPath());
                   File fr = new File("./databases/tmp/tmp"+tmp+".bws");
               Connection conn = conn=DriverManager.getConnection("jdbc:ucanaccess://"+fr.getAbsolutePath());
               bdata = new HashMap<Integer,ArrayList<BoardData>>(); 
               bdata= readDatabase(bridgetournamentcontroller.BridgeTorunamentController.vm.databasePath, m.HIGHESTBOARD, conn);
                  conn.close();
                   System.gc();
                   tmp++;
               } catch (SQLException ex) {
                   Logger.getLogger(ArtificialDatabase.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(ArtificialDatabase.class.getName()).log(Level.SEVERE, null, ex);
               }
               try {
                   Thread.currentThread().sleep(autoReadSeconds*1000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(ArtificialDatabase.class.getName()).log(Level.SEVERE, null, ex);
               }
           
           }
            }
        });
        databaseRead.start();
       
    }
    

    
    
    public HashMap<Integer,ArrayList<BoardData>> readDatabase(String database,int highBoard, Connection conn) throws SQLException {
    int results = 1;
    // detect number of results + parse them
    while(true) {
        if(conn == null) {throw new IllegalStateException("Database connection null!");}
    Statement s = conn.createStatement();
ResultSet rs = s.executeQuery("SELECT * FROM [ReceivedData] WHERE ID="+results); 
if(rs.next()) {
     int ID = Integer.parseInt(rs.getString(1));
     int boardID = Integer.parseInt(rs.getString(5));
     String contractType = rs.getString(10).split(" ")[1];
     int contractSize = Integer.parseInt(rs.getString(10).split(" ")[0]);
     int multiplier = 1;
     
     // exists double/redouble
     if(rs.getString(10).split(" ").length >= 3) {
     if(rs.getString(10).split(" ")[2].equals("x")) multiplier=2;
     if(rs.getString(10).split(" ")[2].equals("xx")) multiplier=4;
     }
     
     
     String contractLine = ""; if(rs.getString(9).charAt(0) == 'N' || rs.getString(9).charAt(0) == 'S') contractLine="NS"; else contractLine="EW";
     char contractDeclarer = rs.getString(9).charAt(0);
     int contractResult = Integer.parseInt(rs.getString(11).replace("=", "0"));
//     String leadType = String.valueOf(rs.getString(12).charAt(0));
String leadType = "0"; String leadCard = "0";
//     String leadCard = String.valueOf(rs.getString(12).replace("1", "T").charAt(1));
     boolean DELETED = rs.getBoolean(21);
     int table =Integer.parseInt(rs.getString(3));
     int round =Integer.parseInt(rs.getString(4));

     int NS = Integer.parseInt(rs.getString(6));
     int EW = Integer.parseInt(rs.getString(7));
     
     if(!DELETED) {
BoardData bd = new BoardData(ID, boardID, contractType, contractSize, contractLine, contractDeclarer, contractResult, leadType, leadCard,table,round,NS,EW, multiplier);
ArrayList<BoardData> bda = bdata.get(boardID);
if(bda ==null) bda=new ArrayList<BoardData>();
bda.add(bd);
bdata.put(boardID, bda);
     }
     rs.close();
     s.close();
     
System.out.println("Result Nb. "+ID+" on board "+boardID+" contract "+contractType+" of size"+contractSize+" | "+contractLine+" | "+contractDeclarer+""
       + " with result "+contractResult+" multiplier "+multiplier+" and lead "+leadType+"."+leadCard+" with DEL "+DELETED); results++; 
} else break;
    }
    
//        System.out.println("Found "+(results-1)+" results!");

    
     //   conn.close();
        return bdata;
    }

    
    
    public static void deleteFolder(File folder) {
    File[] files = folder.listFiles();
    if(files!=null) { //some JVMs return null for empty dirs
        for(File f: files) {
            if(f.isDirectory()) {
                deleteFolder(f);
            } else {
                f.delete();
            }
        }
    }
    folder.delete();
}
    
}
