/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuCasino;

import java.util.Scanner;

/**
 *
 * @author isen
 */
public class Menu {
    
     public static void main(String[] args) {
         
         Scanner sc = new Scanner(System.in);
      System.out.println("A quoi voulez vous jouer ? BlackJack (1) MachineASous (2) Roulette (3)");
       int choix  =sc.nextInt();
       
       switch(choix) {
           case 1:
        Blackjack.Blackjack.main(args);
               break;
               
           case 2:
               MachineASous.MachineASous.main(args);
               break;
               
           case 3:
               Roulette.Projet.main(args);
               break;
               
           default: 
               System.out.println("Veuillez entrer 1 2 ou 3");
    }
    
    
    
    
    
     }
}
