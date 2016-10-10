/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManagment;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;
/**
 *
 * @author tomas
 */
public class DealProcessor {
    public String decodeDeal(int board, String fileName) {
      

    String data[] = new String[1000];
    int counter = 0;

    try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
    String line = "";

    while (line != null) {

        line = br.readLine();
        if(line != null)
        if(line.split(" ")[0].equals("Board")) {data[counter] = line.split(" ")[1]; counter++;}
    }
}       catch (Exception ex) {
            Logger.getLogger(DealProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    

  
        
    
    String DATA = data[board-1].substring(3,29);
    //"01=gmaphcbcjlfbphekjcoldmglee015";
    String tmp = "";
 
    for(int i = 0; i < DATA.length(); i++) {

        switch(DATA.charAt(i)) {
           case 'a': tmp+="NN"; break;
           case 'b': tmp+="NE"; break;
           case 'c': tmp+="NS"; break;
           case 'd': tmp+="NW"; break;
           case 'e': tmp+="EN"; break;
           case 'f': tmp+="EE"; break;
           case 'g': tmp+="ES"; break;
           case 'h': tmp+="EW"; break;
           case 'i': tmp+="SN"; break;
           case 'j': tmp+="SE"; break;
           case 'k': tmp+="SS"; break;
           case 'l': tmp+="SW"; break;
           case 'm': tmp+="WN"; break;
           case 'n': tmp+="WE"; break;
           case 'o': tmp+="WS"; break;
           case 'p': tmp+="WW"; break;
        }
    }
    
String pik = "";
String srdce = "";
String karo = "";
String tref = "";
for(int i = 0; i < 52; i++) {
  if(i >= 0 && i < 13) {pik+=tmp.charAt(i);}
  if(i >= 13 && i < 26) {srdce+=tmp.charAt(i);}
  if(i >= 26 && i < 39) {karo+=tmp.charAt(i);}
  if(i >= 39 && i < 52) {tref+=tmp.charAt(i);}


}


String N = "";
String S = "";
String E = "";
String W = "";
char porad[] = {'A','K','Q','J','T','9','8','7','6','5','4','3','2'};
for(int i = 0; i < 13; i++) {
  if(pik.charAt(i) == 'N') {N+=" p"; N+=porad[i];}
  if(pik.charAt(i) == 'S') {S+=" p"; S+=porad[i];}
  if(pik.charAt(i) == 'E') {E+=" p"; E+=porad[i];}
  if(pik.charAt(i) == 'W') {W+=" p"; W+=porad[i];}


}
for(int i = 0; i < 13; i++) {
  if(srdce.charAt(i) == 'N') {N+=" s"; N+=porad[i];}
  if(srdce.charAt(i) == 'S') {S+=" s"; S+=porad[i];}
  if(srdce.charAt(i) == 'E') {E+=" s"; E+=porad[i];}
  if(srdce.charAt(i) == 'W') {W+=" s"; W+=porad[i];}


}
for(int i = 0; i < 13; i++) {
  if(karo.charAt(i) == 'N') {N+=" k"; N+=porad[i];}
  if(karo.charAt(i) == 'S') {S+=" k"; S+=porad[i];}
  if(karo.charAt(i) == 'E') {E+=" k"; E+=porad[i];}
  if(karo.charAt(i) == 'W') {W+=" k"; W+=porad[i];}


}
for(int i = 0; i < 13; i++) {
  if(tref.charAt(i) == 'N') {N+=" t"; N+=porad[i];}
  if(tref.charAt(i) == 'S') {S+=" t"; S+=porad[i];}
  if(tref.charAt(i) == 'E') {E+=" t"; E+=porad[i];}
  if(tref.charAt(i) == 'W') {W+=" t"; W+=porad[i];}


}

// P -PIK
String retur = N +"$" + S +"$"  + E +"$" + W;
return retur;
    }
    
    public String decodePlayable(int board,String fileName) {
      
    String data2[] = new String[1000];
    int counter = 0;

    try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
    String line = "";

    while (line != null) {
        line = br.readLine();
        if(line == null) continue;
        if(line.split("	").length != 31) continue;
        
        String NN, NP, NS, NK, NT , SN, SP, SS, SK, ST, EN, EP, ES, EK, ET, WN, WP, WS, WK, WT = ""; // N S E W for sides, N for notrumph, P for piky, S for srdce K for karo and T for tref
        NN=line.split("	")[7];
        SN=line.split("	")[8];
        EN=line.split("	")[9];
        WN=line.split("	")[10];
        
        NP=line.split("	")[12];
        SP=line.split("	")[13];
        EP=line.split("	")[14];
        WP=line.split("	")[15];
        
        NS=line.split("	")[17];
        SS=line.split("	")[18];
        ES=line.split("	")[19];
        WS=line.split("	")[20];
        
        NK=line.split("	")[22];
        SK=line.split("	")[23];
        EK=line.split("	")[24];
        WK=line.split("	")[25];
        
        NT=line.split("	")[27];
        ST=line.split("	")[28];
        ET=line.split("	")[29];
        WT=line.split("	")[30];
        
                data2[counter] = NN+" "+NP+" "+NS+" "+NK+" "+NT+"$"+SN+" "+SP+" "+SS+" "+SK+" "+ST+"$"+EN+" "+EP+" "+ES+" "+EK+" "+ET+"$"+WN+" "+WP+" "+WS+" "+WK+" "+WT;;
                counter++;
        
       
    }
}       catch (Exception ex) {
            Logger.getLogger(DealProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  
        
        return data2[board-1];
    }
    
}
