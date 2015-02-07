/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

import java.util.Scanner;

/**
 *
 * @author isen
 */
public abstract class Alcoolémie {

    static double taux = 0;
    static boolean positif = false;
    static boolean drink = false;
    static boolean soul = false;

    public static void verifTaux(double ref) {

        Scanner sc = new Scanner(System.in);

        if (positif == false) {
            if (taux + ref > 0.5) {
                System.out.println("Attention vous avez dépassé la limite autorisé pour conduire, voulez vous boire ce verre (Y) or (N) ?");
                String choix = sc.next();
                switch (choix) {
                    case "Y":
                        taux = taux + ref;
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
                taux = taux + ref;
                drink = true;
            }

        } else {
            if (taux < 1) {
                taux = taux + ref;
                drink = true;
            } else {
                taux = taux + ref;
                drink = true;
                soul = true;
            }
        }
    }

}
