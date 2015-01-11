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

  
    public static void Jouer(double argent) {
        
      Bar bar = new Bar();
      PorteMonnaie.argent=argent;    // On met l'argent du joueur dans le porte monnaie du bar
      bar.choixJoueur();
      
      MenuCasino.Menu.argent=PorteMonnaie.argent;  // On récolte l'argent perdu ou gagner
      
    }
    
}
