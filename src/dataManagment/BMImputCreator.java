/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManagment;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Types;
import java.util.Date;
import java.util.UUID;
import static java.util.jar.Pack200.Packer.PASS;
import java.util.logging.Level;
import java.util.logging.Logger;
import tournamentManagment.Movement;


/**
 *
 * @author uzivatel
 */
public class BMImputCreator {
    
    public static String databaseName = "";
   
    public static void createDatabase(Movement m) throws IOException, SQLException {
        System.out.println("Creating BMImput database for movement "+m.name);
    String dbFileSpec = "tournaments/"+bridgetournamentcontroller.BridgeTorunamentController.vm.tournamentName+"/databases/BMImput.bws";
  Database db = DatabaseBuilder.create(Database.FileFormat.V2000,new File(dbFileSpec));
        Table clientTable = new TableBuilder("Clients")
                .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER))
                .addColumn(new ColumnBuilder("Computer").setSQLType(Types.VARCHAR))
                .toTable(db);
        clientTable.addRow(1, "DESKTOP-267TKVI");
        

        Table sessionTable = new TableBuilder("Session")
                .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER))
                .addColumn(new ColumnBuilder("Name").setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Date").setSQLType(Types.DATE))
                .addColumn(new ColumnBuilder("Time").setSQLType(Types.TIME))
                .addColumn(new ColumnBuilder("GUID").setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Status").setSQLType(Types.TIME))
                .addColumn(new ColumnBuilder("ShowInApp").setSQLType(Types.VARCHAR))
                .toTable(db);
        Date d = new Date();
        Time t = new Time(System.currentTimeMillis());
        UUID uuid = new UUID(1, 5);
        String GUID = new UUID(14445, 15554).randomUUID().toString();
        sessionTable.addRow(1, "BRC game", d, t, GUID,0,0);
        
        Table sectionTable = new TableBuilder("Section")
                .addColumn(new ColumnBuilder("ID").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Letter").setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Tables").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("MissingPair").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("EWMoveBeforePlay").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Session").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("ScoringType").setSQLType(Types.SMALLINT))
                .toTable(db);
        sectionTable.addRow(1, "A", m.tables,m.MISSING,0,1,1);
        
        Table tableTable = new TableBuilder("Tables")
                .addColumn(new ColumnBuilder("Section").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Table").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("ComputerID").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Status").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("LogOnOff").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("UpdateFromRound").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("CurrentRound").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("CurrentBoard").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Group").setSQLType(Types.SMALLINT))
                .toTable(db);
        for(int i = 1; i <= m.tables; i++)
        tableTable.addRow(1,i, 1,1,2,0,0, 0,0);
        
        Table roundDataTable = new TableBuilder("RoundData")
                .addColumn(new ColumnBuilder("Section").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Table").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Round").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("NSpair").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("EWpair").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("LowBoard").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("HighBoard").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("CustomBoards").setSQLType(Types.VARCHAR))
                .toTable(db);
        for(Integer[] i : m.roundData)
        roundDataTable.addRow(i[0],i[2],i[1],i[3],i[4],i[5],i[6],null);
   
        Table recivedDataTable = new TableBuilder("ReceivedData")
                .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER).setAutoNumber(true))
                .addColumn(new ColumnBuilder("Section").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Table").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Round").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Board").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("PairNS").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("PairEW").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Declarer").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("NS/EW").setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Contract").setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Result").setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("LeadCard").setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Remarks").setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("DateLog").setSQLType(Types.DATE))
                .addColumn(new ColumnBuilder("TimeLog").setSQLType(Types.TIME))
                .addColumn(new ColumnBuilder("Processed").setSQLType(Types.BOOLEAN))
                .addColumn(new ColumnBuilder("Processed1").setSQLType(Types.BOOLEAN))
                .addColumn(new ColumnBuilder("Processed2").setSQLType(Types.BOOLEAN))
                .addColumn(new ColumnBuilder("Processed3").setSQLType(Types.BOOLEAN))
                .addColumn(new ColumnBuilder("Processed4").setSQLType(Types.BOOLEAN))
                .addColumn(new ColumnBuilder("Erased").setSQLType(Types.BOOLEAN))
                .addColumn(new ColumnBuilder("ExternalUpdate").setSQLType(Types.BOOLEAN))
                
                .toTable(db);
        
        /*Table intermediateData = new TableBuilder("IntermediateData")
        .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("Section").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("Table").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("Round").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("Board").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("PairNS").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("PairEW").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("Declarer").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("NS/EW").setSQLType(Types.VARCHAR))
        .addColumn(new ColumnBuilder("Contract").setSQLType(Types.VARCHAR))
        .addColumn(new ColumnBuilder("Result").setSQLType(Types.VARCHAR))
        .addColumn(new ColumnBuilder("LeadCard").setSQLType(Types.VARCHAR))
        .addColumn(new ColumnBuilder("Remarks").setSQLType(Types.VARCHAR))
        .addColumn(new ColumnBuilder("DateLog").setSQLType(Types.DATE))
        .addColumn(new ColumnBuilder("TimeLog").setSQLType(Types.TIME))
        .addColumn(new ColumnBuilder("Processed").setSQLType(Types.BOOLEAN))
        .addColumn(new ColumnBuilder("Ereased").setSQLType(Types.BOOLEAN))
        .toTable(db);*/
        
        Table playerNumbersData = new TableBuilder("PlayerNumbers")
                .addColumn(new ColumnBuilder("Section").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Table").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Direction").setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Number").setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Name").setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("Updated").setSQLType(Types.BOOLEAN))
                .addColumn(new ColumnBuilder("Processed").setSQLType(Types.BOOLEAN))
                .addColumn(new ColumnBuilder("TimeLog").setSQLType(Types.TIME))
                .addColumn(new ColumnBuilder("Round").setSQLType(Types.SMALLINT))
                .toTable(db);
        
        Table playerNamesData = new TableBuilder("PlayerNames")
                .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER))
                .addColumn(new ColumnBuilder("Name").setSQLType(Types.VARCHAR))
                .addColumn(new ColumnBuilder("strID").setSQLType(Types.VARCHAR))
                .toTable(db);
        
//        Table settingsData = new TableBuilder("Settings")
//                .toTable(db);
        
       // Table biddingDataTable = new TableBuilder("BiddingData")
       //         .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER))
       //         .addColumn(new ColumnBuilder("Section").setSQLType(Types.INTEGER))
       //         .addColumn(new ColumnBuilder("Table").setSQLType(Types.INTEGER))
       //         .addColumn(new ColumnBuilder("Board").setSQLType(Types.INTEGER))
       //         .addColumn(new ColumnBuilder("Counter").setSQLType(Types.INTEGER))
       //         .addColumn(new ColumnBuilder("Direction").setSQLType(Types.INTEGER))
       //         .addColumn(new ColumnBuilder("Bid").setSQLType(Types.INTEGER))
       //         .addColumn(new ColumnBuilder("DateLog").setSQLType(Types.DATE))
       //         .addColumn(new ColumnBuilder("TimeLog").setSQLType(Types.TIME))
       //         .addColumn(new ColumnBuilder("Erased").setSQLType(Types.BOOLEAN))
       //         .toTable(db);
        
        Table HandEvaluationTable = new TableBuilder("HandEvaluation")
                .addColumn(new ColumnBuilder("Section").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Board").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("NorthSpades").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("NorthHearts").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("NorthDiamonds").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("NorthClubs").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("NorthNotrump").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("EastSpades").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("EastHearts").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("EastDiamonds").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("EastClubs").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("EastNotrump").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("SouthSpades").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("SouthHearts").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("SouthDiamonds").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("SouthClubs").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("SouthNotrump").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("WestSpades").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("WestHearts").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("WestDiamonds").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("WestClubs").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("NorthHcp").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("EastHcp").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("SouthHcp").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("WestHcp").setSQLType(Types.SMALLINT))
                .toTable(db);
        
        Table HandRecordTable = new TableBuilder("HandRecord")
                .addColumn(new ColumnBuilder("Section").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("Board").setSQLType(Types.SMALLINT))
                .addColumn(new ColumnBuilder("NorthSpades").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("NorthHearts").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("NorthDiamonds").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("NorthClubs").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("EastSpades").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("EastHearts").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("EastDiamonds").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("EastClubs").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("SouthSpades").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("SouthHearts").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("SouthDiamonds").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("SouthClubs").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("WestSpades").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("WestHearts").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("WestDiamonds").setSQLType(Types.NVARCHAR))
                .addColumn(new ColumnBuilder("WestClubs").setSQLType(Types.NVARCHAR))
                .toTable(db);
        
        
        /* Table playDataTable = new TableBuilder("PlayData")
        .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("Section").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("Table").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("Round").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("Board").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("Counter").setSQLType(Types.INTEGER))
        .addColumn(new ColumnBuilder("Direction").setSQLType(Types.VARCHAR))
        .addColumn(new ColumnBuilder("Card").setSQLType(Types.VARCHAR))
        .addColumn(new ColumnBuilder("DateLog").setSQLType(Types.DATE))
        .addColumn(new ColumnBuilder("TimeLog").setSQLType(Types.TIME))
        .addColumn(new ColumnBuilder("Erased").setSQLType(Types.BOOLEAN))
        .toTable(db);*/

        
        db.flush();
        db.close();
        
        databaseName = new File("tournaments/"+bridgetournamentcontroller.BridgeTorunamentController.vm.tournamentName+"/databases/BMImput.bws").getAbsolutePath();
        bridgetournamentcontroller.BridgeTorunamentController.dc.collect("DatabaseManager", "databasePath", databaseName);
                
    }
    
    
    public void useDatabase() {
    databaseName = new File("tournaments/"+bridgetournamentcontroller.BridgeTorunamentController.vm.tournamentName+"/databases/BMImput.bws").getAbsolutePath();
        bridgetournamentcontroller.BridgeTorunamentController.dc.collect("DatabaseManager", "databasePath", databaseName);
    }

    
}
