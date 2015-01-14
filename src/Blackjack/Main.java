package Blackjack;



import java.util.Vector;

public class Main {

   private Vector main;  
   
   public Main() {
           
      main = new Vector();
   }
   
   public void vider() {
         
      main.removeAllElements();
   }
   
   public void ajouterCarte(Carte c) {
         
      if (c != null)
         main.addElement(c);
   }
   
   public void enleverCarte(Carte c) {
         
      main.removeElement(c);
   }
   
   public void enleverCartePosition(int position) {
         
      if (position >= 0 && position < main.size())
         main.removeElementAt(position);
   }
   
   public int nombreDeCartes() {
        
      return main.size();
   }
   
   public Carte selectionnerCarte(int position) {
          
      if (position >= 0 && position < main.size())
         return (Carte)main.elementAt(position);
      else
         return null;
   }
   
   public void triParSuites() {
         
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
