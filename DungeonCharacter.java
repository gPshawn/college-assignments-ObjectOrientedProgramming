/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passosghw2;

import java.util.Random;

/**
 *
 * @author andrehirai
 */
abstract class DungeonCharacter {
   private String name;
   private int hitPoints;
   private int atSpeed;
   private int mDamageR;
   private int MDamageR;
   private double chanceH;
   
   
   public DungeonCharacter(String name,int hitPoints,int atSpeed,double chanceH,int mDamageR,int MDamageR){
        this.name = name;
        this.atSpeed = atSpeed;
        this.hitPoints = hitPoints;
        this.chanceH = chanceH;
        this.mDamageR = mDamageR;
        this.MDamageR = MDamageR;
        
        
        
        
   }
   //incomplete
   public int Attack(String nhero,String nMonster){
     Random rdm = new Random();
     Random rdm2 = new Random();
       
       if(rdm.nextDouble() <= chanceH){
        int randomNum = rdm2.nextInt((MDamageR - mDamageR) + 1) + mDamageR; 
        System.out.println("   "+ nMonster + " hit for <" + randomNum + "> points damage.");
        return randomNum;  
     }
      System.out.println("   "+nhero + "'s attack on " + nMonster + " has failed!");
      return 0;
      
   }
   
   public int getAtSpeed(){
    return atSpeed;
   }
   
   public int getHitPoints(){
    return hitPoints;
   }
   
   public void setHitPoints(int HitPoints){
      if(HitPoints <= 0){
      this.hitPoints = 0;
      }else{
      this.hitPoints = HitPoints;
      }
   }
   
   public String getName(){
    return name;
   }
}
