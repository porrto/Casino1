/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roulette;


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
       PorteMonnaie.argent=argent;   // On met l'argent dans le porte monnaie de  la roulette
       rou.initRoulette();                         // On démarre le jeux
       
       MenuCasino.Menu.argent=PorteMonnaie.argent;          // Lorsque qu'on arrête la roulette, l'argent est récupéré
       
           }
}
