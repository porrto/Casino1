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
 * 
 * 
 * Permet de proposer au joueur les différentes mises :
 * <ul>
 * <li>Numéro</li>
 * <li>Couleur</li>
 * <li>Parité</li>
 * </ul>
 * 
 * Chaque choix sera vérifié avec l'argent du joueur et enregistré dans la classe ChoixJoueur
 * @see ChoixJoueur
 * @author clement
 * 
 */
public class Roulette implements Exit {

 //   public String choix;
    
    /**
     *  Correspond au nombre que le joueur a choisis lorsqu'il décide de miser
     */
    public int choixnombre;
    /**
     *  Correspond à la mise réalisé par le joueur lors d'un choix
     */
    public int choixmise;
      
     /**
      * On instancie un joueur et un nouveau tirage
      * Puis on démarre la roulette pour que le choueur choisisse ce qu'il veut faire
      * 
      */
   public void initRoulette() {

       ChoixJoueur joueur = new ChoixJoueur();
       SetRoulette tirage = new SetRoulette();
        System.out.println("Vous disposez de" + Player.argent + "     ");
        
        this.choixJoueur();
                 
    }

   /**
    * Menu général indiquant au joueur les différents types de mises qu'il peut réaliser
    */
    public void choixJoueur( ) {
        
        String choix;
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

    /**
     * Demande au joueur un nombre
     */
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

    /**
     * Demande au joueur de choisir une parité
     */
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

    /**
     * Demande au joueur de choisir une couleur
     */
    public void choixCouleur() {
        Scanner sc = new Scanner(System.in);

        if (ChoixJoueur.choixRouge != true || ChoixJoueur.choixNoir != true) {
            System.out.println("Rouge (R) , Noir (N) ou Retour (B)?  ");
            String choixcouleur = sc.next();

            switch (choixcouleur) {

                case "R":
                    if (ChoixJoueur.choixRouge == true) {
                        System.out.println("Vous avez déjà choisis rouge");
                        this.choixCouleur();
                    } else {
                        ChoixJoueur.choixRouge = true;
                        montantMise("Rouge");
                    }
                    break;

                case "N":
                    if (ChoixJoueur.choixNoir == true) {
                        System.out.println("Vous avez déjà choisis noir");
                        this.choixCouleur();
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
                    this.choixCouleur();
            }
        } else {
            System.out.println("Vous avez déjà choisis Rouge et Noir");
        }

        this.choixJoueur();

    }

    /**
     * Permet de véirier si le nombre choisis a déjà été choisis par le joueur
     */
    public void verifNombre() {

        for (ChoixJoueurNumber elem : ChoixJoueur.number) {
            if (elem.choix == SetRoulette.nombre) {
                this.gainArgent(elem.mise * 35);
            }
        }

    }

    /**
     * Permet de véirifer si la parité choisis à déjà été choisis  par le joueur
     */
    public void verifParité() {

        if (ChoixJoueur.choixPair == true && SetRoulette.parité == "pair") {
            this.gainArgent(ChoixJoueur.misePair * 2);
        } else {
            if (ChoixJoueur.choixImpair == true &&SetRoulette.parité== "impair") {
                this.gainArgent(ChoixJoueur.miseImpair * 2);
            }
        }
    }

    /**
     * Permer de vérifier si la couleur choisis à déjà été choisis par le joueur
     */
    public void verifCouleur() {

        if (ChoixJoueur.choixRouge == true && SetRoulette.color == "rouge") {
            this.gainArgent(ChoixJoueur.miseRouge * 2);
        } else {
            if (ChoixJoueur.choixNoir == true && SetRoulette.color == "noir") {
                this.gainArgent(ChoixJoueur.miseNoir * 2);
            }
        }
    }

    /**
     * Demande au joueur la montant de la mise souhaité et vérifie si celui si possède assez d'argent 
     * @param jeux 
     *                  Représente sur quoi le joueur mise ( Nombre, Parité, Couleur)
     * @see Player
     */                  
    public void montantMise(String jeux) {
      
        if (Player.argent != 0) {

            verifInteger();

            if (choixmise == 0) {
                System.out.println("Vous ne pouvez pas miser 0");
                this.montantMise(jeux);
                
            } else {
                
            if (Player.argent - choixmise < 0) {
            System.out.println("Vous n'avez pas assez d'argent, il ne vous reste que " + Player.argent);
            this.montantMise(jeux);
            
        } else {
            this.miseArgent(choixmise);
            System.out.println("Il vous reste  " + Player.argent);
               }
            }
        } 
        
            else {
            System.out.println("Vous n'avez plus d'argent");
                }
    }
    
    /**
     * Permet de vérifié si une entrée au clavier et bien un entier
     */
    public void verifInteger() {
        
         
           Scanner sc = new Scanner(System.in);
            System.out.println("Combien voulez vous miser?");
            
          //  choixmise = sc.nextInt();
              try {
                     choixmise = sc.nextInt();
             } catch (InputMismatchException e) {
                 System.out.println("Veuillez rentrer un entier");
                verifInteger();
             }
              
               sc.nextLine();
               
    }

    /**
     * Associe la mise du joueur sur une catégorie ( Nombre, Parité, Couleur) dans les choix du joueur
     * @param jeux
     *                  Représente sur quoi le joueur mise ( Nombre, Parité, Couleur)
     * @param montant 
     *                  Représente la mise choisis par le joueur
     * @see ChoixJoueur
     */
    public void SaveMise(String jeux, int montant) {

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
    
    /**
     * Donne l'argent gagné au joueur
     * @param gain  
     *                      Argent gagner sur un type de mise
     */
    public void gainArgent(int gain) {

        Player.argent = Player.argent + gain;
    }

    /**
     * Enlève l'argent misé au joueur
     * @param mise 
     *                  Somme misé par le joueur
     */
    public void miseArgent(int mise) {

        Player.argent = Player.argent - mise;

    }
    
    /**
     * Method implémenté de l'interface permettant d'afficher un message d'aurevoir personnalisé avec le nom du jeux 
     */
    @Override
   public void Quitter() {
          System.out.println("Vous quittez la Roulette");
          //MenuCasino.ChoixMenu.argent = PorteMonnaie.argent;          // Lorsque qu'on arrête la roulette, l'argent est récupéré
   }

}
