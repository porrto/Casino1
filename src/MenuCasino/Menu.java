/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuCasino;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author isen
 */
public class Menu {

    public static double argent = 50;

    public static void main(String[] args) {

        ChoixMenu cm = new ChoixMenu(argent);
        
        System.out.println("Vous partez avec " + argent);

    }
}
