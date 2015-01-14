package Blackjack ;

public class Paquet {

    private final Carte[] paquet;   
    private int cartesTirées; 
    
    public Paquet() {
           
       paquet = new Carte[52];
       int cartesCréées = 0;
       for ( int suit = 0; suit <= 3; suit++ ) {
          for ( int value = 1; value <= 13; value++ ) {
             paquet[cartesCréées] = new Carte(value,suit);
             cartesCréées++;
          }
       }
       cartesTirées = 0;
    }
    
    public void mélanger() {
          
        for ( int i = 51; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Carte temp = paquet[i];
            paquet[i] = paquet[rand];
            paquet[rand] = temp;
        }
        cartesTirées = 0;
    }
    
    public int cartesRestantes() {
         
        return 52 - cartesTirées;
    }
    
    public Carte tirerCarte() {
          
        if (cartesTirées == 52)
           mélanger();
        cartesTirées++;
        return paquet[cartesTirées - 1];
    }

} // end class Deck
