package passosghw2;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author andrehirai
 */
public class HeroesVersusMonsters {

    public static void main(String[] args) {
        int opt=4, action=0;
        System.out.println("Welcome to the Heroes versus Monsters!");

        do {
        	Hero hero = null;
    		Monster monster=null;
        	if (action == 2){
            	opt =4;
            }
        	else {
        		if (action == 3){
        			action = QuitGame("DO YOU WANT TO QUIT THE GAME?","");
        			if (action == 1){
        				opt =4;
        			}
        		}
        		else {
        			opt = menu();
        		}
        		
        	}
            switch (opt) {
            	case 1:
                    action = Match(hero,monster,0);
                    break;

                case 2:
                	action = Match(hero,monster,1);
                    break;

                case 3:
                	action = Match(hero,monster,2);
                    break;
                case 4:
                    break;

            }
        } while (true);

    }

    private static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1. Warrior");
        System.out.println("2. Sorceress");
        System.out.println("3. Thief");
        System.out.print("Choose your hero: ");

        while (!sc.hasNextInt()) {
            ErrorMsg();
            System.out.print("Choose your hero: ");
            sc.next();
        }
        int opt = sc.nextInt();
        while (!checkChoice(opt, 1, 3)) {
            ErrorMsg();
            System.out.print("Choose your hero: ");
            opt = sc.nextInt();
        }

        return opt;

    }

    private static int Match (Hero hero, Monster monster, int Num_Hero){
    	Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a name for your hero: ");
        String name = sc.nextLine();
        Random rd = new Random();
        int Num_Monster = rd.nextInt(3);
    	
        if (Num_Hero==0){
    		hero = new Warrior(name);
    	}
    	
    	if (Num_Hero==1){
    		hero = new Sorceress(name);
    	}
    	if (Num_Hero==2){
    		hero = new Thief(name);
    	}
    	
		if (Num_Monster==0){
			monster = new Ogre();
		}
		if (Num_Monster==1){
			monster = new Gremlin();
		}
		if (Num_Monster==2){
			monster = new Skeleton();
		}
		return battle(hero, monster, Num_Hero,Num_Monster);
    }
    
    private static int battle(Hero hero, Monster monster, int Num_Hero, int Num_Monster){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("   ------------------");
        System.out.println("   " + hero.getName() + " battles " + monster.getName());
        //ENQUANTO OS DOIS ESTIVEREM VIVOS
        int opt = 3, opt2 = 0;
        
        while (true) {
        	int result = battle_HeroTurn (hero, monster, Num_Hero);
        	if (result==1){
        		System.out.println("   " + monster.getName() + " has been killed. :)");
        		System.out.println("   " + hero.getName() + " WON THIS BATTLE. CONGRATULATIONS. YOU DID A GREAT JOB. |0| :)");
        		opt = QuitGame("DO YOU WANT TO QUIT THE GAME?","   ");
        		break;
        	}
        	result = battle_MosnterTurn (hero, monster, Num_Monster);
        	if (result==2){
        		System.out.println("   " + hero.getName() + " has been killed. :)");
        		System.out.println("   " + monster.getName() + " won this battle. Try to beat it again. :(");
        		opt = QuitGame("DO YOU WANT TO QUIT THE GAME?","   ");
        		break;
        	}
        	
        	opt2 = QuitGame ("Do you want to keep playing this battle?","   ");
        	if (opt2 == 2){
        		if (hero.getHitPoints()> monster.getHitPoints()){
        			System.out.println("   " + hero.getName() + " WON THIS BATTLE.");
        		}
        		else if(hero.getHitPoints()<monster.getHitPoints()) {
        			System.out.println("   " + monster.getName() + " won this battle.");
        		}
        		else if (hero.getHitPoints() ==  monster.getHitPoints()){
        			System.out.println("   The battle did not have winner");
        		}
        		break;
        	}
        		
        }
        return opt;
   }   
   private static int battle_HeroTurn (Hero hero, Monster monster, int Num_Hero) {
	   		Scanner sc = new Scanner(System.in);
            //NUMEROS DE ROUNDS DE ATAQUE DO HEROI  
            for (int count = hero.getAtSpeed(); count > 0; count--) {
            	System.out.println("   ------------------");
            	if (count==1){
            		System.out.println("   You have " + count + " chance to attack the " + monster.getName());
            	} else{ 
            		System.out.println("   You have " + count + " chances to attack the " + monster.getName());}            	
                if (Num_Hero ==0){
                	System.out.println("   1. Attack Opponent by using a regular attack");
                    System.out.println("   2. Attack Opponent by using the CrushingBlow Special Attack");
                    System.out.print("   Choose an option: ");
                }
                if (Num_Hero ==1){
                	System.out.println("   1. Attack Opponent by using a regular attack");
                    System.out.println("   2. Increase hit points by using your Special Heal Skill");
                    System.out.print("   Choose an option: ");
                }
                if (Num_Hero == 2){
                	System.out.println("   1. Attack Opponent by using a regular attack");
                    System.out.println("   2. Attack Opponent by using the Special Suprise Attack");
                    System.out.print("   Choose an option: ");
                }
            	

                //VERIFICANDO A ESCOLHA DO USUARIO
                while (!sc.hasNextInt()) {
                    ErrorMsg();
                    System.out.print("   Choose an option: ");
                    sc.next();
                }
                int opt = sc.nextInt();
                while (!checkChoice(opt, 1, 2)) {
                    ErrorMsg();
                    System.out.print("   Choose an option: ");
                    opt = sc.nextInt();
                }

                //ATAQUE
                  
                //EM CASO DE ATAQUE NORMAL
                
                if (opt == 1) {
                	
                	if (Num_Hero ==0){
                		System.out.println("   " + hero.getName() + " swings a mighty sword at " + monster.getName());
                	}
                	if (Num_Hero==1){
                		System.out.println("   " + hero.getName() + " throws a spell of fireball at " + monster.getName());
                	}
                	if (Num_Hero==2){
                		System.out.println("   " + hero.getName() + " shoots towards " + monster.getName());
                	}
                	int at = hero.Attack(hero.getName(), monster.getName());
                	
                		//E SE O ATAQUE FOR BEM SUCEDIDO
                		if (at != 0) {
                        
	                    	monster.setHitPoints(monster.getHitPoints() - at);
	                        System.out.println("   " + monster.getName() + " now has " + monster.getHitPoints() + " hit points remaining.");
                        if(monster.getHitPoints() == 0){
                        	return 1;
                        }
                        int heal = monster.Heal(monster.getName());
                        if(heal!=0){
                        	monster.setHitPoints( monster.getHitPoints() + heal);
                        	System.out.println("   " + monster.getName() + " now has " + monster.getHitPoints() + " hit points remaining.");
                        }
                    }
                    //EM CASO DE ATAQUE ESPECIAL
                } 
                else if (opt == 2) {
                    
                		if (Num_Hero ==0){
	                		int dam = hero.specialattack();
	                        if(dam > 0){
	                         
	                        	System.out.println("   " + hero.getName() + " lands a CRUSHING BLOW for " + dam + " damage!");
	                        	monster.setHitPoints( monster.getHitPoints() - dam);
	                        	System.out.println("   " + monster.getName() + " now has " + monster.getHitPoints() + " hit points remaining.");
	                        	if(monster.getHitPoints() == 0){
	                            	return 1;
	                            }
	                        	int heal = monster.Heal(monster.getName());
	                        	if(heal!=0){
	                        		monster.setHitPoints( + monster.getHitPoints() + heal);
	                            	System.out.println("   " + monster.getName() + " now has " + monster.getHitPoints() + " hit points remaining.");
	                            }
	                        
	                        }
	                        else{
	                        	System.out.println("   "+ hero.getName()+ "'s special attack has failed!");
	                        }
                		}
                		if (Num_Hero==1){
                			int healHero = hero.specialattack();
                			if(healHero!=0){
	                    		hero.setHitPoints(hero.getHitPoints() + healHero);
	                        	System.out.println("   " + hero.getName() + " now has " + hero.getHitPoints() + " hit points remaining.");
	                    	}	
                		}
                        
                		if (Num_Hero==2){
                			int thiefAction = hero.specialattack();
                			if (thiefAction==1){
                				System.out.println("   Special suprise attack was successfully used...." + hero.getName() + " has gotten one more turn to attack "+ monster.getName()+ ".");
                				count = count +1;
                				
                			}
                			if (thiefAction==2){
                				System.out.println("   " + hero.getName() + " shoots towards " + monster.getName());
                				int at = hero.Attack(hero.getName(), monster.getName());
                        		//E SE O ATAQUE FOR BEM SUCEDIDO
                        		if (at != 0) {
        	                    	monster.setHitPoints(monster.getHitPoints() - at);
        	                        System.out.println("   " + monster.getName() + " now has " + monster.getHitPoints() + " hit points remaining.");
        	                        if(monster.getHitPoints() == 0){
        	                        	return 1;
        	                        	
        	                        }
        	                        int heal = monster.Heal(monster.getName());
        	                        if(heal!=0){
        	                        	monster.setHitPoints( monster.getHitPoints() + heal);
        	                        	System.out.println("   " + monster.getName() + " now has " + monster.getHitPoints() + " hit points remaining.");
        	                        }
                        		}
                			}
                			if (thiefAction==0){
                				System.out.println("   " + hero.getName() + " could not has used its special suprise attack.");
                			}
                			
                    	}			
                }
         }
         return 0;
   }
   
   public static int battle_MosnterTurn (Hero hero, Monster monster, int Num_Monster){
	   	Scanner sc = new Scanner(System.in);
        //AGORA â€¦ A VEZ DO MONSTRO ATACAR
        System.out.println("   ------------------");
        System.out.println("   That is " + monster.getName() + "'s turn:");
        int k = 0;
        for (int count2 = monster.getAtSpeed(); count2 > 0; count2--) {
            k++;
        	if (Num_Monster==0) {
        		System.out.println("   "+k + ". ATTACK: " + monster.getName() + " slowly swings a club towards at " + hero.getName());
        	}
        	if (Num_Monster ==1) {
        		System.out.println("   "+k + ". ATTACK: " + monster.getName() + " slices his rusty blade at " + hero.getName());
        	}
        	if (Num_Monster==2){
        		System.out.println("   "+k + ". ATTACK: " + monster.getName() + " jabs his kris at " + hero.getName());
        	}
        	if(hero.ChanceBlock()){
        		int at = monster.Attack(monster.getName(), hero.getName());
        		if (at!=0){
        			hero.setHitPoints(hero.getHitPoints() - at);
        			if(hero.getHitPoints() == 0){
            			System.out.println("   " + hero.getName() + " now has " + hero.getHitPoints() + " hit points remaining.");
            			return 2;
            		}  
        		}
        	}
        	else {
        		System.out.println("   "+ hero.getName() + " BLOCKED " + monster.getName() + "'s attack");
        	}
        	
        }
        System.out.println("   " + hero.getName() + " now has " + hero.getHitPoints() + " hit points remaining.");
        return 0;
   }
   
   public static int QuitGame (String question, String space) {
	   		Scanner sc = new Scanner(System.in);
            //PERGUNTANDO O USUÁRIO SE ELE QUER CONTINUAR JOGANDO
            System.out.println(space + ">>>>>>>>>>>>>>");
            System.out.println(space + question);
            System.out.println(space + "1. Yes");
            System.out.println(space + "2. No");
            System.out.print(space + "Choose an option: ");
            
          //VERIFICANDO A ESCOLHA DO USUARIO
            while (!sc.hasNextInt()) {
                ErrorMsg();
                System.out.print(space + "Choose an option: ");
                sc.next();
            }
            int opt = sc.nextInt();
            while (!checkChoice(opt, 1, 2)) {
                ErrorMsg();
                System.out.print(space + "Choose an option: ");
                opt = sc.nextInt();
            }
            
            return opt;
    	
    }
    
    public static boolean checkChoice(int opt, int first, int last) {
        //stating variables
        boolean check = true;
         //checking

        if ((opt >= first) && (opt <= last)) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public static void ErrorMsg() {

        System.out.println("INVALID CHOICE");
    }
    

   
}
