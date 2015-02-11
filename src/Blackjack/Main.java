package Blackjack;

import java.util.ArrayList;

/**
 * Définit une main (attention à le lire en français et non en anglais)
 *
 * @author enzo
 */
public class Main {

    /**
     * Definit la main comme une liste de cartes
     */
    private ArrayList main;

    /**
     * Construit une main
     */
    public Main() {

        main = new ArrayList();
    }

    /**
     * Vide une main
     */
    public void vider() {

        main.clear();
    }

    /**
     * Ajoute une carte a la main
     *
     * @param c La Carte à ajouter
     */
    public void ajouterCarte(Carte c) {

        if (c != null) {
            main.add(c);
        }
    }

    /**
     * Enleve une carte à la main
     *
     * @param c La carte à enlever
     */
    public void enleverCarte(Carte c) {

        main.remove(c);
    }

    /**
     * Enleve une carte de la main à une position donnée
     *
     * @param position la position à laquelle se trouve la carte à enlever
     */
    public void enleverCartePosition(int position) {

        if (position >= 0 && position < main.size()) {
            main.remove(position);
        }
    }

    /**
     * Retourne le nombre de cartes dans la main
     *
     * @return la taille de la main
     */
    public int nombreDeCartes() {

        return main.size();
    }

    /**
     * Sélectionne une carte à une position donnée
     *
     * @param position la position à laquelle se trouve la carte à sélectionner
     * @return la carte sélectionnée
     */
    public Carte selectionnerCarte(int position) {

        if (position >= 0 && position < main.size()) {
            return (Carte) main.get(position);
        } else {
            return null;
        }
    }

    /**
     * Trie la main par suite (Piques/Coeur/Carreaux/Trefles)
     */
    public void triParSuites() {

        ArrayList nouvelleMain = new ArrayList();
        while (main.size() > 0) {
            int pos = 0;
            Carte c = (Carte) main.get(0);
            for (int i = 1; i < main.size(); i++) {
                Carte c1 = (Carte) main.get(i);
                if (c1.getSuite() < c.getSuite()
                        || (c1.getSuite() == c.getSuite() && c1.getValeur() < c.getValeur())) {
                    pos = i;
                    c = c1;
                }
            }
            main.remove(pos);
            nouvelleMain.add(c);
        }
        main = nouvelleMain;
    }

    /**
     * Trie la main par valeur
     */
    public void triParValeur() {

        ArrayList nouvelleMain = new ArrayList();
        while (main.size() > 0) {
            int pos = 0;
            Carte c = (Carte) main.get(0);
            for (int i = 1; i < main.size(); i++) {
                Carte c1 = (Carte) main.get(i);
                if (c1.getValeur() < c.getValeur()
                        || (c1.getValeur() == c.getValeur() && c1.getSuite() < c.getSuite())) {
                    pos = i;
                    c = c1;
                }
            }
            main.remove(pos);
            nouvelleMain.add(c);
        }
        main = nouvelleMain;
    }

}
