package MachineASous;

import java.util.Random;

/**
 *
 * @author isen
 */
public class Tableau {

    public int[][] cases = new int[3][3];

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
