/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentManagment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author uzivatel
 */
public class Movement {
    
    // general info
    public String name = "";
    
    
    public int tables = 0;
    public int pairs = 0;
    public int MISSING = 0;
    
    
    public int HIGHESTBOARD;
    public int[] expectedBoardResults;
    
    public ArrayList<Integer[]> roundData = new ArrayList<Integer[]>();
    
    public void readMovement(String path) throws IOException {
    try(BufferedReader br = new BufferedReader(new FileReader(path))) {
    for(String line; (line = br.readLine()) != null; ) {
        
        // filter for movement info settings
        if(line.startsWith("#NAME=")) {name = line.substring(6); continue;}
        if(line.startsWith("#DES=")) continue;
        
       if(tables == 0) {
       tables = Integer.parseInt(line.split("-")[0]);
       pairs = Integer.parseInt(line.split("-")[1]);
       MISSING = Integer.parseInt(line.split("-")[2]);
       } else {
       // ENTER ROUND DATA, SECTION, ROUND, TABLE, NS EW LOW HIGH **NOT CUSTOM**
       
       Integer[] data = new Integer[7];
       
       data[0] = Integer.parseInt(line.split("-")[0]);
       data[1] = Integer.parseInt(line.split("-")[1]);
       data[2] = Integer.parseInt(line.split("-")[2]);
       data[3] = Integer.parseInt(line.split("-")[3]);
       data[4] = Integer.parseInt(line.split("-")[4]);
       data[5] = Integer.parseInt(line.split("-")[5]);
       data[6] = Integer.parseInt(line.split("-")[6]);
       roundData.add(data);


if(data[6] > HIGHESTBOARD) HIGHESTBOARD = data[6];
       
       }
    }
    }
    
    expectedBoardResults = new int[HIGHESTBOARD+1];
    int tmp = 0;
    try(BufferedReader br = new BufferedReader(new FileReader(path))) {
    for(String line; (line = br.readLine()) != null; ) {
      
        // filter for movement info settings
        if(line.startsWith("#NAME=")) continue;
        if(line.startsWith("#DES=")) continue;
        
        if(tmp == 0) {
           tmp = 1;
       } else {
       int low = Integer.parseInt(line.split("-")[5]);
       int high = Integer.parseInt(line.split("-")[6]);  
       
       for(int i = low; i <= high; i++) {
       expectedBoardResults[i]++;
       }
    }
    
    }
}

}
}