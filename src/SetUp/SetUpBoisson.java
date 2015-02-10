package SetUp;

import java.util.ArrayList;
import java.util.List;
import Bar.Boisson;

/**
 *
 *
 *
 * Permet de construire les différentes listes de boissons qui seront présentes
 * dans la carte
 *
 * @author clement
 */
public class SetUpBoisson {

    /**
     * On crée les Alcools voulus dans notre carte
     *
     * @return On retourne une liste d'alcool de type Boisson
     * @see Bar.Boisson
     */
    public List<Boisson> setUpAlcool() {

        Boisson vodka = new Boisson("Vodka", 6, 1);
        Boisson martini = new Boisson("Martini", 6, 2);
        Boisson whisky = new Boisson("Whisky", 6, 3);

        List<Boisson> listAlcool = new ArrayList();

        listAlcool.add(vodka);
        listAlcool.add(martini);
        listAlcool.add(whisky);

        return listAlcool;

    }

    /**
     * On crée les Sodas voulus dans notre carte
     *
     * @return On retourne une liste de sodas de type Boisson
     * @see Bar.Boisson
     */
    public List<Boisson> setUpSoda() {

        Boisson cocacola = new Boisson("Coca-Cola", 5, 1);
        Boisson icetea = new Boisson("Ice Tea", 5, 2);
        Boisson redbull = new Boisson("Red Bull", 6, 3);

        List<Boisson> listSoda = new ArrayList();

        listSoda.add(cocacola);
        listSoda.add(icetea);
        listSoda.add(redbull);

        return listSoda;
    }

    /**
     * On crée les Cocktails voulu dans notre carte
     *
     * @return On retourne une liste de cocktails de type Boisson
     * @see Bar.Boisson
     */
    public List<Boisson> setUpCocktails() {

        Boisson mojito = new Boisson("Mojito", 7, 1);
        Boisson pinacolada = new Boisson("Pina Colada", 7, 2);
        Boisson soholong = new Boisson("Soho Long", 7, 3);

        List<Boisson> listCocktails = new ArrayList();

        listCocktails.add(mojito);
        listCocktails.add(pinacolada);
        listCocktails.add(soholong);

        return listCocktails;

    }

}
