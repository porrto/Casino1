package Blackjack;

/* 
   A subclass of the Hand class that represents a hand of cards
   in the game of Blackjack.  To the methods inherited form Hand,
   it adds the method getBlackjackHand(), which returns the value
   of the hand for the game of Blackjack. 
*/

public class MainBlackjack extends Main {
 
     public int valeurBlackJack() {
            // Returns the value of this hand for the
            // game of Blackjack.

         int val;      // The value computed for the hand.
         boolean as;  // This will be set to true if the
                       //   hand contains an ace.
         int cartes;    // Number of cards in the hand.

         val = 0;
         as = false;
         cartes = nombreDeCartes();

         for ( int i = 0;  i < cartes;  i++ ) {
                 // Add the value of the i-th card in the hand.
             Carte carte;    // The i-th card; 
             int carteVal;  // The blackjack value of the i-th card.
             carte = selectionnerCarte(i);
             carteVal = carte.getValeur();  // The normal value, 1 to 13.
             if (carteVal > 10) {
                 carteVal = 10;   // For a Jack, Queen, or King.
             }
             if (carteVal == 1) {
                 as = true;     // There is at least one ace.
             }
             val = val + carteVal;
          }

             // Now, val is the value of the hand, counting any ace as 1.
             // If there is an ace, and if changing its value from 1 to 
             // 11 would leave the score less than or equal to 21,
             // then do so by adding the extra 10 points to val. 

          if ( as == true  &&  val + 10 <= 21 )
              val = val + 10;

          return val;

     }  // end getBlackjackValue()
 
} // end class BlackjackHand

