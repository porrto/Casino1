/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MachineASous;

import Interface.Exit;
import MenuCasino.Player;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author isen
 */
public class MachineASous implements Exit {

    /**
     * @param argent
     */
    public  void Jouer() {
        // TODO code application logic here

        System.out.println("Bienvenue à la machine à sous");
        System.out.println("");

        if (Player.argent == 0) {
            System.out.println("Vous n'avez plus d'argent!");

        }

        System.out.println("");
        System.out.println("Il vous reste $" + Player.argent + '.');

        jouerMachineASous();

    }

    public void question() {

        if (Player.argent == 0) {
            System.out.println("Vous n'avez plus d'argent!");
            System.out.println("Vous quittez la table avec " + Player.argent + "$");
        } else {
            System.out.println("Continuer (C) ou Arrêter (A) ?");
            char choix = '?';
            // User's response, 'C' or 'A'.
            do {
                try {
                    choix = (char) System.in.read();
                } catch (IOException e) {
                    System.out.println("Error reading from user");
                }
                if (choix != 'C' && choix != 'A') {
                    System.out.println("Veuillez entrer C ou A");
                }
            } while (choix != 'C' && choix != 'A');

            /* If the user Hits, the user gets a card.  If the user Stands,
             the loop ends (and it's the dealer's turn to draw cards).
             */
            if (choix == 'C') {
                // Loop ends; user is done taking cards.
                this.jouerMachineASous();
            } else {

              this.Quitter();
            }
        }
    }

    public void jouerMachineASous() {

        Tableau tirage;
        tirage = new Tableau();
        int[][] montableau;

        montableau = tirage.creerTableau();

        int mise = 2000000;

        System.out.println("Vous avez " + Player.argent + " dollars.");

        System.out.println("Combien voulez vous miser ?");

        Scanner sc = new Scanner(System.in);

        while (mise > Player.argent || mise <= 0) {
            mise = 2000000;
            try {
                mise = (int) sc.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("Vous ne pouvez pas miser cette somme");
                System.out.println("Combien voulez vous miser ?");
                sc.next();

            }
            if (mise <= 0) {
                System.out.println("Vous ne pouvez pas miser cette somme");
                System.out.println("Combien voulez vous miser ?");
            }
        }

        // On affiche le tirage
        System.out.println(tirage.cases[0][0] + " " + tirage.cases[0][1] + " " + tirage.cases[0][2]);
        System.out.println(tirage.cases[1][0] + " " + tirage.cases[1][1] + " " + tirage.cases[1][2]);
        System.out.println(tirage.cases[2][0] + " " + tirage.cases[2][1] + " " + tirage.cases[2][2]);

        // Calcul des gains
        if (tirage.cases[0][0] == tirage.cases[1][1] && tirage.cases[0][0] == tirage.cases[2][2]) {
            //diagonale 1

            Player.argent = calculGains(Player.argent, mise, tirage, 0, 0);

        }

        if (tirage.cases[0][2] == tirage.cases[1][1] && tirage.cases[0][2] == tirage.cases[2][0]) {
            //diagonale 2

            Player.argent = calculGains(Player.argent, mise, tirage, 0, 2);

        }

        if (tirage.cases[0][0] == tirage.cases[0][1] && tirage.cases[0][0] == tirage.cases[0][2]) {
            //ligne 1

            Player.argent = calculGains(Player.argent, mise, tirage, 0, 0);

        }

        if (tirage.cases[1][0] == tirage.cases[1][1] && tirage.cases[1][0] == tirage.cases[1][2]) {
            //ligne 2

            Player.argent = calculGains(Player.argent, mise, tirage, 1, 0);

        }

        if (tirage.cases[2][0] == tirage.cases[2][1] && tirage.cases[2][0] == tirage.cases[2][2]) {
            //ligne 3

            Player.argent = calculGains(Player.argent, mise, tirage, 2, 0);

        }

        if (tirage.cases[0][0] == tirage.cases[1][0] && tirage.cases[0][0] == tirage.cases[2][0]) {
            //colonne 1

            Player.argent = calculGains(Player.argent, mise, tirage, 0, 0);

        }

        if (tirage.cases[0][1] == tirage.cases[1][1] && tirage.cases[0][1] == tirage.cases[2][1]) {
            //colonne 1

            Player.argent = calculGains(Player.argent, mise, tirage, 0, 1);

        }

        if (tirage.cases[0][2] == tirage.cases[1][2] && tirage.cases[0][2] == tirage.cases[2][2]) {
            //colonne 1

            Player.argent = calculGains(Player.argent, mise, tirage, 0, 2);

        } else {
            Player.argent = Player.argent - mise;
        }

        System.out.println("Vous avez " + Player.argent + " dollars.");
        
        question();
        

    }

    public static double calculGains(double argent, int mise, Tableau tirage, int i, int j) {

        if (tirage.cases[i][j] == 1) {

            argent = argent + mise;
            return argent;

        }

        if (tirage.cases[i][j] == 2) {

            argent = argent + (mise * 2);
            return argent;

        }

        if (tirage.cases[i][j] == 3) {

            argent = argent + (mise * 3);
            return argent;

        }

        if (tirage.cases[i][j] == 4) {

            argent = argent + (mise * 4);
            return argent;

        } else {
            return 0;
        }
    }
    
    @Override
    public  void Quitter() {
          System.out.println("Vous quittez la table avec " + Player.argent + "$");
                //MenuCasino.ChoixMenu.argent = argent;
    }

}
