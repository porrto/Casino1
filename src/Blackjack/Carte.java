package Blackjack;

/**
 * Définit une carte avec sa valeur et sa suite
 *
 * @author enzo
 */
public class Carte {

    /**
     * Les suites
     */
    public final static int PIQUES = 0,
            COEUR = 1,
            CARREAUX = 2,
            TREFLES = 3;
    /**
     * Les valeurs des têtes
     */
    public final static int AS = 1,
            VALET = 11,
            DAME = 12,
            ROI = 13;
    /**
     * La suite d'une carte (Trefle/Carreau/Pique/Coeur)
     */
    private final int suite;
    /**
     * La valeur d'une carte
     */
    private final int valeur;

    /**
     * Constructeur
     *
     * @param laValeur Donne la valeur de la carte
     * @param laSuite Donne la suite de la carte
     */
    public Carte(int laValeur, int laSuite) {

        valeur = laValeur;
        suite = laSuite;
    }

    /**
     * Get la suite de la carte
     *
     * @return la suite (Piques/Carreaux/Trefle/Coeur)
     */
    public int getSuite() {

        return suite;
    }

    /**
     * Get la valeur de la carte
     *
     * @return la valeur
     */
    public int getValeur() {

        return valeur;
    }

    /**
     * Ecrit en toutes lettres la suite
     *
     * @return la suite sous forme d'un string
     */
    public String ecrireSuite() {

        switch (suite) {
            case PIQUES:
                return "Piques";
            case COEUR:
                return "Coeurs";
            case CARREAUX:
                return "Carreaux";
            case TREFLES:
                return "Trèfles";
            default:
                return "??";
        }
    }

    /**
     * Ecrit en toutes lettres la valeur
     *
     * @return la valeur sous forme d'un string
     */
    public String ecrireValeur() {

        switch (valeur) {
            case 1:
                return "As";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Valet";
            case 12:
                return "Dame";
            case 13:
                return "Roi";
            default:
                return "??";
        }
    }

    /**
     * Ecrit en toutes lettres la valeur et la suite d'une carte
     *
     * @return la carte sous forme d'un string (exemple : Deux de Trèfles)
     */
    @Override
    public String toString() {

        return ecrireValeur() + " de " + ecrireSuite();
    }

}
