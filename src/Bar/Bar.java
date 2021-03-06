package Bar;

import Interface.Exit;
import MenuCasino.Player;
import SetUp.SetUpBoisson;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 *
 * Cette classe va permettre au joueur de choisir une boisson :
 * <ul>
 * <li>On va vérifier si le joueur dispose d'assez d'argent</li>
 * <li>Si le joueur est saoul il sera viré</li>
 * <li>Après être viré il aura une chance sur deux de pouvoir ré-intégrer le
 * casino</li>
 * </ul>
 *
 * @author clement
 */
public class Bar implements Exit {

    /**
     * Désigne le numéro de la boisson entré au clavier
     */
    public int choixBoisson;

    /**
     * Permet de démarrer le bar
     */
    public void initBar() {

        this.choixJoueur();
    }

    /**
     * Menu principal permettant au joueur de choisir une boisson Si le joueur
     * est saoul, il est viré
     */
    public void choixJoueur() {

        String choixBar;
        SetUpBoisson boisson = new SetUpBoisson();

        Scanner sc = new Scanner(System.in);

        System.out.println("Vous avez " + Player.argent + " $ ");
        if (Alcoolemie.saoul == true) {
            this.fired();
        } else {

            System.out.println("Voulez vous un Cocktail (C), un Soda (S), un Alcool fort (A), sortir du bar (R) ? ");
            choixBar = sc.next();

            if (choixBar.equals("C") || choixBar.equals("S") || choixBar.equals("A") || choixBar.equals("R")) {
                switch (choixBar) {

                    case "C":
                        choixCocktails(boisson);
                        break;
                    case "S":
                        choixSoda(boisson);
                        break;
                    case "A":
                        choixAlcools(boisson);
                        break;

                    case "R":
                        this.Quitter();
                }
            } else {
                System.out.println("Vous n'avez pas rentré C, S, R ou A ");
                this.choixJoueur();

            }
        }
    }

    /**
     * Permet de choisir un Cocktail parmi la liste proposée
     *
     * @param cocktails Contient la liste des cocktails du SetUpBoisson
     */
    public void choixCocktails(SetUpBoisson cocktails) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel Cocktail voulez-vous ? ");

        cocktails.setUpCocktails().stream().forEach((elem) -> {
            System.out.println(elem.name + "   " + elem.price + "$   (" + elem.taux + "°)" + "   (" + elem.number + ")");
        });

        try {
            choixBoisson = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Vous n'avez pas rentré les alcools proposés");
            this.choixCocktails(cocktails);

        }

        if (choixBoisson > cocktails.setUpCocktails().size() || choixBoisson == 0) {
            System.out.println("Veuillez entrer un chiffre correspondant à un Alcool");
            this.choixCocktails(cocktails);
        } else {

            cocktails.setUpCocktails().stream().filter((elem) -> (choixBoisson == elem.number)).forEach((elem) -> {
                verifArgent(elem.price, elem.taux);
            });
        }

    }

    /**
     * Permet de choisir un Soda parmi la liste proposée
     *
     * @param soda Contient la liste des cocktails du SetUpBoisson
     */
    public void choixSoda(SetUpBoisson soda) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel Soda voulez-vous ? ");
        soda.setUpSoda().stream().forEach((elem) -> {
            System.out.println(elem.name + "   " + elem.price + "$   (" + elem.number + ")");
        });

        try {
            choixBoisson = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Vous n'avez pas rentré les alcools proposés");
            this.choixSoda(soda);
        }

        if (choixBoisson > soda.setUpAlcool().size() || choixBoisson == 0) {
            System.out.println("Veuillez entrer un chiffre correspondant à un Alcool");
            this.choixSoda(soda);
        } else {

            soda.setUpSoda().stream().filter((elem) -> (choixBoisson == elem.number)).forEach((elem) -> {
                verifArgent(elem.price, 0);
            });
        }
    }

    /**
     * Permet de choisir un alcool parmi la liste proposée
     *
     * @param alcool Contient la liste des cocktails du SetUpBoisson
     */
    public void choixAlcools(SetUpBoisson alcool) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel alcool voulez-vous ? ");
        alcool.setUpAlcool().stream().forEach((elem) -> {
            System.out.println(elem.name + "   " + elem.price + "$   (" + elem.number + ")");
        });
        try {
            choixBoisson = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Vous n'avez pas rentré les alcools proposés");
            this.choixAlcools(alcool);
        }

        if (choixBoisson > alcool.setUpAlcool().size() || choixBoisson == 0) {
            System.out.println("Veuillez entrer un chiffre correspondant à un alcool");
            this.choixAlcools(alcool);
        } else {

            alcool.setUpAlcool().stream().filter((elem) -> (choixBoisson == elem.number)).forEach((elem) -> {
                verifArgent(elem.price, elem.taux);
            });
        }
    }

    /**
     * Verifie s'il y a assez d'argent pour acheter la boisson selectionnée
     * précédemment
     *
     * @param prix Le prix de la boisson selectionnée
     *
     * @param taux Le taux d'alcoolémie des boissons type Alcool et Cocktail
     */
    public void verifArgent(int prix, double taux) {

        if (Player.argent - prix < 0) {
            System.out.println("Vous n'avez pas assez d'argent, il ne vous reste que " + Player.argent + " $");
            this.choixJoueur();
        } else {

            Alcoolemie.verifTaux(taux);
            if (Alcoolemie.drink == true) {
                Player.argent = Player.argent - prix;
                System.out.println("Il vous reste  " + Player.argent + " $");
                this.choixJoueur();

            } else {
                this.choixJoueur();
            }
        }

    }

    /**
     * Losque le joueur est saoul, on lui laisse une chance sur deux de re
     * rentrer dans le casino
     */
    public void fired() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Vous êtes viré du casino, vous êtes saoul");
        System.out.println("Voulez vous rententer votre chance ? (O) or (N) ");
        String retenterchance = sc.next();

        switch (retenterchance) {
            case "O":
                System.out.println("Vous allez essayer de passer malgrè le videur ...");
                Random rand = new Random();
                boolean pass = rand.nextBoolean();

                if (pass == true) {
                    System.out.println(" Vous êtes re-rentré dans le casino");
                    MenuCasino.ChoixMenu.fired = false;
                    Alcoolemie.saoul = false;

                } else {
                    System.out.println("Le videur vous a repéré, désolé");
                    MenuCasino.ChoixMenu.fired = true;
                    MenuCasino.ChoixMenu.quitter = true;
                }
                break;

            case "N":
                System.out.println("Au revoir");
                MenuCasino.ChoixMenu.quitter = true;
                break;

            default:
                System.out.println("Vous n'avez pas rentré (O) or (N)");
        }

    }

    /**
     * Annonce au joueur qu'il quitte le Bar
     */
    @Override
    public void Quitter() {
        System.out.println("Vous sortez du bar");

    }

}
