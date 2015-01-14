/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuCasino;

import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author isen
 */
public class Menu {

    public static double argent = 40;
    public static boolean quitter = false;
    public static boolean fired = false;
    public static int jeux;

    public static void main(String[] args) {

        String choix;

        Scanner sc = new Scanner(System.in);

        while (quitter == false) {

            System.out.println("A quoi voulez vous jouer ? BlackJack (1) MachineASous (2) Roulette (3) Bar (4) ");
            while (jeux != 1 && jeux != 2 && jeux != 3 && jeux != 4) {
                try {
                    jeux = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez rentrer 1, 2, 3 ou 4");
                    sc.nextLine();
                }
            }
            switch (jeux) {
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

        System.out.println("Vous partez avec " + argent);

    }
}
