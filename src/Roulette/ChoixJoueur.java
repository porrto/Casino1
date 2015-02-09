/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roulette;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 * Permet de garder en mémoire les différents choix du joueur lorsqu'il joue à la roueltte
 * @author clement
 * 
 */
public class ChoixJoueur {

    /**
     * Instancie une liste de type ChoixJoueurNumber qui va permettre d'enregistrer les numéros parié avec leurs mises 
     * @see ChoixJoueurNumber
     */
    public static List<ChoixJoueurNumber>  number = new ArrayList();
    
    /**
     *  Permet de savoir si le joueur a parié pair
    */
    public static boolean choixPair = false;
    
    /**
     * Permet de savoir si le joueur a parié impair
     */    
    public static boolean choixImpair = false;
    
    /**
     * Permet de savoir si le joueur a parié noir
     */
    public static boolean choixNoir = false;
    
    /**
     * Permet de savoir si le joueur a parié rouge
     */
    public static boolean choixRouge = false;
    
/**
     * Permet de savoir  quelle est la mise pour pair
     */ 
    public static int misePair = 0;
    
    /**
     * Permet de savoir  quelle est la mise pour impair
     */  
    public static int miseImpair = 0;
    
    /**
     * Permet de savoir  quelle est la mise pour noir
     */
    public static int miseNoir = 0;
    
    /**
     * Permet de savoir  quelle est la mise pour rouge
     */
    public static int miseRouge = 0;
    
}
