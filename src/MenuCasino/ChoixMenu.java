/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuCasino;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author clement
 */
public class ChoixMenu {
    
    
    public  static boolean quitter = false;
    public static boolean fired = false;
    public  int jeux;
    
    
    public ChoixMenu(){
       
        this.Start();
    }
    
    public void Start() {
        
        String choix;

        Scanner sc = new Scanner(System.in);

        while (quitter == false) {

            System.out.println("A quoi voulez vous jouer ? BlackJack (1) MachineASous (2) Roulette (3) Bar (4) ");
          
                try {
                     jeux = sc.nextInt();
             } catch (InputMismatchException e) {
                 System.out.println("Veuillez rentrer 1, 2, 3 ou 4");
              
             }
                sc.nextLine();
            switch (jeux) {
                case 1:
                    Blackjack.Blackjack bj = new Blackjack.Blackjack();
                    bj.Jouer();

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
            }

            if (fired == false) {
                System.out.println("Voulez vous quitter le casino (Y) or (N) ?");
                choix = sc.next();
                if (choix.equals("N")) {
                    quitter = false;
                } else {
                    quitter = true;
                }

            }
        }

    }
}