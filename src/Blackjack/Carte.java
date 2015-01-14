package Blackjack;




public class Carte {

    public final static int PIQUES = 0,       
                            COEUR = 1,
                            CARREAUX = 2,
                            TREFLES = 3;
                            
    public final static int AS = 1,          
                            VALET = 11,       
                            DAME = 12,       
                            ROI = 13;
                            
    private final int suite;   
                              
    private final int valeur;  
                             
    public Carte(int laValeur, int laSuite) {
            
        valeur = laValeur;
        suite = laSuite;
    }
        
    public int getSuite() {
            
        return suite;
    }
    
    public int getValeur() {
            
        return valeur;
    }
    
    public String ecrireSuite() {
            
        switch ( suite ) {
           case PIQUES:   return "Piques";
           case COEUR:   return "Coeurs";
           case CARREAUX: return "Carreaux";
           case TREFLES:    return "Trèfles";
           default:       return "??";
        }
    }
    
    public String ecrireValeur() {
          
        
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
           
        return ecrireValeur() + " de " + ecrireSuite();
    }


} // end class Card
