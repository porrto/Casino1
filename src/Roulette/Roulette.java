
package Roulette;

import Interface.Exit;
import Interface.Mise;
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
public class Roulette implements Exit,Mise {

 //   public String choix;
    
    /**
     *  Correspond au nombre que le joueur a choisi lorsqu'il décide de miser
     */
    public int choixnombre;
    /**
     *  Correspond à la mise réalisée par le joueur lors d'un choix
     */
    public int choixmise;
      
     /**
      * On instancie un joueur et un nouveau tirage
      * Puis on démarre la roulette pour que le joueur choisisse ce qu'il veut faire
      * 
      */
   public void initRoulette() {

       ChoixJoueur joueur = new ChoixJoueur();
       SetRoulette tirage = new SetRoulette();
        System.out.println("Vous disposez de " + Player.argent + "  $   ");
        
        this.choixJoueur();
                 
    }

   /**
    * Menu général indiquant au joueur les différents types de mises qu'il peut réaliser
    */
    public void choixJoueur( ) {
        
        String choix;
         

        Scanner sc = new Scanner(System.in);
        System.out.println("Miser sur le nombre (N), la parité (P), la couleur (C) ou tourner la roue (R) ?  " );
        choix = sc.next();

        if ("N".equals(choix) || "P".equals(choix) || "C".equals(choix) || "R".equals(choix)) {
            switch (choix) {
                case "N":             
                    this.choixNombre();
                    break;
                      case "P":
                  this.choixParite();
                    break;
                case "C":
                    this.choixCouleur( );
                    break;
                case "R":
                    if (ChoixJoueur.choixNoir == false & ChoixJoueur.choixRouge == false && ChoixJoueur.choixImpair == false && ChoixJoueur.choixPair == false && ChoixJoueur.number.isEmpty() == true) {
                        System.out.println("Vous n'avez pas misé");
                        this.choixJoueur();
                    } else {

                        this.verifNombre();   // On vérifie les paris du joueur avec le tirage de base
                        this.verifParite();
                        this.verifCouleur();

                        System.out.println("Le tirage était de couleur " + SetRoulette.color + " de parité " + SetRoulette.parite + " et le nombre " + SetRoulette.nombre);
                        System.out.println("Votre porte monnaie est maintenant de " + Player.argent + " $");

                        if (Player.argent != 0) {            // On propose au joueur de rejouer s'il lui reste de l'argent
                            System.out.println("Voulez vous rejouer ? Oui (O) ou Non (N) ");
                            String choixnouvellepartie = sc.next();

                            if (choixnouvellepartie.equals("O")) {
                                System.out.println("Vous disposez maintenant de " + Player.argent + " $");
                                this.initRoulette();
                            } else {
                                if (choixnouvellepartie.equals("N")) {
                                 this.Quitter();
                                } else {
                                    System.out.println("Veuillez entrer O ou N ");
                                  this.choixJoueur();
                                }
                            }
                            break;
                        }
                    }
            }
        } else {
            System.out.println("Vous n'avez pas entré N,P,C ou R");
            this.choixJoueur();
        }
    }

    /**
     * Demande au joueur un nombre
     */
    public void choixNombre() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Choisir un nombre entre 0 et 36  ou retourner au menu (100)  ");
        choixnombre = sc.nextInt();

        if (choixnombre == 100) {
       this.choixJoueur();
        } else {
            if (choixnombre >= 0 && choixnombre <= 36) {

                this.montantMise("Number");
                 this.choixJoueur();
            } else {
                System.out.println("Vous n'avez pas rentré un entier entre 0 et 36");
                this.choixNombre();
            }
        }
    
    }

    /**
     * Demande au joueur de choisir une parité
     */
    public void choixParite() {
        Scanner sc = new Scanner(System.in);

        if (ChoixJoueur.choixPair != true || ChoixJoueur.choixImpair != true) {
            System.out.println("Pair (P) , Impair (I) ou Retour (R) ?  ");
            String choixparite = sc.next();

            switch (choixparite) {

                case "P":
                    if (ChoixJoueur.choixPair == true) {
                        System.out.println("Vous avez déjà choisi pair");
                        this.choixParite();
                    } else {
                        ChoixJoueur.choixPair = true;
                        montantMise("Pair");
                                this.choixJoueur();

                    }
                    break;

                case "I":
                    if (ChoixJoueur.choixImpair == true) {
                        System.out.println("Vous avez déjà choisi impair");
                        this.choixParite();
                    } else {
                        ChoixJoueur.choixImpair = true;
                        montantMise("Impair");
                                this.choixJoueur();

                    }
                    break;

                case "R":
                    this.choixJoueur();
                    break;

                default:
                    System.out.println("Vous n'avez pas rentré P, I ou R");
                    this.choixParite();
            }
        } else {
            System.out.println("Vous avez déjà choisi pair et impair");
        }


    }

    /**
     * Demande au joueur de choisir une couleur
     */
    public void choixCouleur() {
        Scanner sc = new Scanner(System.in);

        if (ChoixJoueur.choixRouge != true || ChoixJoueur.choixNoir != true) {
            System.out.println("Rouge (R) , Noir (N) ou Retour (B) ");
            String choixcouleur = sc.next();

            switch (choixcouleur) {

                case "R":
                    if (ChoixJoueur.choixRouge == true) {
                        System.out.println("Vous avez déjà choisi rouge");
                        this.choixCouleur();
                    } else {
                        ChoixJoueur.choixRouge = true;
                        montantMise("Rouge");
                                this.choixJoueur();

                    }
                    break;

                case "N":
                    if (ChoixJoueur.choixNoir == true) {
                        System.out.println("Vous avez déjà choisi noir");
                        this.choixCouleur();
                    } else {
                        ChoixJoueur.choixNoir = true;
                        montantMise("Noir");
                                this.choixJoueur();

                    }
                    break;

                case "B":
                    this.choixJoueur();
                    break;

                default:
                    System.out.println("Vous n'avez pas rentré R, N ou B");
                    this.choixCouleur();
            }
        } else {
            System.out.println("Vous avez déjà choisi Rouge et Noir");
        }

       

    }

    /**
     * Permet de vérifier si le nombre choisi a déjà été choisi par le joueur
     */
    public void verifNombre() {

        ChoixJoueur.number.stream().filter((elem) -> (elem.choix == SetRoulette.nombre)).forEach((elem) -> {
            this.gainArgent(elem.mise * 35);
        });

    }

    /**
     * Permet de vérifier si la parité choisie a déjà été choisie par le joueur
     */
    public void verifParite() {

        if (ChoixJoueur.choixPair == true && "pair".equals(SetRoulette.parite)) {
            this.gainArgent(ChoixJoueur.misePair * 2);
        } else {
            if (ChoixJoueur.choixImpair == true &&"impair".equals(SetRoulette.parite)) {
                this.gainArgent(ChoixJoueur.miseImpair * 2);
            }
        }
    }

    /**
     * Permet de vérifier si la couleur choisie a déjà été choisie par le joueur
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
     * Demande au joueur le montant de la mise souhaitée et vérifie si celui-ci possède assez d'argent 
     * @param jeux 
     *                  Représente sur quoi le joueur mise (Nombre, Parité, Couleur)
     * @see Player
     */                  
    public void montantMise(String jeux) {
      
        if (Player.argent != 0) {

            VerifMise();

            if (choixmise == 0) {
                System.out.println("Vous ne pouvez pas miser 0");
                this.montantMise(jeux);
                
            } else {
                
            if (Player.argent - choixmise < 0) {
            System.out.println("Vous n'avez pas assez d'argent, il ne vous reste que " + Player.argent + " $");
            this.montantMise(jeux);
            
        } else {
            this.SaveMise(jeux, choixmise);
          
            System.out.println("Il vous reste  " + Player.argent + " $");
               }
            }
        } 
        
            else {
            System.out.println("Vous n'avez plus d'argent");
                }
    }
    
    /**
     * Permet de vérifier si une entrée au clavier est bien un entier
     */
    @Override
    public void VerifMise() {
        
         
           Scanner sc = new Scanner(System.in);
            System.out.println("Combien voulez vous miser ?");
            
          
              try {
                     choixmise = sc.nextInt();
             } catch (InputMismatchException e) {
                 System.out.println("Veuillez rentrer un entier");
                VerifMise();
             }
              
               sc.nextLine();
               
    }

    /**
     * Associe la mise du joueur sur une catégorie (Nombre, Parité, Couleur) dans les choix du joueur
     * @param jeux
     *                  Représente sur quoi le joueur mise (Nombre, Parité, Couleur)
     * @param montant 
     *                  Représente la mise choisie par le joueur
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
              this.miseArgent(choixmise);
        }
    
    /**
     * Donne l'argent gagné au joueur
     * @param gain  
     *                      Argent gagné sur un type de mise
     */
    public void gainArgent(int gain) {

        Player.argent = Player.argent + gain;
    }

    /**
     * Enlève l'argent misé au joueur
     * @param mise 
     *                  Somme misée par le joueur
     */
    public void miseArgent(int mise) {

        Player.argent = Player.argent - mise;

    }
    
    /**
     * Methode implémentée de l'interface permettant d'afficher un message d'aurevoir personnalisé avec le nom du jeu
     */
    @Override
   public void Quitter() {
          System.out.println("Vous quittez la roulette");
          
   }

}
