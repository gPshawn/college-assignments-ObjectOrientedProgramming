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
public class Warrior extends Hero {
    public Warrior(String name){
     super(name,100,2,0.8,35,60,0.45);
     

     
    
    }
    
      
    public void basicAttack(String monster){
     System.out.println();
    
    }
    
    public int specialattack(){
        
        Random rdm = new Random();
        
        if(rdm.nextDouble() <= 0.4){
        int randomNum = rdm.nextInt((100) + 1) + 75;
        return randomNum;
                }
        return 0;
    
    }
    
     
}
