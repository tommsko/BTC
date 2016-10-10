/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManagment;

import java.sql.*;
import java.util.*;
/**
 *
 * @author tomas
 */
public class DatabaseConnector {
    
    HashMap<Integer,ArrayList<BoardData>> bdata = new HashMap<Integer,ArrayList<BoardData>>();
    
    public HashMap<Integer,ArrayList<BoardData>> readDatabase(String database,int highBoard, int expectedResults) throws SQLException {
    Connection conn=DriverManager.getConnection("jdbc:ucanaccess://"+database);
    int results = 1;
    bdata.clear(); // empty local database
    // detect number of results + parse them
    while(true) {
    Statement s = conn.createStatement();
ResultSet rs = s.executeQuery("SELECT * FROM [ReceivedData] WHERE ID="+results); 
if(rs.next()) {
     int ID = results;
     int boardID = Integer.parseInt(rs.getString(5));
     String contractType = rs.getString(10).split(" ")[1];
     int contractSize = Integer.parseInt(rs.getString(10).split(" ")[0]);
     String contractLine = ""; if(rs.getString(9).charAt(0) == 'N' || rs.getString(9).charAt(0) == 'S') contractLine="NS"; else contractLine="EW";
     char contractDeclarer = rs.getString(9).charAt(0);
     int contractResult = Integer.parseInt(rs.getString(11).replace("=", "0"));
     String leadType = String.valueOf(rs.getString(12).charAt(0));
     String leadCard = String.valueOf(rs.getString(12).replace("1", "T").charAt(1));
     boolean DELETED = rs.getBoolean(21);
     int table =Integer.parseInt(rs.getString(3));
     int round =Integer.parseInt(rs.getString(4));

     
     if(!DELETED) {
//BoardData bd = new BoardData(ID, boardID, contractType, contractSize, contractLine, contractDeclarer, contractResult, leadType, leadCard,table,round);
ArrayList<BoardData> bda = bdata.get(boardID);
if(bda ==null) bda=new ArrayList<BoardData>();
//bda.add(bd);
bdata.put(boardID, bda);
     }
System.out.println("Result Nb. "+ID+" on board "+boardID+" contract "+contractType+" of size"+contractSize+"|"+contractLine+"|"+contractDeclarer+""
        + " with result "+contractResult+" and lead "+leadType+"."+leadCard+" with DEL "+DELETED); results++; 
} else break;
    }
    
        System.out.println("Found "+results+" results!");

    
  
     
        conn.close();
        return bdata;
    }
    
}
