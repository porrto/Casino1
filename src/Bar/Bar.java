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
 *
 * @author isen
 */
public class Bar implements Exit {

    public String choixBar;
    public int choixBoisson;
    public int choixverre;
    public boolean pass;

    public void initBar() {
        
         //PorteMonnaie.argent = argent;    // On met l'argent du joueur dans le porte monnaie du bar
         this.choixJoueur();

         //MenuCasino.Menu.argent = PorteMonnaie.argent;  // On récolte l'argent perdu ou gagner
    }
    
    public void choixJoueur() {

        SetUpBoisson boisson = new SetUpBoisson();

        Scanner sc = new Scanner(System.in);

        System.out.println("Vous avez" + Player.argent);
        if (Alcoolémie.soul == true) {
            this.fired();
        } else {

            System.out.println("Voulez vous un Cocktail (C), un Soft (S), un Alcool fort (A), sortir du bar (R) ? ");
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

    public void fired() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Vous êtes viré du casino, vous êtes soul");
        System.out.println("Voulez vous rententer votre chance ? (Y) or (N) ");
        choixBar = sc.next();

        switch (choixBar) {
            case "Y":
                System.out.println("Vous allez essayer de passer malgrès le videur ...");
                Random rand = new Random();
                pass = rand.nextBoolean();

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
    
    @Override
    public void Quitter() {
        System.out.println("Vous sortez du bar");
        //MenuCasino.ChoixMenu.argent = PorteMonnaie.argent;
    }

}