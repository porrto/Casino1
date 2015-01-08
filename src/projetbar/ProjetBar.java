/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbar;

/**
 *
 * @author isen
 */
public class ProjetBar {

    /**
     * @param args the command line arguments
     */
    public static void Jouer(double argent) {
        
        Bar bar = new Bar();
        PorteMonnaie.argent=argent;
        bar.choixJoueur();
    }
    
}
