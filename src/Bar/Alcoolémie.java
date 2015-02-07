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
 * @author isen
 */
public abstract class Alcoolémie {
  
    static boolean positif = false;
    static boolean drink = false;
    static boolean soul = false;

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
            }
        }
    }

}
