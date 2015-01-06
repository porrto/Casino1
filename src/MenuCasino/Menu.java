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
    
  public static double argent =20;
     public static void main(String[] args) {
                boolean quitter=false;
                 String choix;
         
         Scanner sc = new Scanner(System.in);
         
           while(quitter==false) {
      System.out.println("A quoi voulez vous jouer ? BlackJack (1) MachineASous (2) Roulette (3)");
       int jeux  =sc.nextInt();
       

     
       
       switch(jeux) {
           case 1:
        Blackjack.Blackjack.Jouer(argent);
               System.out.println("Voulez vous quitter le casino (Y) or (N) ?");
               choix=sc.next();
               if(choix.equals("N")) {
                   quitter=false;
               }
               else {
                   quitter=true;
               }
               break;
               
           case 2:
               MachineASous.MachineASous.Jouer(argent);
               System.out.println("Voulez vous quitter le casino (Y) pr (N) ?");
                 choix=sc.next();
               if(choix.equals("N")) {
                   quitter=false;
               }
               else {
                   quitter=true;
               }
               break;
               
           case 3:
               Roulette.Projet.Jouer(argent);
               System.out.println("Voulez vous quitter le casino (Y) or (N( ?");
                 choix= sc.next();
               if(choix.equals("N")) {
                   quitter=false;
               }
               else {
                   quitter=true;
               }
               break;
              
    }
               System.out.println(argent);
           }
    
         System.out.println("Au revoir");
    
    
     }
}
