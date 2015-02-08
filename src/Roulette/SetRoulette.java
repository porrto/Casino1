/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roulette;

import java.util.Random;

/**
 *
 * @author isen
 */
public class SetRoulette {

    public static int nombre;
    public static String color;
    public static String parité;

    public SetRoulette() {
        Random rand = new Random();
        nombre = rand.nextInt(37);
        
           
        if (nombre == 32 || nombre == 19 || nombre == 21 || nombre == 25 || nombre == 34 || nombre == 27 || nombre == 36 || nombre == 30 || nombre == 23 || nombre == 5
                || nombre == 16 || nombre == 1 || nombre == 14 || nombre == 9 || nombre == 18 || nombre == 7 || nombre == 12 || nombre == 3) {
            color = "rouge";
        } else {
        
                color = "noir";
            
        }
        
           if (nombre % 2 == 0) {
            parité = "pair";
        } else {
            parité = "impair";
        }
    }

    /*public Tirage SetUpRoulette() {

        Tirage tirage = new Tirage(nombre, getCouleur(nombre), getParité(nombre));
        
     

        return tirage;

    }

    public String getCouleur(int nombre) {
       

     
    }

    public String getParité(int nombre) {
        ;

     

        return parité;
    }
*/
}
