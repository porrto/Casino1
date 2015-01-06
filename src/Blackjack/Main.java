package Blackjack;

/*
    An object of type Hand represents a hand of cards.  The maximum number of
    cards in the hand can be specified in the constructor, but by default
    is 5.  A utility function is provided for computing the value of the
    hand in the game of Blackjack.
*/

import java.util.Vector;

public class Main {

   private Vector main;   // The cards in the hand.
   
   public Main() {
           // Create a Hand object that is initially empty.
      main = new Vector();
   }
   
   public void vider() {
         // Discard all the cards from the hand.
      main.removeAllElements();
   }
   
   public void ajouterCarte(Carte c) {
         // Add the card c to the hand.  c should be non-null.  (If c is
         // null, nothing is added to the hand.)
      if (c != null)
         main.addElement(c);
   }
   
   public void enleverCarte(Carte c) {
         // If the specified card is in the hand, it is removed.
      main.removeElement(c);
   }
   
   public void enleverCartePosition(int position) {
         // If the specified position is a valid position in the hand,
         // then the card in that position is removed.
      if (position >= 0 && position < main.size())
         main.removeElementAt(position);
   }
   
   public int nombreDeCartes() {
         // Return the number of cards in the hand.
      return main.size();
   }
   
   public Carte selectionnerCarte(int position) {
          // Get the card from the hand in given position, where positions
          // are numbered starting from 0.  If the specified position is
          // not the position number of a card in the hand, then null
          // is returned.
      if (position >= 0 && position < main.size())
         return (Carte)main.elementAt(position);
      else
         return null;
   }
   
   public void triParSuites() {
         // Sorts the cards in the hand so that cards of the same suit are
         // grouped together, and within a suit the cards are sorted by value.
         // Note that aces are considered to have the lowest value, 1.
      Vector nouvelleMain = new Vector();
      while (main.size() > 0) {
         int pos = 0;  // Position of minimal card.
         Carte c = (Carte)main.elementAt(0);  // Minumal card.
         for (int i = 1; i < main.size(); i++) {
            Carte c1 = (Carte)main.elementAt(i);
            if ( c1.getSuite() < c.getSuite() ||
                    (c1.getSuite() == c.getSuite() && c1.getValeur() < c.getValeur()) ) {
                pos = i;
                c = c1;
            }
         }
         main.removeElementAt(pos);
         nouvelleMain.addElement(c);
      }
      main = nouvelleMain;
   }
   
   public void triParValeur() {
         // Sorts the cards in the hand so that cards of the same value are
         // grouped together.  Cards with the same value are sorted by suit.
         // Note that aces are considered to have the lowest value, 1.
      Vector nouvelleMain = new Vector();
      while (main.size() > 0) {
         int pos = 0;  // Position of minimal card.
         Carte c = (Carte)main.elementAt(0);  // Minumal card.
         for (int i = 1; i < main.size(); i++) {
            Carte c1 = (Carte)main.elementAt(i);
            if ( c1.getValeur() < c.getValeur() ||
                    (c1.getValeur() == c.getValeur() && c1.getSuite() < c.getSuite()) ) {
                pos = i;
                c = c1;
            }
         }
         main.removeElementAt(pos);
         nouvelleMain.addElement(c);
      }
      main = nouvelleMain;
   }
   
}
