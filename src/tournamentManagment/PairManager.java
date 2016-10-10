/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournamentManagment;

import java.util.HashMap;

/**
 *
 * @author uzivatel
 */
public class PairManager {
   public HashMap<Integer, String[]> players = new HashMap<Integer, String[]>();
   public HashMap<Integer, Double> score = new HashMap<Integer, Double>();
   
   
   // empty database
   public void start() {
       String[] empty = new String[2]; empty[0] = ""; empty[1] = "";
       
       
   for(int i = 1; i <= bridgetournamentcontroller.BridgeTorunamentController.ac.m.pairs; i++) {
   players.put(i, empty );
   }
   
   
   
   for(int i = 1; i <= bridgetournamentcontroller.BridgeTorunamentController.ac.m.pairs; i++) {
   score.put(i, 0.0 );
   }
   
   
   }
   
  
   
   public void printScore() {
    for (Integer name: score.keySet()){

            String key =name.toString();
            String value = score.get(name).toString();  
            System.out.println(key + " (Pair)->(MP) " + value);  
            }
   }
   
   
    
    
    
}
