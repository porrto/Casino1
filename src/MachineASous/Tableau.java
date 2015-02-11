package MachineASous;

import java.util.Random;

/**
 * Définit le tableau 3x3 d'entiers utilisé pour la machine à sous
 *
 * @author enzo
 */
public class Tableau {

    /**
     * Tableau d'entiers
     */
    public int[][] cases = new int[3][3];

    /**
     * Crée le tableau avec des valeurs aléatoires de 1 à 4
     *
     * @return le tableau précédemment créé
     */
    public int[][] creerTableau() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                try {
                    cases[i][j] = caseAleatoire();
                } catch (NullPointerException e) {
                    System.out.println("Erreur");
                }
            }
        }

        return cases;
    }

    /**
     * Retourne une valeur aléatoire avec probabilités différentes de 1 à 4
     *
     * @return la valeur aléatoire de 1 à 4
     */
    public int caseAleatoire() {

        Random rand = new Random();
        int a = rand.nextInt(10);

        if (a < 4) {
            return 1;
        }
        if (a >= 4 && a < 7) {
            return 2;
        }
        if (a >= 7 && a < 9) {
            return 3;
        } else {
            return 4;
        }
    }

}
