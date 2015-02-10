package Bar;

import MenuCasino.Player;
import java.util.Scanner;

/**
 *
 * Cette classe gère l'alcoolémie du joueur
 *
 * @author clement
 */
public abstract class Alcoolemie {

    /**
     * Permet de savoir si le joueur a dépassé 0.5 grammes
     */
    static boolean positif = false;
    /**
     * Permet de savoir si le joueur accepte de boire son verre malgré son
     * alcoolémie
     */
    static boolean drink = false;
    /**
     * Permet de savoir si le joueur est trop saoul pour rester dans le casino
     */
    static boolean saoul = false;

    /**
     * A chaque verre contenant de l'alcool on vérifie si le joueur ne dépasse
     * pas la limite autorisée pour conduire et pour être dans le casino.
     *
     * @param ref C'est le taux d'alcool de la boisson selectionnée
     *
     */
    public static void verifTaux(double ref) {

        Scanner sc = new Scanner(System.in);

        if (positif == false) {
            if (Player.tauxalcool + ref > 0.5) {
                System.out.println("Attention vous avez dépassé la limite autorisée pour conduire, voulez vous boire ce verre (O) or (N) ?");
                String choix = sc.next();
                switch (choix) {
                    case "O":
                        Player.tauxalcool = Player.tauxalcool + ref;
                        positif = true;
                        drink = true;
                        break;

                    case "N":
                        positif = false;
                        drink = false;
                        break;
                    default:
                        System.out.println("Veuillez rentrer O or N ");
                }

            } else {
                positif = false;
                Player.tauxalcool = Player.tauxalcool + ref;
                drink = true;
            }

        } else {
            if (Player.tauxalcool < 1) {
                Player.tauxalcool = Player.tauxalcool + ref;
                drink = true;
            } else {
                Player.tauxalcool = Player.tauxalcool + ref;
                drink = true;
                saoul = true;
                System.out.println("Vous risquez de vous faire virer, vous êtes saoul");
            }
        }
    }

}
