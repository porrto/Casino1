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
     * @param args the command line arguments
     */
    public static void Jouer(double argent) {


        System.out.println("Vous disposez de" + argent);
      Roulette rou = new Roulette();
        
             Random rand = new Random();
             nombre= rand.nextInt(37);
        PorteMonnaie.argent=argent;
       rou.getSreenRoulette();
       MenuCasino.Menu.argent=PorteMonnaie.argent;
       
  
           }
 

       
}
