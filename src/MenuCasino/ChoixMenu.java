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
 * @author isen
 */
public class ChoixMenu {
    
    
    public  static boolean quitter = false;
    public static boolean fired = false;
    public  int jeux;
    public static double argent;
    
    public ChoixMenu(double argent){
        this.argent = argent;
        this.Start();
    }
    
    public void Start() {
        
        String choix;

        Scanner sc = new Scanner(System.in);

        while (quitter == false) {

            System.out.println("A quoi voulez vous jouer ? BlackJack (1) MachineASous (2) Roulette (3) Bar (4) ");
           //while (jeux != 1 && jeux != 2 && jeux != 3 && jeux != 4) {
                try {
                     jeux = sc.nextInt();
             } catch (InputMismatchException e) {
                 System.out.println("Veuillez rentrer 1, 2, 3 ou 4");
                 this.Start();
             }
          //}
            switch (jeux) {
                case 1:
                    Blackjack.Blackjack.Jouer(argent);

                    break;

                case 2:
                    MachineASous.MachineASous.Jouer(argent);

                    break;

                case 3:
                  Roulette.Roulette roulette = new Roulette.Roulette();
                  roulette.initRoulette(argent);

                    break;

                case 4:
                    projetbar.Bar bar = new projetbar.Bar();
                   bar.initBar(argent);

                    break;
                    
                default : 
                    System.out.println("Veuillez entrer 1 , 2 , 3 ou 4");
                    sc.nextLine();

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