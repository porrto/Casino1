/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MachineASous;

import java.util.Random;
import java.lang.NullPointerException;

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
                    System.out.println("merde");
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
