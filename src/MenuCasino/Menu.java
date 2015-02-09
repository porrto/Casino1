/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuCasino;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *On va demander au joueur de rentrer une somme d'argent afin de pouvoir commencer les activités du casino
 * @author clement
 */
public class Menu {
    
/**
 * Argent que le joueur dispose dès son entrée dans le casino
 */
public static double argent;

/**
 * Instanciation du joueur et du menu de jeu
 * @param args 
 * 
 */
    public static void main(String[] args) {

        verifInteger();
        
        Player player1 = new Player(argent,0);
        ChoixMenu cm = new ChoixMenu();
        
        System.out.println("Vous partez avec " + Player.argent);

    }
    
    /**
     * Verification de la somme d'argent rentrée par le joueur
     */
     public static void verifInteger() {
        
         
            Scanner sc = new Scanner(System.in);
        System.out.println("Combien d'argent avez vous ?");
        
              try {
                    argent = sc.nextInt();
             } catch (InputMismatchException e) {
                 System.out.println("Veuillez rentrer un entier");
                verifInteger();
             }
              
                  if(argent <= 0) {
                      System.out.println("Vous ne pouvez pas avoir ce solde d'argent");
                      verifInteger();
                  }
              
               sc.nextLine();
               
    }
}
