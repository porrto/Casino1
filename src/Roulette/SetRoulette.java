/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roulette;

import java.util.Random;

/**
 *
 * @author isen
 */
public class SetRoulette {

    public int nombre;

    public SetRoulette() {
        Random rand = new Random();
        nombre = rand.nextInt(37);
    }

    public Tirage SetUpRoulette() {

        Tirage tirage = new Tirage(nombre, getCouleur(nombre), getParité(nombre));

        return tirage;

    }

    public String getCouleur(int nombre) {
        String couleur = "";

        if (nombre == 32 || nombre == 19 || nombre == 21 || nombre == 25 || nombre == 34 || nombre == 27 || nombre == 36 || nombre == 30 || nombre == 23 || nombre == 5
                || nombre == 16 || nombre == 1 || nombre == 14 || nombre == 9 || nombre == 18 || nombre == 7 || nombre == 12 || nombre == 3) {
            couleur = "rouge";
        } else {
            if (nombre != 0) {
                couleur = "noir";
            }
        }
        return couleur;
    }

    public String getParité(int nombre) {
        String parité = "";

        if (nombre % 2 == 0) {
            parité = "pair";
        } else {
            parité = "impair";
        }

        return parité;
    }

}
