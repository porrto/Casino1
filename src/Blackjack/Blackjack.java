/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;
import java.io.IOException;
import java.util.Scanner ;
import java.util.InputMismatchException ;
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
    
    public class Blackjack {
       
        
       public static void Jouer(double argent) {
       
                 // Amount of money the user has.
                   // Amount user bets on a game.
             // Did the user win the game?
          
          System.out.println("Bienvenue à la table de BlackJack");
          System.out.println("");
          
         // User starts with $100.
       
          
              if (argent == 0) {
                 System.out.println("Vous n'avez plus d'argent!");
                 
              }
          
          
          System.out.println("");
          System.out.println("Il vous reste $" + argent + '.');
       
           jouerBlackjack(argent) ;
         
    } // end main()
       
       static void question(double argent){
           
            if (argent == 0) {
                 System.out.println("Vous n'avez plus d'argent!");
                 System.out.println("Vous quittez la table avec " + argent +"$") ;
              }
               
               else {
          System.out.println("Continuer (C) ou Arrêter (A) ?");
               char choix ='?';
              // User's response, 'C' or 'A'.
               do { 
                   try { choix = (char) System.in.read(); }
                   catch (IOException e){
                    System.out.println("Error reading from user");
                    } 
               if (choix != 'C' && choix != 'A'){
                   System.out.println("Veuillez entrer C ou A") ; }
               } 
               while (choix != 'C' && choix != 'A');
    
               /* If the user Hits, the user gets a card.  If the user Stands,
                  the loop ends (and it's the dealer's turn to draw cards).
               */
    
               if ( choix == 'C' ) {
                       // Loop ends; user is done taking cards.
                   jouerBlackjack(argent);
               }
               else {
                   
                   System.out.println("Vous quittez la table avec " + argent +"$") ;
                     MenuCasino.Menu.argent=argent;
               }
       } }
       
       static double jouerBlackjack(double argent) {
             // Let the user play one game of Blackjack.
             // Return true if the user wins, false if the user loses.
    
          Paquet paquet;                  // A deck of cards.  A new deck for each game.
          MainBlackjack mainCroupier;   // The dealer's hand.
          MainBlackjack mainJoueur;     // The user's hand.
          
          paquet = new Paquet();
          mainCroupier = new MainBlackjack();
          mainJoueur = new MainBlackjack();
          double mise=2000000; 
    
          /*  Shuffle the deck, then deal two cards to each player. */
          
          paquet.mélanger();
          mainCroupier.ajouterCarte(paquet.tirerCarte() );
          mainCroupier.ajouterCarte(paquet.tirerCarte() );
          mainJoueur.ajouterCarte(paquet.tirerCarte() );
          mainJoueur.ajouterCarte(paquet.tirerCarte() );
          
          System.out.println("");
          System.out.println("");
          
          /* Check if one of the players has Blackjack (two cards totaling to 21).
             The player with Blackjack wins the game.  Dealer wins ties.
          */
          System.out.println("Vous avez " + argent + " dollars.");
            
                System.out.println("Combien voulez vous miser ?");
                
                 Scanner sc = new Scanner(System.in);

                 while (mise > argent || mise <= 0) {
                     mise=2000000;
                    try {
                     mise= (double) sc.nextDouble();
                 
                }
                
                
                catch (InputMismatchException e){
               
                     System.out.println("Vous ne pouvez pas miser cette somme");
                     System.out.println("Combien voulez vous miser ?");
                     sc.next();
                 
                }
                    if (mise > argent || mise <=0){
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
               argent = argent - mise ;
               question(argent);
               return argent;
          }
          
          if (mainJoueur.valeurBlackJack() == 21) {
               System.out.println("Le croupier a " + mainCroupier.selectionnerCarte(0)
                                       + " et " + mainCroupier.selectionnerCarte(1) + ".");
               System.out.println("Le joueur a " + mainJoueur.selectionnerCarte(0)
                                         + " et " + mainJoueur.selectionnerCarte(1) + ".");
               System.out.println("");
              System.out.println("Vous avez un Blackjack. Vous gagnez.");
              argent = argent + mise*1.5 ;
              question(argent);
               return argent;
          }
          
          /*  If neither player has Blackjack, play the game.  First the user 
              gets a chance to draw cards (i.e., to "Hit").  The while loop ends 
              when the user chooses to "Stand".  If the user goes over 21,
              the user loses immediately.
          */
          
          while (true) {
              
               /* Display user's cards, and let user decide to Hit or Stand. */
    
               System.out.println("");
               System.out.println("");
              System.out.println("Vos cartes sont");
               for ( int i = 0; i < mainJoueur.nombreDeCartes(); i++ )
                  System.out.println("    " + mainJoueur.selectionnerCarte(i));
               System.out.println("Le total est de " + mainJoueur.valeurBlackJack());
               System.out.println("");
               System.out.println("Le croupier montre " + mainCroupier.selectionnerCarte(0));
               System.out.println("");
              System.out.println("Tirer (T) ou Passer (P)? ");
               char action ='?';
              // User's response, 'H' or 'S'.
               do { 
                   try { action = (char) System.in.read(); }
                   catch (IOException e){
                    System.out.println("Error reading from user");
                    } 
               if (action != 'T' && action != 'P')
                   System.out.println("Veuillez entrer T ou P") ;
               } 
               while (action != 'T' && action != 'P');
    
               /* If the user Hits, the user gets a card.  If the user Stands,
                  the loop ends (and it's the dealer's turn to draw cards).
               */
    
               if ( action == 'P' ) {
                       // Loop ends; user is done taking cards.
                   break;
               }
               else {  // userAction is 'H'.  Give the user a card.  
                       // If the user goes over 21, the user loses.
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
                       argent = argent - mise ;
                       question(argent);
                       return argent;  
                   }
               }
               
          } // end while loop
          
          /* If we get to this point, the user has Stood with 21 or less.  Now, it's
             the dealer's chance to draw.  Dealer draws cards until the dealer's
             total is > 16.  If dealer goes over 21, the dealer loses.
          */
    
          System.out.println("");
         System.out.println("Le joueur passe");
          System.out.println("Les cartes du croupier sont");
          System.out.println("   " + mainCroupier.selectionnerCarte(0));
          System.out.println("    " + mainCroupier.selectionnerCarte(1));
          while (mainCroupier.valeurBlackJack() <= 16) {
             Carte newCard = paquet.tirerCarte();
             System.out.println("Le croupier tire " + newCard);
             mainCroupier.ajouterCarte(newCard);
             if (mainCroupier.valeurBlackJack() > 21) {
                System.out.println("");
                System.out.println("Le dealer a dépassé 21.  Vous avez gagné.");
                argent = argent + mise ;
                question(argent);
                return argent;
             }
          }
         System.out.println("Le total du croupier est " + mainCroupier.valeurBlackJack());
          
          /* If we get to this point, both players have 21 or less.  We
             can determine the winner by comparing the values of their hands. */
          
          System.out.println("");
          if (mainCroupier.valeurBlackJack() == mainJoueur.valeurBlackJack()) {
            System.out.println("Egalité. Le croupier gagne. Vous avez perdu.");
            argent = argent - mise ;
            question(argent);
             return argent;
          }
          else if (mainCroupier.valeurBlackJack() > mainJoueur.valeurBlackJack()) {
             System.out.println("Le croupier gagne " + mainCroupier.valeurBlackJack() 
                              + " points à " + mainJoueur.valeurBlackJack() + ".");
             argent = argent - mise ;
             question(argent);
             return argent;
          }
          else {
             System.out.println("Vous gagnez " + mainJoueur.valeurBlackJack() 
                              + " points à " + mainCroupier.valeurBlackJack() + ".");
             
             argent = argent + mise ;
             question(argent);
             return argent;
          }
        
          
       }  // end playBlackjack()
    
    
    } // end class Blackjack