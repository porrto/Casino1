/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roulette;

/**
 *
 * @author isen
 */
public class PorteMonnaie {

    public static double argent;

    public static void gainArgent(int gain) {

        argent = argent + gain;
    }

    public static void miseArgent(int mise) {

        argent = argent - mise;

    }

}
