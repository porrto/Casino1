/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuCasino;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Menu des différents jeux du casino
 * @author clement
 */
public final class ChoixMenu {
    
    /**
     * Indique si le joueur a choisis de quitter
     */
    public  static boolean quitter = false;
    /**
     * Indique si le joueur doit être viré (lorsqu'il a trop bu)
     */
    public static boolean fired = false;
    /**
     * Choix de jeux du joueur
     */
    public  int decision;
    
    /**
     * Constructeur permettant de lancer le menu
     */
    public ChoixMenu(){
       
        this.Start();
    }
    
    /**
     * Proposition des jeux et du bar
     */
    public void Start() {
        
        String choix;

        Scanner sc = new Scanner(System.in);

        while (quitter == false) {

           ChoixJeu();
           
            switch (decision) {
                case 1:
                    Blackjack.Blackjack bj = new Blackjack.Blackjack();
                    bj.AccueilBlackJack();

                    break;

                case 2:
                    MachineASous.MachineASous machine = new MachineASous.MachineASous();
                    machine.Jouer();

                    break;

                case 3:
                  Roulette.Roulette roulette = new Roulette.Roulette();
                  roulette.initRoulette();

                    break;

                case 4:
                    Bar.Bar bar = new Bar.Bar();
                   bar.initBar();

                    break;
                
                case 5:
                    quitter = true;

                    break;
            }

       /*/     if (fired == false) {
                System.out.println("Voulez vous quitter le casino (Y) or (N) ?");
                choix = sc.next();
                if (choix.equals("N")) {
                    quitter = false;
                } else {
                    quitter = true;
                }

            } /*/
        }

    }
    
    /**
     * On véirifie que le choix du joueur existe dans la liste proposée 
     */
    public void ChoixJeu() {
        
          Scanner sc = new Scanner(System.in);
        System.out.println("Que voulez vous faire ? BlackJack (1)  MachineASous (2) Roulette (3) Bar (4) Sortir du casino (5) ");
          
                try {
                     decision = sc.nextInt();
             } catch (InputMismatchException e) {
                 System.out.println("Veuillez rentrer 1, 2, 3, 4 ou 5 ");
                 ChoixJeu();
             }
                if(decision!=1 && decision!= 2 && decision!= 3 && decision!= 4 && decision!=5){
                    System.out.println("Veuillez rentrer 1, 2, 3, 4 ou 5 ");
                    ChoixJeu();
                }
                  sc.nextLine();
    }
}