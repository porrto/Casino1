/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.Random;
import static projet.Roulette.nombre;

/**
 *
 * @author isen
 */
public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        System.out.println("Vous disposez de 20 euros");
        Roulette rou = new Roulette();
        
             Random rand = new Random();
             nombre= rand.nextInt(37);
        
        rou.getSreenRoulette();
       
    
        
        
    }
 

       
}
