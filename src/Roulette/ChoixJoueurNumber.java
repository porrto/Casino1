/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roulette;

/**
 *
 *
 * 
 * A chaque instanciation l'objet aura un numéro qui correspond au numéro parié par le joueur ainsi que sa mise correspondante
 *  @author clement
 */
public class ChoixJoueurNumber {

    /**
     *  Choix du numéro de mise du  joueur
     */
    int choix;
    /**
     * Mise correspondant au numéro
     */
    int mise;

    /**
     * Le constructeur va permettre d'associer à l'objet instancié, son numéro et sa mise
     * @param choix
     *                  On demande le choix de numéro de mise du joueur
     * @param mise 
     *                  On demande la mise correspondant au numéro rentré
     */                 
    public ChoixJoueurNumber(int choix, int mise) {

        this.choix = choix;
        this.mise = mise;

    }

}
