package passosghw2;

import java.util.Random;

/**
 *
 * @author andrehirai
 */
public class Monster extends DungeonCharacter {
      private double cHeal;
      private int mHeal;
      private int MHeal;
      public Monster(String name,int hitPoints, int atSpeed, double chanceH,int mDamageR,int MDamageR,double cHeal,int mHeal,int MHeal) {
        super(name,hitPoints, atSpeed, chanceH,mDamageR,MDamageR);
        this.mHeal = mHeal;
        this.MHeal = MHeal;
        this.cHeal = cHeal;
          
        
    }
      
    public int Heal (String nMonster){
    	 Random rdm = new Random();
    	 Random rdm2 = new Random();
    	 
    	 if(rdm.nextDouble() <= cHeal){
    		 int NewLife = rdm2.nextInt((MHeal - mHeal) + 1) + mHeal;
    		 System.out.println("   >>>>>>");
    		 System.out.println("   HEYY WAIT...." + nMonster + " has been healed by getting " + NewLife + " hit points.");
    		 return NewLife;
    	 }
    	 
    	 return 0;
    	 
    		 
    }
}

    
