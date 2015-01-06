package Blackjack ;
/* 
    An object of type Deck represents an ordinary deck of 52 playing cards.
    The deck can be shuffled, and cards can be dealt from the deck.
*/

public class Paquet {

    private final Carte[] paquet;   // An array of 52 Cards, representing the deck.
    private int cartesTirées; // How many cards have been dealt from the deck.
    
    public Paquet() {
           // Create an unshuffled deck of cards.
       paquet = new Carte[52];
       int cartesCréées = 0; // How many cards have been created so far.
       for ( int suit = 0; suit <= 3; suit++ ) {
          for ( int value = 1; value <= 13; value++ ) {
             paquet[cartesCréées] = new Carte(value,suit);
             cartesCréées++;
          }
       }
       cartesTirées = 0;
    }
    
    public void mélanger() {
          // Put all the used cards back into the deck, and shuffle it into
          // a random order.
        for ( int i = 51; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Carte temp = paquet[i];
            paquet[i] = paquet[rand];
            paquet[rand] = temp;
        }
        cartesTirées = 0;
    }
    
    public int cartesRestantes() {
          // As cards are dealt from the deck, the number of cards left
          // decreases.  This function returns the number of cards that
          // are still left in the deck.
        return 52 - cartesTirées;
    }
    
    public Carte tirerCarte() {
          // Deals one card from the deck and returns it.
        if (cartesTirées == 52)
           mélanger();
        cartesTirées++;
        return paquet[cartesTirées - 1];
    }

} // end class Deck
