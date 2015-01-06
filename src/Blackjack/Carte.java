package Blackjack;

/*
   An object of class card represents one of the 52 cards in a
   standard deck of playing cards.  Each card has a suit and
   a value.
*/


public class Carte {

    public final static int PIQUES = 0,       // Codes for the 4 suits.
                            COEUR = 1,
                            CARREAUX = 2,
                            TREFLES = 3;
                            
    public final static int AS = 1,          // Codes for the non-numeric cards.
                            VALET = 11,        //   Cards 2 through 10 have their 
                            DAME = 12,       //   numerical values for their codes.
                            ROI = 13;
                            
    private final int suite;   // The suit of this card, one of the constants
                              //    SPADES, HEARTS, DIAMONDS, CLUBS.
                              
    private final int valeur;  // The value of this card, from 1 to 11.
                             
    public Carte(int laValeur, int laSuite) {
            // Construct a card with the specified value and suit.
            // Value must be between 1 and 13.  Suit must be between
            // 0 and 3.  If the parameters are outside these ranges,
            // the constructed card object will be invalid.
        valeur = laValeur;
        suite = laSuite;
    }
        
    public int getSuite() {
            // Return the int that codes for this card's suit.
        return suite;
    }
    
    public int getValeur() {
            // Return the int that codes for this card's value.
        return valeur;
    }
    
    public String ecrireSuite() {
            // Return a String representing the card's suit.
            // (If the card's suit is invalid, "??" is returned.)
        switch ( suite ) {
           case PIQUES:   return "Piques";
           case COEUR:   return "Coeurs";
           case CARREAUX: return "Carreaux";
           case TREFLES:    return "Trèfles";
           default:       return "??";
        }
    }
    
    public String ecrireValeur() {
            // Return a String representing the card's value.
            // If the card's value is invalid, "??" is returned.
        switch ( valeur ) {
           case 1:   return "As";
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "Valet";
           case 12:  return "Dame";
           case 13:  return "Roi";
           default:  return "??";
        }
    }
    
    @Override
    public String toString() {
           // Return a String representation of this card, such as
           // "10 of Hearts" or "Queen of Spades".
        return ecrireValeur() + " de " + ecrireSuite();
    }


} // end class Card
