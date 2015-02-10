package Blackjack;

public class Paquet {

    private final Carte[] paquet;
    private int cartesTirees;

    public Paquet() {

        paquet = new Carte[52];
        int cartesCreees = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int value = 1; value <= 13; value++) {
                paquet[cartesCreees] = new Carte(value, suit);
                cartesCreees++;
            }
        }
        cartesTirees = 0;
    }

    public void melanger() {

        for (int i = 51; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Carte temp = paquet[i];
            paquet[i] = paquet[rand];
            paquet[rand] = temp;
        }
        cartesTirees = 0;
    }

    public int cartesRestantes() {

        return 52 - cartesTirees;
    }

    public Carte tirerCarte() {

        if (cartesTirees == 52) {
            melanger();
        }
        cartesTirees++;
        return paquet[cartesTirees - 1];
    }

}
