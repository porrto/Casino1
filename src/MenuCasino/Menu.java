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
 * @author clement
 */
public class Menu {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Combien d'argent avez vous ?");
        double argent = sc.nextInt();
        
        Player player1 = new Player(argent,0);
        ChoixMenu cm = new ChoixMenu();
        
        System.out.println("Vous partez avec " + Player.argent);

    }
}
