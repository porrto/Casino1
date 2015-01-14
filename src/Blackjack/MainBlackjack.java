package Blackjack;



public class MainBlackjack extends Main {
 
     public int valeurBlackJack() {
            

         int val;     
         boolean as;  
         int cartes;   

         val = 0;
         as = false;
         cartes = nombreDeCartes();

         for ( int i = 0;  i < cartes;  i++ ) {
               
             Carte carte;     
             int carteVal; 
             carte = selectionnerCarte(i);
             carteVal = carte.getValeur();  
             if (carteVal > 10) {
                 carteVal = 10;   
             }
             if (carteVal == 1) {
                 as = true;     
             }
             val = val + carteVal;
          }

             

          if ( as == true  &&  val + 10 <= 21 )
              val = val + 10;

          return val;

     }  
 
} 

