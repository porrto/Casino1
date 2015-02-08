/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roulette;

import Interface.Exit;
import MenuCasino.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author clement
 */
public class Roulette implements Exit {

    public String choix;
    public int choixnombre;


    
     
   public void initRoulette() {

       ChoixJoueur joueur = new ChoixJoueur();
       SetRoulette tirage = new SetRoulette();
        System.out.println("Vous disposez de" + Player.argent + "     ");
        
        this.choixJoueur();
                 
    }

    public void choixJoueur( ) {

         System.out.println("Le tirage était de couleur " + SetRoulette.color + "de parité" + SetRoulette.parité + "et le nombre" + SetRoulette.nombre);

        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre (N) Parité (P) Couleur (C) ou Tourner la roue (R) ?  " );
        choix = sc.next();

        if ("N".equals(choix) || "P".equals(choix) || "C".equals(choix) || "R".equals(choix)) {
            switch (choix) {
                case "N":             
                    this.choixNombre();
                    break;
                      case "P":
                  this.choixParité();
                    break;
                case "C":
                    this.choixCouleur( );
                    break;
                case "R":
                    if (ChoixJoueur.choixNoir == false & ChoixJoueur.choixRouge == false && ChoixJoueur.choixImpair == false && ChoixJoueur.choixPair == false && ChoixJoueur.number.isEmpty() == true) {
                        System.out.println("Vous n'avez pas misé");
                        this.choixJoueur();
                    } else {

                        this.verifNombre();   // On vérifie les parie du joueur avec la tirage de base
                        this.verifParité();
                        this.verifCouleur();

                        System.out.println("Le tirage était de couleur " + SetRoulette.color + "de parité" + SetRoulette.parité + "et le nombre" + SetRoulette.nombre);
                        System.out.println("Votre porte monnaie est maintenant de" + Player.argent + "euros");

                        if (Player.argent != 0) {            // On propose au joueur de re-joue s'il lui reste de l'argent
                            System.out.println("Voulez vous rejouez ? (Y) or (N) ");
                            String choixnouvellepartie = sc.next();

                            if (choixnouvellepartie.equals("Y")) {
                                System.out.println("Vous disposez maintenant de " + Player.argent + "euros");
                                this.initRoulette();
                            } else {
                                if (choixnouvellepartie.equals("N")) {
                                 this.Quitter();
                                } else {
                                    System.out.println("Veuillez entrer Y ou N ");
                                  this.choixJoueur();
                                }
                            }
                            break;
                        }
                    }
            }
        } else {
            System.out.println("Vous n'avez pas entré N ,P , C ou R");
            this.choixJoueur();
        }
    }

    public void choixNombre() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel nombre entre 0 et 36  ou retournez au (100)?  ");
        choixnombre = sc.nextInt();

        if (choixnombre == 100) {
       this.choixJoueur();
        } else {
            if (choixnombre >= 0 && choixnombre <= 36) {

                this.montantMise("Number");
            } else {
                System.out.println("Vous n'avez pas rentré un entier entre 0 et 36");
                this.choixNombre();
            }
        }
     this.choixJoueur();
    }

    public void choixParité() {
        Scanner sc = new Scanner(System.in);

        if (ChoixJoueur.choixPair != true || ChoixJoueur.choixImpair != true) {
            System.out.println("Pair (P) , Impair (I) ou Retour (R)?  ");
            String choixparité = sc.next();

            switch (choixparité) {

                case "P":
                    if (ChoixJoueur.choixPair == true) {
                        System.out.println("Vous avez déjà choisis pair");
                        this.choixParité();
                    } else {
                        ChoixJoueur.choixPair = true;
                        montantMise("Pair");
                    }
                    break;

                case "I":
                    if (ChoixJoueur.choixImpair == true) {
                        System.out.println("Vous avez déjà choisis impair");
                        this.choixParité();
                    } else {
                        ChoixJoueur.choixImpair = true;
                        montantMise("Impair");
                    }
                    break;

                case "R":
                    this.choixJoueur();
                    break;

                default:
                    System.out.println("Vous n'avez pas rentré P , I ou R");
                    this.choixParité();
            }
        } else {
            System.out.println("Vous avez déjà choisis pair et impair");
        }

        this.choixJoueur();

    }

    public void choixCouleur() {
        Scanner sc = new Scanner(System.in);

        if (ChoixJoueur.choixRouge != true || ChoixJoueur.choixNoir != true) {
            System.out.println("Rouge (R) , Noir (N) ou Retour (B)?  ");
            String choixcouleur = sc.next();

            switch (choixcouleur) {

                case "R":
                    if (ChoixJoueur.choixRouge == true) {
                        System.out.println("Vous avez déjà choisis rouge");
                        this.choixParité();
                    } else {
                        ChoixJoueur.choixRouge = true;
                        montantMise("Rouge");
                    }
                    break;

                case "N":
                    if (ChoixJoueur.choixNoir == true) {
                        System.out.println("Vous avez déjà choisis noir");
                        this.choixParité();
                    } else {
                        ChoixJoueur.choixNoir = true;
                        montantMise("Noir");
                    }
                    break;

                case "B":
                    this.choixJoueur();
                    break;

                default:
                    System.out.println("Vous n'avez pas rentré R , N ou B");
                    this.choixParité();
            }
        } else {
            System.out.println("Vous avez déjà choisis Rouge et Noir");
        }

        this.choixJoueur();

    }

    public void verifNombre() {

        for (ChoixJoueurNumber elem : ChoixJoueur.number) {
            if (elem.choix == SetRoulette.nombre) {
                this.gainArgent(elem.mise * 35);
            }
        }

    }

    public void verifParité() {

        if (ChoixJoueur.choixPair == true && SetRoulette.parité == "pair") {
            this.gainArgent(ChoixJoueur.misePair * 2);
        } else {
            if (ChoixJoueur.choixImpair == true &&SetRoulette.parité== "impair") {
                this.gainArgent(ChoixJoueur.miseImpair * 2);
            }
        }
    }

    public void verifCouleur() {

        if (ChoixJoueur.choixRouge == true && SetRoulette.color == "rouge") {
            this.gainArgent(ChoixJoueur.miseRouge * 2);
        } else {
            if (ChoixJoueur.choixNoir == true && SetRoulette.color == "noir") {
                this.gainArgent(ChoixJoueur.miseNoir * 2);
            }
        }
    }

    public void montantMise(String jeux) {
     int choixmise = 0;
     
        if (Player.argent != 0) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Combien voulez vous miser?");
            
            choixmise = sc.nextInt();
            /* try {
                     choixmise = sc.nextInt();
             } catch (InputMismatchException e) {
                 System.out.println("Veuillez rentrer un entier");
                 this.montantMise(jeux);
             } */

            if (choixmise == 0) {
                System.out.println("Vous ne pouvez pas miser 0");
                this.montantMise(jeux);
            } else {
                if (choixmise != 0) {
                    this.verifMise(jeux, choixmise);
                }
            }

        
        } else {
            System.out.println("Vous n'avez plus d'argent");
        
        }

    }

    public void verifMise(String jeux, int montant) {

        if (Player.argent - montant < 0) {
            System.out.println("Vous n'avez pas assez d'argent, il ne vous reste que " + Player.argent);
            this.montantMise(jeux);
        } else {
            this.miseArgent(montant);
            System.out.println("Il vous reste  " + Player.argent);

            switch (jeux) {

                case "Number":
                    ChoixJoueurNumber objet = new ChoixJoueurNumber(choixnombre, montant);
                    ChoixJoueur.number.add(objet);
                    break;

                case "Rouge":
                    ChoixJoueur.miseRouge = montant;
                    break;

                case "Noir":
                    ChoixJoueur.miseNoir = montant;
                    break;

                case "Pair":
                    ChoixJoueur.misePair = montant;
                    break;

                case "Impair":
                    ChoixJoueur.miseImpair = montant;
                    break;

            }
        }
    }
    
      public void gainArgent(int gain) {

        Player.argent = Player.argent + gain;
    }

    public void miseArgent(int mise) {

        Player.argent = Player.argent - mise;

    }
    
    @Override
   public void Quitter() {
          System.out.println("Vous quittez la Roulette");
          //MenuCasino.ChoixMenu.argent = PorteMonnaie.argent;          // Lorsque qu'on arrête la roulette, l'argent est récupéré
   }

}
