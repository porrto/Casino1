package Blackjack;

/**
 * Classe fille de Main qui définit une main de Blackjack
 *
 * @see Main
 * @author enzo
 */
public class MainBlackjack extends Main {

    /**
     * Calcule la valeur de la main d'un joueur
     *
     * @return la valeur de la main (une tête vaut 10, un as vaut 1 ou 10)
     */
    public int valeurBlackJack() {

        int val;
        boolean as;
        int cartes;

        val = 0;
        as = false;
        cartes = nombreDeCartes();

        for (int i = 0; i < cartes; i++) {

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

        if (as == true && val + 10 <= 21) {
            val = val + 10;
        }

        return val;

    }

}
