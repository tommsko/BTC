/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoring;

/**
 *
 * @author tomas
 */
public class ContractScorer {
    
    public int scoreNS(String contract, boolean vulneableNS,boolean vulneableEW , int multiplier) {
    char type = contract.charAt(1);
    int  size = Integer.parseInt(String.valueOf(contract.charAt(0)));
    char declarer = contract.charAt(2);
    int overTricks = 0;
    int underTricks = 0;
    if(contract.charAt(3) == '=') {}
    if(contract.charAt(3) == '-') {underTricks=Integer.parseInt(String.valueOf(contract.charAt(4)));} 
    if(contract.charAt(3) == '+') {overTricks=Integer.parseInt(String.valueOf(contract.charAt(4)));}   
    boolean vulneable = false;
    if((declarer == 'S' || declarer == 'N') && (vulneableNS == true)) {vulneable=true;}
    if((declarer == 'E' || declarer == 'W') && (vulneableEW == true)) {vulneable=true;}
    
    int scoreNS = 0;
   
    int contractScore=  0;
    if(type=='S' || type=='H') {contractScore=30*multiplier*size;}
    if(type=='D' || type=='C') {contractScore=20*multiplier*size;}
    if(type=='N') {contractScore=(40*multiplier+((size-1)*30*multiplier));}
    
    int overTrickScore = 0;
    if(multiplier == 1) {
         if(vulneable == false) {
             if(type=='S' || type=='H') {overTrickScore=30*overTricks;}
             if(type=='D' || type=='C') {overTrickScore=20*overTricks;}
             if(type=='N') {overTrickScore=30*overTricks;}   
                                }
             if(vulneable == true) {
             if(type=='S' || type=='H') {overTrickScore=30*overTricks;}
             if(type=='D' || type=='C') {overTrickScore=20*overTricks;}
             if(type=='N') {overTrickScore=30*overTricks;}   
                                }
                        }
    
    if(multiplier == 2) {
        if(vulneable == false) {overTrickScore=100*overTricks;}
        if(vulneable == true) {overTrickScore=200*overTricks;}
                        }
    
    if(multiplier == 4) {
        if(vulneable == false) {overTrickScore=200*overTricks;}
        if(vulneable == true) {overTrickScore=400*overTricks;}
                        }
    
    int slamBonusScore = 0;
    if(size == 6) {
        if(vulneable == false) {slamBonusScore=500;}
        if(vulneable == true)  {slamBonusScore=750;}
    }
    if(size == 7) {
        if(vulneable == false) {slamBonusScore=1000;}
        if(vulneable == true)  {slamBonusScore=1500;}
    }
    
    int doubleBonusScore = 0;
    if(multiplier == 2) doubleBonusScore = 50;
    if(multiplier == 4) doubleBonusScore = 100;
    
    int penaltyScore = 0;
    if(vulneable == false) {
             if(multiplier == 1) {penaltyScore=50*underTricks;}
             if(multiplier == 2) {
                    // first undertrick exitsts
                    if(underTricks>0) {penaltyScore+=100;}
                    // second undertrick exitsts
                    if(underTricks>1) {penaltyScore+=200;}
                    // third undertrick exitsts
                    if(underTricks>2) {penaltyScore+=200;}
                    // 4+ undertrick exitst
                    if(underTricks>3) {penaltyScore+=(underTricks-3)*300;}
                                 }
             if(multiplier == 4) {
                    // first undertrick exitsts
                    if(underTricks>0) {penaltyScore+=200;}
                    // second undertrick exitsts
                    if(underTricks>1) {penaltyScore+=400;}
                    // third undertrick exitsts
                    if(underTricks>2) {penaltyScore+=400;}
                    // 4+ undertrick exitst
                    if(underTricks>3) {penaltyScore+=(underTricks-3)*600;}
                                 }
             
                                }
    
    if(vulneable == true) {
             if(multiplier == 1) {penaltyScore=100*underTricks;}
             if(multiplier == 2) {
                    // first undertrick exitsts
                    if(underTricks>0) {penaltyScore+=200;}
                    // second undertrick exitsts
                    if(underTricks>1) {penaltyScore+=300;}
                    // third undertrick exitsts
                    if(underTricks>2) {penaltyScore+=300;}
                    // 4+ undertrick exitst
                    if(underTricks>3) {penaltyScore+=(underTricks-3)*300;}
                                 }
             if(multiplier == 4) {
                    // first undertrick exitsts
                    if(underTricks>0) {penaltyScore+=400;}
                    // second undertrick exitsts
                    if(underTricks>1) {penaltyScore+=600;}
                    // third undertrick exitsts
                    if(underTricks>2) {penaltyScore+=600;}
                    // 4+ undertrick exitst
                    if(underTricks>3) {penaltyScore+=(underTricks-3)*600;}
                                 }
             
                               }
    
    int gameScoreBonus = 0;
    if(contractScore <100 )gameScoreBonus=50;
    if(contractScore >=100) {
        if(vulneable==false) {gameScoreBonus=300;}
        if(vulneable==true) {gameScoreBonus=500;}
                            }
    
    // contractScore , overTrickScore, slamBonusScore, doubleBonusScore, penaltyScore, gameScoreBonus
    
    if(overTricks == 0 && underTricks == 0) {
    scoreNS=contractScore+overTrickScore+slamBonusScore+doubleBonusScore+gameScoreBonus;
    }
    if(overTricks > 0) {
    scoreNS=contractScore+overTrickScore+slamBonusScore+doubleBonusScore+gameScoreBonus;
    }
    if(underTricks>0) {
    scoreNS=penaltyScore*-1;
    }
    
    if(declarer == 'S' || declarer == 'N') {}
    if(declarer == 'E' || declarer == 'W') {scoreNS = scoreNS*-1;}
    
        return scoreNS;
    }
}
