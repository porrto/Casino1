package Bar;

/**
 *
 * On asigne à chaque boisson créée leurs paramètres
 *
 * @author clement
 *
 */
public class Boisson {

    /**
     * Le nom de la boisson
     */
    public String name;
    /**
     * Le prix de la boisson
     */
    public int price;
    /**
     * Le taux d'alcoolémie, égal pour toutes les boissons de la carte sauf les
     * sodas où on assignera 0
     */
    public double taux = 0.20;
    /**
     * Le numéro de la boisson figurant sur la carte
     */
    public int number;

    /**
     * Permet de donner à chaque boisson :
     * <ul>
     * <li>Un nom</li>
     * <li>Un prix</li>
     * <li>Un numéro sur la carte</li>
     * </ul>
     *
     * @param name Le nom de la boisson
     * @param price Le prix de la boisson
     * @param number Le numéro figurant sur la carte
     */
    public Boisson(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

}
