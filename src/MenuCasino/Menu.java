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
    
  public static double argent =40;
  public static  boolean quitter=false;
  public static boolean fired=false;
     public static void main(String[] args) {
            
                 String choix;
         
         Scanner sc = new Scanner(System.in);
         
          while(quitter==false) {
      System.out.println("A quoi voulez vous jouer ? BlackJack (1) MachineASous (2) Roulette (3) Bar (4) ");
          int jeux  =sc.nextInt();
       

     
       
       switch(jeux) {
           case 1:
        Blackjack.Blackjack.Jouer(argent);
             
               break;
               
           case 2:
               MachineASous.MachineASous.Jouer(argent);
              
               break;
               
           case 3:
               Roulette.Projet.Jouer(argent);
           
               break;
               
           case 4:
               projetbar.ProjetBar.Jouer(argent);
            
               break;
              
    }
       
        if(fired==false ) {
         System.out.println("Voulez vous quitter le casino (Y) or (N) ?");
               choix=sc.next();
               if(choix.equals("N")) {
                   quitter=false;
               }
               else {
                   quitter=true;
               }
            
           }
          }
    
         System.out.println("Vous partez avec " + argent);
    
    
     }
}
