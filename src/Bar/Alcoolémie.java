/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

import MenuCasino.Player;
import java.util.Scanner;

/**
 * 
 *Cette classe gère l'alcoolémie du joueur
 * 
 * @author clement
 */
public abstract class Alcoolémie {
  
    /**
     *  Permet de savoir si le jouer a dépassé 0.5
     */
    static boolean positif = false;
    /**
     *  Permet de savoir si le joueur accepte de boire son faire malgrès son alcoolémie
     */
    static boolean drink = false;
    /**
     * Permet de savoir si le joueur est trop soul pour rester dans le casino
     */
    static boolean soul = false;

/**
 * A chaque verre contenant de l'alcool on vérifie si le joueur ne dépasse pas la limite autorisé pour conduire
 * et pour être dans le casino.
 * 
 * @param ref 
 *                  C'est le taux d'alcool de la boisson selectionée
 * 
 */                 
    public static void verifTaux(double ref) {

        Scanner sc = new Scanner(System.in);

        if (positif == false) {
            if (Player.tauxalcool + ref > 0.5) {
                System.out.println("Attention vous avez dépassé la limite autorisé pour conduire, voulez vous boire ce verre (Y) or (N) ?");
                String choix = sc.next();
                switch (choix) {
                    case "Y":
                        Player.tauxalcool = Player.tauxalcool + ref;
                        positif = true;
                        drink = true;
                        break;

                    case "N":
                        positif = false;
                        drink = false;
                        break;
                    default:
                        System.out.println("Veuillez rentrer Y or N ");
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
                soul = true;
                System.out.println("Vous riquez de vous faire virer, vous êtes soul");
            }
        }
    }

}
