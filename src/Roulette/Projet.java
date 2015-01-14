/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roulette;

import java.util.Random;
import static Roulette.Roulette.nombre;

/**
 *
 * @author isen
 */
public class Projet {

    /**
     * @param argent
     */
    public static void Jouer(double argent) {

       
     
       System.out.println("Vous disposez de" + argent +"     " );
      Roulette rou = new Roulette();
        
      
        
        PorteMonnaie.argent=argent;
       rou.initRoulette();
       MenuCasino.Menu.argent=PorteMonnaie.argent;
       
  
           }
            
          
        
}
