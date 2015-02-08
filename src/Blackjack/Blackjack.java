/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;

import Interface.Exit;
import MenuCasino.Player;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author isen
 */
/*
 This program lets the user play Blackjack.  The computer
 acts as the dealer.  The user has a stake of $100, and
 makes a bet on each game.  The user can leave at any time,
 or will be kicked out when he loses all the money.
 House rules:  The dealer hits on a total of 16 or less
 and stands on a total of 17 or more.  Dealer wins ties.
 A new deck of cards is used for each game.
 */

public class Blackjack implements Exit {
    
    public boolean croupiersuperieur21 = false;
    public boolean joueurexit = false ;
    public boolean getblackjack = false ;

    public  void Jouer() {

        System.out.println("Bienvenue à la table de BlackJack");
        System.out.println("");

         // On commence 
        if (Player.argent == 0) {
            System.out.println("Vous n'avez plus d'argent!");

        }

        System.out.println("");
        System.out.println("Il vous reste $" + Player.argent + '.');

        jouerBlackjack();

    } // fin main

    public  void question()  {

        if (Player.argent == 0) {
            System.out.println("Vous n'avez plus d'argent!");
            System.out.println("Vous quittez la table avec " + Player.argent + "$");
        } else {
            System.out.println("Continuer (C) ou Arrêter (A) ?");
            char choix = '?';
            // Réponse utilisateur.
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

            if (choix == 'C') {

                jouerBlackjack();
            } else {
            
                this.Quitter();
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
        double mise = 2000000;

        paquet.mélanger();
        mainCroupier.ajouterCarte(paquet.tirerCarte());
        mainCroupier.ajouterCarte(paquet.tirerCarte());
        mainJoueur.ajouterCarte(paquet.tirerCarte());
        mainJoueur.ajouterCarte(paquet.tirerCarte());

        System.out.println("");
        System.out.println("");

        System.out.println("Vous avez " + Player.argent + " dollars.");

        System.out.println("Combien voulez vous miser ?");

        Scanner sc = new Scanner(System.in);

        while (mise > Player.argent || mise <= 0) {
            mise = 2000000;
            try {
                mise = (double) sc.nextDouble();

            } catch (InputMismatchException e) {

                System.out.println("Vous ne pouvez pas miser cette somme");
                System.out.println("Combien voulez vous miser ?");
                sc.next();

            }
            if (mise > Player.argent || mise <= 0) {
                System.out.println("Vous ne pouvez pas miser cette somme");
                System.out.println("Combien voulez vous miser ?");
            }
        }

        if (mainCroupier.valeurBlackJack() == 21) {
            System.out.println("Le croupier a " + mainCroupier.selectionnerCarte(0)
                    + " et " + mainCroupier.selectionnerCarte(1) + ".");
            System.out.println("Le joueur a " + mainJoueur.selectionnerCarte(0)
                    + " et " + mainJoueur.selectionnerCarte(1) + ".");
            System.out.println("");
            System.out.println("Le croupier a un Blackjack. Le croupier gagne.");
            Player.argent = Player.argent - mise;
            getblackjack = true ;
            question();
            
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
            question();
           
        }

        while (true && joueurexit == false && getblackjack == false) {

            System.out.println("");
            System.out.println("");
            System.out.println("Vos cartes sont");
            for (int i = 0; i < mainJoueur.nombreDeCartes(); i++) {
                System.out.println("    " + mainJoueur.selectionnerCarte(i));
            }
            System.out.println("Le total est de " + mainJoueur.valeurBlackJack());
            System.out.println("");
            System.out.println("Le croupier montre " + mainCroupier.selectionnerCarte(0));
            System.out.println("");
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
                System.out.println("Votre carte est " + nouvelleCarte);
                System.out.println("Votre total est maintenant de" + mainJoueur.valeurBlackJack());
                if (mainJoueur.valeurBlackJack() > 21) {
                    System.out.println("");
                    System.out.println("Vous avez dépassé 21.  Vous avez perdu.");
                    System.out.println("L'autre carte du croupier était "
                            + mainCroupier.selectionnerCarte(1));
                    Player.argent = Player.argent - mise;
                        joueurexit = true ;
                    question();
                    
                }
            }

        }

        /* System.out.println("");
        System.out.println("Le joueur passe");
        System.out.println("Les cartes du croupier sont");
        System.out.println("   " + mainCroupier.selectionnerCarte(0));
        System.out.println("    " + mainCroupier.selectionnerCarte(1)); */
        
        if ( joueurexit == false && getblackjack == false ) {
        
        while (mainCroupier.valeurBlackJack() <= 16 && joueurexit==false) {
            Carte newCard = paquet.tirerCarte();
            System.out.println("Le croupier tire " + newCard);
            mainCroupier.ajouterCarte(newCard);
            if (mainCroupier.valeurBlackJack() > 21) {
                System.out.println("");
                System.out.println("Le dealer a dépassé 21.  Vous avez gagné.");
                  Player.argent = Player.argent + mise;
                  croupiersuperieur21 = true;
                    question();
            }}
        if ( croupiersuperieur21 == false ) {
        
        System.out.println("Le total du croupier est " + mainCroupier.valeurBlackJack());

        System.out.println("");
        if (mainCroupier.valeurBlackJack() == mainJoueur.valeurBlackJack()) {
            System.out.println("Egalité. Le croupier gagne. Vous avez perdu.");
            Player.argent = Player.argent - mise;
                    
                    question();
        } else if (mainCroupier.valeurBlackJack() > mainJoueur.valeurBlackJack() && mainCroupier.valeurBlackJack() <= 21 && mainJoueur.valeurBlackJack() <= 21 ) {
            System.out.println("Le croupier gagne " + mainCroupier.valeurBlackJack()
                    + " points à " + mainJoueur.valeurBlackJack() + ".");
            Player.argent = Player.argent - mise;
                    
                    question();
        } else {
            System.out.println("Vous gagnez " + mainJoueur.valeurBlackJack()
                    + " points à " + mainCroupier.valeurBlackJack() + ".");

          Player.argent = Player.argent + mise;
                    
                    question();
             }
        }
      }
    }
    
    @Override
    public void Quitter() {
          System.out.println("Vous quittez la table avec " + Player.argent + "$");
         // MenuCasino.ChoixMenu.argent = argent;
    }

} // end classe Blackjack
