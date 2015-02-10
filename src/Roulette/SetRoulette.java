package Roulette;

import java.util.Random;

/**
 *
 *
 *
 * Permet d'obtenir un numéro sur la roulette, avec sa parité et sa couleur
 *
 * @author clement
 */
public class SetRoulette {

    /**
     * Numéro obtenu
     */
    public static int nombre;
    /**
     * Couleur correspondant au numéro
     */
    public static String color;
    /**
     * Parité du numéro
     */
    public static String parite;

    /**
     * Réalise le tirage d'un numéro et détermine sa couleur et sa parité
     */
    public SetRoulette() {
        Random rand = new Random();
        nombre = rand.nextInt(37);

        if (nombre == 32 || nombre == 19 || nombre == 21 || nombre == 25 || nombre == 34 || nombre == 27 || nombre == 36 || nombre == 30 || nombre == 23 || nombre == 5
                || nombre == 16 || nombre == 1 || nombre == 14 || nombre == 9 || nombre == 18 || nombre == 7 || nombre == 12 || nombre == 3) {
            color = "rouge";
        } else {

            color = "noir";

        }

        if (nombre % 2 == 0) {
            parite = "pair";
        } else {
            parite = "impair";
        }
    }
}
