package MenuCasino;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menu des différents jeux du casino
 *
 * @author clement
 */
public final class ChoixMenu {

    /**
     * Indique si le joueur a choisi de quitter
     */
    public static boolean quitter = false;
    /**
     * Indique si le joueur doit être viré (lorsqu'il a trop bu)
     */
    public static boolean fired = false;
    /**
     * Choix de jeu du joueur
     */
    public int decision;

    /**
     * Constructeur permettant de lancer le menu
     */
    public ChoixMenu() {

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

        }

    }

    /**
     * On vérifie que le choix du joueur existe dans la liste proposée
     */
    public void ChoixJeu() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Que voulez vous faire ? BlackJack (1)  Machine à sous (2) Roulette (3) Bar (4) Sortir du casino (5) ");

        try {
            decision = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Veuillez rentrer 1, 2, 3, 4 ou 5 ");
            ChoixJeu();
        }
        if (decision != 1 && decision != 2 && decision != 3 && decision != 4 && decision != 5) {
            System.out.println("Veuillez rentrer 1, 2, 3, 4 ou 5 ");
            ChoixJeu();
        }

    }
}
