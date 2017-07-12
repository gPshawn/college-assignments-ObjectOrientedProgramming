package passosghw2;

import java.util.Random;

/**
 *
 * @author Guilherme Passos
 */
public class Sorceress extends Hero{
	private double cHeal;
    private int MHeal;
    private int mHeal;
    public Sorceress(String name){
     super(name,150,1,0.7,25,60,0.5);
     this.cHeal = 0.9;
     this.mHeal = 40;
     this.MHeal = 90;
    }
       
    
    // incompleto
    
    public int specialattack(){
         
	     Random rdm = new Random();
	   	 Random rdm2 = new Random();
	   	 
	   	 if(rdm.nextDouble() <= cHeal){
	   		 int NewLife = rdm2.nextInt((MHeal - mHeal) + 1) + mHeal;
	   		 System.out.println("   Special skill was successfully used...." + super.getName() + " has increased its his points by " + NewLife );
	   		 return NewLife;
	   	 }
	   	System.out.println("   " + super.getName() + " could not has used its special skill.");
	   	return 0;
     
     }
    
}

