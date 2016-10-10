/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgetournamentcontroller;

import dataManagment.BoardData;

/**
 *
 * @author uzivatel
 */
public class TW {
    
    int[] expectedResults;
    int round;
    int boardsPerTable;
    int tables;
    int average = 0;
    int null_table = 0;
    
    public void createTimeWatcher(int tables, int boardsPerTable, int round, long startTime, int null_table) {
        
        expectedResults = new int[tables];
        for(int i = 0; i < tables; i++) expectedResults[i] = boardsPerTable;
        this.round = round;
        this.boardsPerTable = boardsPerTable;
        this.tables = tables;
        this.null_table = null_table;
        
        if(null_table != 0)
        expectedResults[null_table-1] = 0;
    }
    
    public void startappendToTimeWatcher() {
for(int i = 0; i < tables; i++) expectedResults[i] = boardsPerTable;
if(null_table != 0)
        expectedResults[null_table-1] = 0;

    }
    
    public void appendToTimeWatcher(BoardData[] bd) {

        for(int i = 0; i < bd.length; i++) {
if(bd[i].round == round) expectedResults[bd[i].table-1]--;
        }
    }
    
    public void checkTimeWatcher() {
int all = 0;
        for(int i = 0; i <tables; i++) {
            System.out.println("Missing scores for table "+(i+1)+": "+expectedResults[i]);
            all+=expectedResults[i];

        }
        if(tables == 0) return;
        
        if(null_table != 0)
        average = all/(tables-1);
        
        if(null_table == 0)
        average = all/tables;
    }
    
    public int getTables() {return tables;}
    
    public int getMissingForTable(int table) {return expectedResults[table]; }
    
    public int getAverage() {return average;}
    
}
