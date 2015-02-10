package Blackjack;

import java.util.ArrayList;

public class Main {

    private ArrayList main;

    public Main() {

        main = new ArrayList();
    }

    public void vider() {

        main.clear();
    }

    public void ajouterCarte(Carte c) {

        if (c != null) {
            main.add(c);
        }
    }

    public void enleverCarte(Carte c) {

        main.remove(c);
    }

    public void enleverCartePosition(int position) {

        if (position >= 0 && position < main.size()) {
            main.remove(position);
        }
    }

    public int nombreDeCartes() {

        return main.size();
    }

    public Carte selectionnerCarte(int position) {

        if (position >= 0 && position < main.size()) {
            return (Carte) main.get(position);
        } else {
            return null;
        }
    }

    public void triParSuites() {

        ArrayList nouvelleMain = new ArrayList();
        while (main.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Carte c = (Carte) main.get(0);  // Minumal card.
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

    public void triParValeur() {

        ArrayList nouvelleMain = new ArrayList();
        while (main.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Carte c = (Carte) main.get(0);  // Minumal card.
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
