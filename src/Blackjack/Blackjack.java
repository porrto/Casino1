package Blackjack;

import Interface.Exit;
import Interface.Mise;
import MenuCasino.Player;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Blackjack implements Exit, Mise {

    public boolean croupiersuperieur21 = false;
    public boolean joueurexit = false;
    public boolean getblackjack = false;
    public double mise;

    public void AccueilBlackJack() {

        System.out.println("");
        System.out.println("Bienvenue à la table de BlackJack");
        System.out.println("");

        // On commence 
        if (Player.argent == 0) {
            System.out.println("Vous n'avez plus d'argent!");

        }

        System.out.println("");
        System.out.println("Il vous reste " + Player.argent + '$');

        jouerBlackjack();

    } // fin main

    public void Rejouer() {

        Scanner sc = new Scanner(System.in);

        if (Player.argent == 0) {
            System.out.println("Vous n'avez plus d'argent!");
            this.Quitter();
            joueurexit = true;
        } else {
            System.out.println("Voulez vous rejouer ? (O) or (N) ");
            String choixnouvellepartie = sc.next();

            if (choixnouvellepartie.equals("O")) {

                croupiersuperieur21 = false;
                joueurexit = false;
                getblackjack = false;
                this.jouerBlackjack();
            } else {
                if (choixnouvellepartie.equals("N")) {
                    this.Quitter();
                } else {
                    System.out.println("Veuillez entrer O ou N ");
                    this.Rejouer();
                }
            }

        }
    }

    public void jouerBlackjack() {

        Paquet paquet;
        MainBlackjack mainCroupier;
        MainBlackjack mainJoueur;

        paquet = new Paquet();
        mainCroupier = new MainBlackjack();
        mainJoueur = new MainBlackjack();

        paquet.melanger();
        mainCroupier.ajouterCarte(paquet.tirerCarte());
        mainCroupier.ajouterCarte(paquet.tirerCarte());
        mainJoueur.ajouterCarte(paquet.tirerCarte());
        mainJoueur.ajouterCarte(paquet.tirerCarte());

        System.out.println("Vous avez " + Player.argent + "$");

        VerifMise();

        if (mainCroupier.valeurBlackJack() == 21) {
            System.out.println("Le croupier a " + mainCroupier.selectionnerCarte(0)
                    + " et " + mainCroupier.selectionnerCarte(1) + ".");
            System.out.println("Le joueur a " + mainJoueur.selectionnerCarte(0)
                    + " et " + mainJoueur.selectionnerCarte(1) + ".");
            System.out.println("");
            System.out.println("Le croupier a un Blackjack. Le croupier gagne.");
            Player.argent = Player.argent - mise;
            getblackjack = true;
            Rejouer();

        }

        if (mainJoueur.valeurBlackJack() == 21) {
            System.out.println("Le croupier a " + mainCroupier.selectionnerCarte(0)
                    + " et " + mainCroupier.selectionnerCarte(1) + ".");
            System.out.println("Le joueur a " + mainJoueur.selectionnerCarte(0)
                    + " et " + mainJoueur.selectionnerCarte(1) + ".");
            System.out.println("");
            System.out.println("Vous avez un Blackjack. Vous gagnez.");
            Player.argent = Player.argent + mise * 1.5;
            getblackjack = true;
            Rejouer();

        }

        while (true && joueurexit == false && getblackjack == false) {

            System.out.println("");
            System.out.println("");
            System.out.println("Vos cartes sont");
            for (int i = 0; i < mainJoueur.nombreDeCartes(); i++) {
                sleep500();
                System.out.println("    " + mainJoueur.selectionnerCarte(i));
            }
            System.out.println("Le total est de " + mainJoueur.valeurBlackJack());
            System.out.println("");
            sleep500();
            System.out.println("Le croupier montre " + mainCroupier.selectionnerCarte(0));
            System.out.println("");
            sleep500();
            System.out.println("Tirer (T) ou Passer (P)? ");
            char action = '?';
            // User's response, 'H' or 'S'.
            do {
                try {
                    action = (char) System.in.read();
                } catch (IOException e) {
                    System.out.println("Error reading from user");
                }
                if (action != 'T' && action != 'P') {
                    System.out.println("Veuillez entrer T ou P");
                }
            } while (action != 'T' && action != 'P');

            if (action == 'P') {

                System.out.println("");
                System.out.println("Le joueur passe");
                System.out.println("Les cartes du croupier sont");
                System.out.println("   " + mainCroupier.selectionnerCarte(0));
                System.out.println("    " + mainCroupier.selectionnerCarte(1));

                break;
            } else {

                Carte nouvelleCarte = paquet.tirerCarte();
                mainJoueur.ajouterCarte(nouvelleCarte);
                System.out.println("");
                System.out.println("Le joueur tire");

                if (mainJoueur.valeurBlackJack() > 21) {
                    System.out.println("");
                    System.out.println("Vous tirez " + nouvelleCarte + ". Vous avez dépassé 21.  Vous avez perdu.");
                    System.out.println("L'autre carte du croupier était "
                            + mainCroupier.selectionnerCarte(1));
                    Player.argent = Player.argent - mise;
                    joueurexit = true;
                    Rejouer();

                }
            }

        }

        if (joueurexit == false && getblackjack == false) {

            while (mainCroupier.valeurBlackJack() <= 16 && joueurexit == false) {
                Carte newCard = paquet.tirerCarte();
                System.out.println("Le croupier tire " + newCard);
                mainCroupier.ajouterCarte(newCard);
                if (mainCroupier.valeurBlackJack() > 21) {
                    System.out.println("");
                    System.out.println("Le dealer a dépassé 21.  Vous avez gagné.");
                    Player.argent = Player.argent + mise;
                    croupiersuperieur21 = true;
                    Rejouer();
                }
            }
            if (croupiersuperieur21 == false) {

                System.out.println("Le total du croupier est " + mainCroupier.valeurBlackJack());

                System.out.println("");
                if (mainCroupier.valeurBlackJack() == mainJoueur.valeurBlackJack()) {
                    System.out.println("Egalité. Le croupier gagne. Vous avez perdu.");
                    Player.argent = Player.argent - mise;

                    Rejouer();
                } else if (mainCroupier.valeurBlackJack() > mainJoueur.valeurBlackJack() && mainCroupier.valeurBlackJack() <= 21 && mainJoueur.valeurBlackJack() <= 21) {
                    System.out.println("Le croupier gagne " + mainCroupier.valeurBlackJack()
                            + " points à " + mainJoueur.valeurBlackJack() + ".");
                    Player.argent = Player.argent - mise;

                    Rejouer();
                } else {
                    System.out.println("Vous gagnez " + mainJoueur.valeurBlackJack()
                            + " points à " + mainCroupier.valeurBlackJack() + ".");

                    Player.argent = Player.argent + mise;

                    Rejouer();
                }
            }
        }
    }

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

    public void sleep500() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {

        }
    }

    @Override
    public void Quitter() {
        System.out.println("Vous quittez la table avec " + Player.argent + "$");
        // MenuCasino.ChoixMenu.argent = argent;
    }

} // end classe Blackjack
