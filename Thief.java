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
public class Thief extends Hero {

    public Thief(String name) {
        super(name, 110, 2, 0.5, 40, 90, 0.7);
    }

    
    
    public int specialattack() {

        Random rdm = new Random();

        if (rdm.nextDouble() <= 0.4) {
            return 1;
        }
        else if (rdm.nextDouble() <= 0.6666667){
        	return 2;
        }
        
        return 0;

    }

}
