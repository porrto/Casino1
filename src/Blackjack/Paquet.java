package Blackjack;

/**
 * Définit le paquet de 52 cartes
 *
 * @author enzo
 */
public class Paquet {

    /**
     * Définit un paquet comme un tableau de cartes
     */
    private final Carte[] paquet;
    /**
     * Nombre de cartes retirées dans le paquet
     */
    private int cartesTirees;

    /**
     * Crée un paquet et les cartes qui le compose
     */
    public Paquet() {

        paquet = new Carte[52];
        int cartesCreees = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int value = 1; value <= 13; value++) {
                paquet[cartesCreees] = new Carte(value, suit);
                cartesCreees++;
            }
        }
        cartesTirees = 0;
    }

    /**
     * Melange le paquet de manière aléatoire
     */
    public void melanger() {

        for (int i = 51; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Carte temp = paquet[i];
            paquet[i] = paquet[rand];
            paquet[rand] = temp;
        }
        cartesTirees = 0;
    }

    /**
     * Donne le nombre de cartes restantes dans le paquet
     *
     * @return le nombre de cartes restantes dans le paquet
     */
    public int cartesRestantes() {

        return 52 - cartesTirees;
    }

    /**
     * Tire la carte la plus haute du paquet
     *
     * @return la carte
     */
    public Carte tirerCarte() {

        if (cartesTirees == 52) {
            melanger();
        }
        cartesTirees++;
        return paquet[cartesTirees - 1];
    }

}
