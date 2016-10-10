/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManagment;

import java.util.HashMap;

/**
 *
 * @author uzivatel
 */
public class DataCollector {
   
    
    HashMap<String, Object> objectMail = new HashMap<String, Object>();
    
    public boolean collect(String className, String variableName, String data) {
       if(bridgetournamentcontroller.BridgeTorunamentController.logLevel >= 5) System.out.println("Data collected from "+className+" -> "+data);
        
       // try variableAppend
        tryVariableAppend(variableName, data);
            return true;
    }
    
    public void mailObject(Object o, String code) {
    if(objectMail.containsKey(code)) {System.err.println("Object mail received 2nd object with same 'code' !!! owerwriting"); objectMail.remove(code);}
    objectMail.put(code, o);
    }
            
    public Object receiveObject(String code) {
    Object o = objectMail.get(code);
    objectMail.remove(code);
    return o;
    }
    
    public boolean mailObjectExists(String code) {
    return objectMail.containsKey(code);
    }
    
    
    
    
    private void tryVariableAppend(String variable, String data) {
        boolean updated = false;
        if(variable.equals("tournamentNAME")) {bridgetournamentcontroller.BridgeTorunamentController.vm.tournamentName=data; updated=true;}
        if(variable.equals("databasePath")) {bridgetournamentcontroller.BridgeTorunamentController.vm.databasePath=data; updated=true;}
        if(variable.equals("tournamentExists")) {bridgetournamentcontroller.BridgeTorunamentController.vm.tournamentExists=data; updated=true;}
        if(variable.equals("movementUpdated")) {bridgetournamentcontroller.BridgeTorunamentController.vm.movementUpdated=data; updated=true;}
        if(variable.equals("artificialDatabaseEnabled")) {bridgetournamentcontroller.BridgeTorunamentController.vm.artificialDatabaseEnabled=data; updated=true;}
        if(variable.equals("ACMovementRunning")) {bridgetournamentcontroller.BridgeTorunamentController.vm.ACMovementRunning=data; updated=true;}
        if(variable.equals("ACPlayerManagerRunning")) {bridgetournamentcontroller.BridgeTorunamentController.vm.ACPlayerManagerRunning=data; updated=true;}
        
    
    }
}
