package passosghw2;

import java.util.Random;

/**
 *
 * @author Guilherme Passos
 */
abstract class Hero extends DungeonCharacter {
   private double chanceBlock;
   private int numberTurn;
   
    
    
    public Hero(String name,int hitPoints, int atSpeed, double chanceH,int mDamageR,int MDamageR,double chanceBlock) {
        super(name,hitPoints, atSpeed, chanceH,mDamageR,MDamageR);
        this.chanceBlock = chanceBlock;
        
    }
    
    public boolean ChanceBlock(){
        Random rdm = new Random();
        if(rdm.nextDouble() < chanceBlock)
          return false;
        
        return true;
    }
    
    public abstract int specialattack();
    
    
}
