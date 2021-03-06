/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManagment;

import java.sql.Time;

/**
 *
 * @author tomas
 */
public class BoardData {
    public int ID = 0;
    /* Number written on board */
    public int boardID = 0;
    public String contractType = "";
    public int contractSize = 0;
    public int contractMultiplier = 0;
    public String contractLine = "";
    public char contractDeclarer = '-';
    public int contractResult = 0;
    public String leadType = "";
    public String leadCard = "";
    
    public int table = 0;
    public int round = 0;
    
    public int pairNS =0;
    public int pairEW =0;
    
    public Time timePlayed = null;
    
    
    public BoardData(int ID, int boardID, String contractType, int contractSize, String contractLine,char contractDeclarer, int contractResult, String leadType, String leadCard, int table, int round, int NS, int EW, int multiplier) {
    this.ID = ID;
    this.boardID = boardID;
    this.contractType = contractType;
    this.contractSize = contractSize;
    this.contractMultiplier = multiplier;
    this.contractLine = contractLine;
    this.contractResult = contractResult;
    this.leadType = leadType;
    this.leadCard = leadCard;
    this.contractDeclarer=contractDeclarer;
    
    this.table = table;
    this.round = round;
    
    this.pairNS = NS;
    this.pairEW = EW;
    }
    
}
