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
 * @author isen
 */
public class ChoixJoueur {

    List<ChoixJoueurNumber> number = new ArrayList();
    public boolean choixPair = false;
    public boolean choixImpair = false;
    public boolean choixNoir = false;
    public boolean choixRouge = false;

    public int misePair = 0;
    public int miseImpair = 0;
    public int miseNoir = 0;
    public int miseRouge = 0;

    /*  public List<ChoixJoueurList> setNumberList(int choix, int mise) {
        
     ChoixJoueurList list = new ChoixJoueurList(choix, mise);
        
     List<ChoixJoueurList> number = new ArrayList();
       
        
        
     }*/
}
