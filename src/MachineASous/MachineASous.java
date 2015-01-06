/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MachineASous;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author isen
 */
public class MachineASous {

    /**
     * @param args the command line arguments
     */
    public static void Jouer(double argent) {
        // TODO code application logic here
        
       
        
        
        System.out.println("Bienvenue à la machine à sous");
          System.out.println("");
          
        
       
          
              if (argent == 0) {
                 System.out.println("Vous n'avez plus d'argent!");
                 
              }
          
          
          System.out.println("");
          System.out.println("Il vous reste $" + argent + '.');
       
           jouerMachineASous(argent) ;
   MenuCasino.Menu.argent=argent;           
    }
    
           static void question(double argent){
           
               
               if (argent == 0) {
                 System.out.println("Vous n'avez plus d'argent!");
                 System.out.println("Vous quittez la table avec " + argent +"$") ;
              }
               
               else {
          System.out.println("Continuer (C) ou Arrêter (A) ?");
               char choix ='?';
              // User's response, 'C' or 'A'.
               do { 
                   try { choix = (char) System.in.read(); }
                   catch (IOException e){
                    System.out.println("Error reading from user");
                    } 
               if (choix != 'C' && choix != 'A'){
                   System.out.println("Veuillez entrer C ou A") ; }
               } 
               while (choix != 'C' && choix != 'A');
    
               /* If the user Hits, the user gets a card.  If the user Stands,
                  the loop ends (and it's the dealer's turn to draw cards).
               */
    
               if ( choix == 'C' ) {
                       // Loop ends; user is done taking cards.
                   jouerMachineASous(argent);
               }
               else {
                   
                   System.out.println("Vous quittez la table avec " + argent +"$") ;
               }
               }
       }
           
           
           
         static double jouerMachineASous(double argent) {
             
             Tableau tirage ;
             tirage = new Tableau() ;
             int[][] montableau ;
             
             montableau = tirage.creerTableau() ;
             
             int mise=2000000; 
             
              System.out.println("Vous avez " + argent + " dollars.");
            
                System.out.println("Combien voulez vous miser ?");
                
                 Scanner sc = new Scanner(System.in);

                 while (mise > argent || mise <= 0) {
                     mise=2000000;
                    try {
                     mise= (int) sc.nextInt() ;
                 
                }
                
                
                catch (InputMismatchException e){
               
                     System.out.println("Vous ne pouvez pas miser cette somme");
                     System.out.println("Combien voulez vous miser ?");
                     sc.next();
                 
                }
                    if (mise <=0){
                        System.out.println("Vous ne pouvez pas miser cette somme");
                     System.out.println("Combien voulez vous miser ?");
                                     }
                 }
                 
                 // On affiche le tirage
                 
                 System.out.println(tirage.cases[0][0] + " " + tirage.cases[0][1] + " " + tirage.cases[0][2]);
                 System.out.println(tirage.cases[1][0] + " " + tirage.cases[1][1] + " " + tirage.cases[1][2]);
                 System.out.println(tirage.cases[2][0] + " " + tirage.cases[2][1] + " " + tirage.cases[2][2]);
                 
                 // Calcul des gains
                 
                 if (tirage.cases[0][0]==tirage.cases[1][1] && tirage.cases[0][0]==tirage.cases[2][2]){
                     //diagonale 1
                     
                     argent = calculGains(argent, mise, tirage,0,0) ;
                     
                 }
                 
                 if (tirage.cases[0][2]==tirage.cases[1][1] && tirage.cases[0][2]==tirage.cases[2][0]){
                     //diagonale 2
                     
                     argent = calculGains(argent, mise, tirage,0,2) ;
                     
                 }
                 
                 if (tirage.cases[0][0]==tirage.cases[0][1] && tirage.cases[0][0]==tirage.cases[0][2]){
                     //ligne 1
                     
                     argent = calculGains(argent, mise, tirage,0,0) ;
                     
                 }
                      
                 if (tirage.cases[1][0]==tirage.cases[1][1] && tirage.cases[1][0]==tirage.cases[1][2]){
                     //ligne 2
                     
                     argent = calculGains(argent, mise, tirage,1,0) ;
                     
                 }
                 
                 if (tirage.cases[2][0]==tirage.cases[2][1] && tirage.cases[2][0]==tirage.cases[2][2]){
                     //ligne 3
                     
                     argent = calculGains(argent, mise, tirage,2,0) ;
                     
                 }
                 
                 if (tirage.cases[0][0]==tirage.cases[1][0] && tirage.cases[0][0]==tirage.cases[2][0]){
                     //colonne 1
                     
                     argent = calculGains(argent, mise, tirage,0,0) ;
                     
                 }
                 
                 if (tirage.cases[0][1]==tirage.cases[1][1] && tirage.cases[0][1]==tirage.cases[2][1]){
                     //colonne 1
                     
                     argent = calculGains(argent, mise, tirage,0,1) ;
                     
                 }
                 
                 if (tirage.cases[0][2]==tirage.cases[1][2] && tirage.cases[0][2]==tirage.cases[2][2]){
                     //colonne 1
                     
                     argent = calculGains(argent, mise, tirage,0,2) ;
                     
                 }
                 
                 else argent = argent - mise ;
                 
                 System.out.println("Vous avez " + argent + " dollars.");
                 question(argent);
                 return argent ;
                 
    
    
         }

         
         public static double calculGains(double argent, int mise, Tableau tirage,int i ,int j) {
             
             if (tirage.cases[i][j]==1){
                      
                 argent = argent + mise ;
                 return argent ;    
                      
                      }
                      
                        if (tirage.cases[i][j]==2){
                           
                         argent = argent + (mise*2) ;
                         return argent ;   
                      
                      }
                        
                        if (tirage.cases[i][j]==3){
                     
                            argent = argent + (mise*3) ;   
                            return argent ;    
                      
                      }
                        
                        if (tirage.cases[i][j]==4){
                         
                            argent = argent + (mise*4) ;
                            return argent ;    
                      
                      }
                        else return 0 ;
         }
         
}