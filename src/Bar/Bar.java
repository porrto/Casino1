/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

import Interface.Exit;
import MenuCasino.Player;
import SetUp.SetUpBoisson;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 * @author clement
 * 
 * Cette classe va permettre au joueur de choisir une boisson : 
 * <ul>
 * <li>On va verifier si le joueur dispose assez d'argent</li>
 * <li>Si le joueur est soul il sera viré</li>
 * <li>Après être viré il aura une chance sur deux de pouvoir ré-intégrer le casino</li>
 * </ul>
 * 
 *
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
     *  Menu principale permettant au joueur de choisir une boisson
     *          Si le joueur est soul, il est viré
     */
    public void choixJoueur() {

        String choixBar;
        SetUpBoisson boisson = new SetUpBoisson();

        Scanner sc = new Scanner(System.in);

        System.out.println("Vous avez" + Player.argent);
        if (Alcoolémie.soul == true) {
            this.fired();
        } else {

            System.out.println("Voulez vous un Cocktail (C), un Soda (S), un Alcool fort (A), sortir du bar (R) ? ");
            choixBar = sc.next();

            if (choixBar.equals("C") || choixBar.equals("S") || choixBar.equals("A") || choixBar.equals("R") ) {
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
                System.out.println("Vous n'avez pas rentrée C, S ou A ");
                this.choixJoueur();

            }
        }
    }

    /**
     *  Permet de choisir un Cocktail parmis la liste proposé
     * 
     * @param cocktails
     *              Contient la liste des cocktails du SetUpBoisson
     */
    public void choixCocktails(SetUpBoisson cocktails) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel Cocktail voulez-vous ? ");

        for (Boisson elem : cocktails.setUpCocktails()) {
            System.out.println(elem.name + "   " + elem.price + "   (" + elem.taux + "°)"  + "   (" + elem.number + ")");
        }

        try {
            choixBoisson = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Vous n'avez pas rentré les alcool proposés");
            this.choixCocktails(cocktails);

        }

        if (choixBoisson > cocktails.setUpCocktails().size() || choixBoisson == 0) {
            System.out.println("Veuillez entrer un chiffre correspond à un Alcool");
            this.choixCocktails(cocktails);
        } else {

            for (Boisson  elem : cocktails.setUpCocktails()) {

                if (choixBoisson == elem.number) {
                    verifArgent(elem.price, elem.taux);
                }
            }
        }

    }
 /**
     *  Permet de choisir un Soda parmis la liste proposé
     * 
     * @param soda
     *              Contient la liste des cocktails du SetUpBoisson
     */
    public void choixSoda(SetUpBoisson soda) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel Soda voulez-vous ? ");
       for (Boisson elem : soda.setUpSoda()) {
            System.out.println(elem.name + "   " + elem.price + "   (" + elem.number + ")");
        }

        try {
            choixBoisson = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Vous n'avez pas rentré les alcool proposés");
            this.choixSoda(soda);
        }

        if (choixBoisson > soda.setUpAlcool().size() || choixBoisson == 0) {
            System.out.println("Veuillez entrer un chiffre correspond à un Alcool");
            this.choixSoda(soda);
        } else {

        for (Boisson elem : soda.setUpSoda()) {

                if (choixBoisson == elem.number) {
                    verifArgent(elem.price, 0);
                }
            }
        }
    }
 /**
     *  Permet de choisir un Alcools parmis la liste proposé
     * 
     * @param alcool
     *              Contient la liste des cocktails du SetUpBoisson
     */
    public void choixAlcools(SetUpBoisson alcool) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel Alcool voulez-vous ? ");
    for (Boisson elem : alcool.setUpAlcool()) {
            System.out.println(elem.name + "   " + elem.price + "   (" + elem.number + ")");
        }
        try {
            choixBoisson = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Vous n'avez pas rentré les alcool proposés");
            this.choixAlcools(alcool);
        }

        if (choixBoisson > alcool.setUpAlcool().size() || choixBoisson == 0) {
            System.out.println("Veuillez entrer un chiffre correspond à un Alcool");
            this.choixAlcools(alcool);
        } else {

        for (Boisson elem : alcool.setUpAlcool()) {

                if (choixBoisson == elem.number) {
                    verifArgent(elem.price, elem.taux);
                }
            }
        }
    }
 /**
     *  Verifie s'il y a assez d'argent pour acheter la boisson selectionnée précédemment
     * 
     * @param prix 
     *          Le prix de la boisson selectionnée
     * 
     * @param taux
     *          Le taux d'alcoolémie des boisson type Alcool et Cokctail
     */
    public void verifArgent(int prix, double taux) {

        if (Player.argent - prix < 0) {
            System.out.println("Vous n'avez pas assez d'argent, il ne vous reste que " + Player.argent);
            this.choixJoueur();
        } else {

            Alcoolémie.verifTaux(taux);
            if (Alcoolémie.drink == true) {
                Player.argent = Player.argent - prix;
                System.out.println("Il vous reste  " + Player.argent);
                this.choixJoueur();

            } else {
                this.choixJoueur();
            }
        }

    }
 /**
     *  Losque le joueur est soul, on lui laisse une chance sur 2 de re rentrer dans le casino
     */
    public void fired() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Vous êtes viré du casino, vous êtes soul");
        System.out.println("Voulez vous rententer votre chance ? (Y) or (N) ");
        String retenterchance = sc.next();

        switch (retenterchance) {
            case "Y":
                System.out.println("Vous allez essayer de passer malgrès le videur ...");
                Random rand = new Random();
                boolean pass = rand.nextBoolean();

                if (pass == true) {
                    System.out.println(" Vous êtes re-rentré dans le casino");
                    MenuCasino.ChoixMenu.fired = true;

                } else {
                    System.out.println("Le videur vous a repéré, désolé");
                    MenuCasino.ChoixMenu.fired = true;
                    MenuCasino.ChoixMenu.quitter = true;
                }
                break;

            case "N":
                System.out.println("au revoir");
                MenuCasino.ChoixMenu.quitter = true;
                break;

            default:
                System.out.println("Vous n'avez pas rentré (Y) or (N)");
        }

    }
     /**
     * Annonce au joueur qu'il quitte le Bar
     */
    @Override
    public void Quitter() {
        System.out.println("Vous sortez du bar");
        //MenuCasino.ChoixMenu.argent = PorteMonnaie.argent;
    }

}
