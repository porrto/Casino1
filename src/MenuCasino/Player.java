/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuCasino;

/**
 *Chaque joueur dispose d'argent et un taux d'alcoolémie qui dépend du nombre de verre d'alcool qu'il prend au bar
 * @author clement
 */
public  class Player {
    /**
     * Argent du joueur
     */
    public static double argent;
    /**
     * Taux d'alcoolémie du joueur
     */
    public static double tauxalcool;
    
    /**
     * A chaque création d'un joueur on lui associe de l'argent et un taux d'alcoolémie à 0
     * @param argent
     *                  Argent du joueur
     * @param alcoolémie 
     *                  Alcoolémie du joueur = 0 au début
     */
    public Player(double argent, double alcoolémie) {
        this.argent = argent;
        this.tauxalcool = alcoolémie;
    }
}
