package MachineASous;

import Interface.Exit;
import Interface.Mise;
import MenuCasino.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Jeu Machine à sous
 *
 * @author enzo
 */
public class MachineASous implements Exit, Mise {

    /**
     * La mise du joueur
     */
    public double mise;

    /**
     * Introduit le jeu
     */
    public void Jouer() {

        System.out.println("Bienvenue à la machine à sous");
        System.out.println("");

        if (Player.argent == 0) {
            System.out.println("Vous n'avez plus d'argent!");

        }

        System.out.println("");
        System.out.println("Il vous reste $" + Player.argent + '.');

        jouerMachineASous();

    }

    /**
     * Demande au joueur s'il veut quitter le jeu ou rejouer une partie
     */
    public void Rejouer() {

        String choix = "??";
        Scanner sc = new Scanner(System.in);
        if (Player.argent != 0) {
            System.out.println("Voulez vous rejouer ? (O) or (N) ");
            String choixnouvellepartie = sc.next();

            if (choixnouvellepartie.equals("O")) {

                this.jouerMachineASous();
            } else {
                if (choixnouvellepartie.equals("N")) {
                    this.Quitter();
                } else {
                    System.out.println("Veuillez entrer O ou N ");
                    this.Rejouer();
                }
            }

        } else {
            System.out.println("Vous n'avez plus d'argent!");

            this.Quitter();
        }
    }

    /**
     * Lance la machine à sous, gère les gains
     */
    public void jouerMachineASous() {

        Tableau tirage = new Tableau();

        tirage.creerTableau();

        System.out.println("Vous avez " + Player.argent + " dollars.");

        VerifMise();

        // On affiche le tirage
        System.out.println("");
        System.out.println(tirage.cases[0][0] + " " + tirage.cases[0][1] + " " + tirage.cases[0][2]);
        sleep1000();
        System.out.println(tirage.cases[1][0] + " " + tirage.cases[1][1] + " " + tirage.cases[1][2]);
        sleep1000();
        System.out.println(tirage.cases[2][0] + " " + tirage.cases[2][1] + " " + tirage.cases[2][2]);
        System.out.println("");

        // Calcul des gains
        if (tirage.cases[0][0] == tirage.cases[1][1] && tirage.cases[0][0] == tirage.cases[2][2]) {
            //diagonale 1

            Player.argent = calculGains(Player.argent, mise, tirage, 0, 0);
            System.out.println("Vous avez une diagonale de " + tirage.cases[0][0]);
        }

        if (tirage.cases[0][2] == tirage.cases[1][1] && tirage.cases[0][2] == tirage.cases[2][0]) {
            //diagonale 2

            Player.argent = calculGains(Player.argent, mise, tirage, 0, 2);
            System.out.println("Vous avez une diagonale de " + tirage.cases[0][2]);
        }

        if (tirage.cases[0][0] == tirage.cases[0][1] && tirage.cases[0][0] == tirage.cases[0][2]) {
            //ligne 1

            Player.argent = calculGains(Player.argent, mise, tirage, 0, 0);
            System.out.println("Vous avez une ligne de " + tirage.cases[0][0]);
        }

        if (tirage.cases[1][0] == tirage.cases[1][1] && tirage.cases[1][0] == tirage.cases[1][2]) {
            //ligne 2

            Player.argent = calculGains(Player.argent, mise, tirage, 1, 0);
            System.out.println("Vous avez une ligne de " + tirage.cases[1][0]);

        }

        if (tirage.cases[2][0] == tirage.cases[2][1] && tirage.cases[2][0] == tirage.cases[2][2]) {
            //ligne 3

            Player.argent = calculGains(Player.argent, mise, tirage, 2, 0);
            System.out.println("Vous avez une ligne de " + tirage.cases[2][0]);

        }

        if (tirage.cases[0][0] == tirage.cases[1][0] && tirage.cases[0][0] == tirage.cases[2][0]) {
            //colonne 1

            Player.argent = calculGains(Player.argent, mise, tirage, 0, 0);
            System.out.println("Vous avez une colonne de " + tirage.cases[0][0]);

        }

        if (tirage.cases[0][1] == tirage.cases[1][1] && tirage.cases[0][1] == tirage.cases[2][1]) {
            //colonne 2

            Player.argent = calculGains(Player.argent, mise, tirage, 0, 1);
            System.out.println("Vous avez une colonne de " + tirage.cases[0][1]);

        }

        if (tirage.cases[0][2] == tirage.cases[1][2] && tirage.cases[0][2] == tirage.cases[2][2]) {
            //colonne 3

            Player.argent = calculGains(Player.argent, mise, tirage, 0, 2);
            System.out.println("Vous avez une colonne de " + tirage.cases[0][2]);

        } else {
            Player.argent = Player.argent - mise;
        }

        System.out.println("Vous avez " + Player.argent + " dollars.");

        Rejouer();

    }

    /**
     * Calcule les gains selon le tirage de la machine à sous
     *
     * @param argent L'argent total du joueur
     * @param mise La mise pour la partie en cours
     * @param tirage Le tirage de la machine à sous (tableau 3x3 d'entiers)
     * @param i Le numéro de ligne d'une case faisant partie d'une ligne
     * gagnante
     * @param j Le numéro de colonne de la même case
     * @return l'argent du joueur après application des gains
     */
    public static double calculGains(double argent, double mise, Tableau tirage, int i, int j) {

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

            argent = argent + (mise * 10);
            return argent;

        } else {
            return 0;
        }
    }

    /**
     * Vérifie que la mise est correcte (positive et inférieure au total
     * disponible par le joueur)
     */
    @Override
    public void VerifMise() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Combien voulez vous miser ? ");

        try {
            mise = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Veuillez rentrer un entier ");
            VerifMise();
        }
        if (mise > Player.argent || mise <= 0) {
            System.out.println("Vous ne pouvez pas miser cette somme ");
            VerifMise();
        }

    }

    /**
     * Timer de 1 seconde
     */
    public void sleep1000() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {

        }
    }

    /**
     * Annonce au joueur qu'il quitte la table
     */
    @Override
    public void Quitter() {
        System.out.println("Vous quittez la table avec " + Player.argent + "$");

    }

}
