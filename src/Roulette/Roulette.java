/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roulette;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author isen
 */
public class Roulette {
    
protected static int nombre;
public String couleur;
public  boolean tiragepair;
public  int choixnombre;
public  int choixnombre2;
public  String choix;
public String choixparité;


public String choixcouleur="";
public  boolean choixrouge=false;
public  boolean choixnoir=false;
public  boolean tabmiroir[] = new boolean[36];

public int gainnombre;
public int misenombre[] = new int[36];

public int  choixmise;
  
public void initRoulette() {
    
    ChoixJoueur joueur = new ChoixJoueur();
    SetRoulette tirage = new SetRoulette();
 
    
    this.choixJoueur(tirage, joueur);
}

public void choixJoueur(SetRoulette tirage, ChoixJoueur joueur) {
        
  //  this.getCouleur();
   // this.getParité();
    
    
    System.out.println("Le tirage était de couleur "+ tirage.SetUpRoulette().color +"de parité" + tirage.SetUpRoulette().parité +"et le nombre" + tirage.SetUpRoulette().number);
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Nombre (N) Parité (P) Couleur (C) ou Tourner la roue (R) ?  ");
     choix=sc.next();
    
    if("N".equals(choix) || "P".equals(choix) || "C".equals(choix) ||"R".equals(choix)) {
         switch(choix) {
        case "N": this.choixNombre(tirage, joueur);
            break;
        case "P": this.choixParité(tirage, joueur);
            break;
        case "C": this.choixCouleur(tirage, joueur);
            break;
        case "R":
                    if (joueur.choixNoir == false & joueur.choixRouge == false && joueur.choixImpair == false && joueur.choixPair == false && joueur.number.isEmpty() == true) {
                        System.out.println("Vous n'avez pas misé") ;
                        this.choixJoueur(tirage, joueur);
                                }
                    else {
                    
                        
                   this.verifNombre();   // On vérifie les parie du joueur avec la tirage de base
                   this.verifParité(tirage,joueur);
                   this.verifCouleur(tirage, joueur);
                   
                   
                   
                   System.out.println("Le tirage était de couleur "+ tirage.SetUpRoulette().color +"de parité" + tirage.SetUpRoulette().parité +"et le nombre" + tirage.SetUpRoulette().number);
                   System.out.println("Votre porte monnaie est maintenant de" + PorteMonnaie.argent+"euros");
                       
                   
                         if(PorteMonnaie.argent!=0) {            // On propose au joueur de re-joue s'il lui reste de l'argent
                         System.out.println("Voulez vous rejouez ? (Y) or (N) ");
                         String  choixnouvellepartie =sc.next();
                          
                            if(choixnouvellepartie.equals("Y")) {
                                     System.out.println("Vous disposez maintenant de " + PorteMonnaie.argent+"euros");
                                     Roulette rou = new Roulette();
                                     Random rand = new Random();
                                     nombre= rand.nextInt(37);
                                     this.choixJoueur(tirage, joueur);
                                      }
                            
                          else {
                              if(choixnouvellepartie.equals("N")) {
                              System.out.println("Vous quittez la table");
                                         }
                                     else {
                                          System.out.println("Veuillez entrer Y ou N ");
                                         this.choixJoueur(tirage, joueur);
                                             }
                                }
                break;
               }
          }
       }
    }
    
    else {
            System.out.println("Vous n'avez pas entré N ,P , C ou R");
       this.choixJoueur(tirage, joueur);
       }
    }

public void choixNombre(SetRoulette tirage, ChoixJoueur joueur) {
        
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Quel nombre entre 0 et 36  ou retournez au (100)?  ");
    choixnombre =sc.nextInt();
  //  if(this.isInteger(choixnombre)==true) {
      
    if(choixnombre == 100) {
       this.choixJoueur(tirage, joueur);
           }
    
    else {
         if (choixnombre>=0 && choixnombre<=36) {
          
             this.montantMise("Number", joueur);
//        this.addToTab();
                }
    else {
        System.out.println("Vous n'avez pas rentré un entier entre 0 et 36");
        this.choixNombre(tirage, joueur);
         }
  
  
 //   else {
 //       System.out.println("Attention, veuillez rentrer un entier valide");
 //       this.choixJoueur(tirage, joueur);
    }
      this.choixJoueur(tirage, joueur);
}

/*public void addToTab() {
    
  
choixnombre2 =Integer. parseInt(choixnombre);

if(tabmiroir[choixnombre2]==false) {
        tabmiroir[choixnombre2]=true;
    montantMise();
 
    }
else {
    System.out.println("Vous avez déjà choisis" + choixnombre);
    this.choixNombre();
}
          
} */

public void choixParité(SetRoulette tirage, ChoixJoueur joueur) {
     Scanner sc = new Scanner(System.in); 
     
    if (joueur.choixPair !=true || joueur.choixImpair !=true) { 
    System.out.println("Pair (P) , Impair (I) ou Retour (R)?  ");
    choixparité =sc.next();
    
    switch (choixparité) {
        
        case "P" : 
                   if(joueur.choixPair == true) {
                   System.out.println("Vous avez déjà choisis pair");
                   this.choixParité(tirage, joueur);
                        }
                     else {
                            joueur.choixPair = true;
                            montantMise("Pair", joueur);
                             }
         break;
            
        case "I" :  
                   if(joueur.choixImpair == true) {
                   System.out.println("Vous avez déjà choisis impair");
                   this.choixParité(tirage, joueur);
                       }
                     else {
                            joueur.choixImpair = true;
                            montantMise("Impair", joueur);
                             }
        break;
            
        case "R" : 
                   this.choixJoueur(tirage, joueur);
         break;
            
        default : 
                   System.out.println("Vous n'avez pas rentré P , I ou R");
                    this.choixParité(tirage, joueur);
        }
    }
       else {
            System.out.println("Vous avez déjà choisis pair et impair");
    }
    
  this.choixJoueur(tirage, joueur);
      
}

public void choixCouleur(SetRoulette tirage, ChoixJoueur joueur) {
     Scanner sc = new Scanner(System.in); 
     
    if (joueur.choixRouge !=true || joueur.choixNoir !=true) { 
    System.out.println("Rouge (R) , Noir (N) ou Retour (B)?  ");
    choixcouleur =sc.next();
    
    switch (choixcouleur) {
        
        case "R" : 
                   if(joueur.choixRouge == true) {
                   System.out.println("Vous avez déjà choisis rouge");
                   this.choixParité(tirage, joueur);
                        }
                     else {
                            joueur.choixRouge = true;
                            montantMise("Rouge", joueur);
                             }
         break;
            
        case "N" :  
                   if(joueur.choixNoir == true) {
                   System.out.println("Vous avez déjà choisis noir");
                   this.choixParité(tirage, joueur);
                       }
                     else {
                            joueur.choixNoir = true;
                            montantMise("Noir", joueur);
                             }
        break;
            
        case "B" : 
                   this.choixJoueur(tirage, joueur);
         break;
            
        default : 
                   System.out.println("Vous n'avez pas rentré R , N ou B");
                    this.choixParité(tirage, joueur);
        }
    }
       else {
            System.out.println("Vous avez déjà choisis Rouge et Noir");
    }
    
  this.choixJoueur(tirage, joueur);
      
}

public void choixouleur(SetRoulette tirage, ChoixJoueur joueur) {   
    

        if(choixrouge!=true || choixnoir!=true) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Couleur Rouge (R) , Noir (N) ou Menu (M) ?  ");
    choixcouleur =sc.next();
    
    if(choixcouleur.equals("R")) {
        if(choixrouge==true) {
            System.out.println("Vous avez déjà choisis rouge");
            this.choixCouleur(tirage, joueur);
        }
        else {
        choixrouge=true;
        //  montantMise();
        }
    }
       
    else{
        if(choixcouleur.equals("N")) {
             if(choixnoir==true) {
            System.out.println("Vous avez déjà choisis noir");
            this.choixCouleur(tirage, joueur);
             }
             else {
            choixnoir=true;
          //  montantMise();
             }
        }
        
         else{
        if(choixcouleur.equals("M")) {
          this.choixJoueur(tirage, joueur);
        }
     else {
            System.out.println("Vous n'avez pas rentré R ,N  ou M");
            this.choixCouleur(tirage, joueur);
        }
      }
    }  
    }
    else {
        System.out.println("Vous avez déjà choisis rouge et noir");
     this.choixJoueur(tirage, joueur);
    }
  
}

public void verifNombre() {
    

    if(tabmiroir[nombre]==true) {
       gainNombre();
         }
    
}

public void verifParité(SetRoulette tirage, ChoixJoueur joueur) {
    
      
        if(joueur.choixPair == true && tirage.SetUpRoulette().parité == "pair") {
              PorteMonnaie.gainArgent(joueur.misePair*2);
                }
        
        else {
            if(joueur.choixImpair==true && tirage.SetUpRoulette().parité == "impair") {
              PorteMonnaie.gainArgent(joueur.miseImpair*2);
                 }
          }
}

public void verifCouleur(SetRoulette tirage, ChoixJoueur joueur) {
            
    if (joueur.choixRouge==true && tirage.SetUpRoulette().color == "rouge") {
       PorteMonnaie.gainArgent(joueur.miseRouge*2);
    }
    else {
        if (choixnoir==true && tirage.SetUpRoulette().color == "noir") {
            PorteMonnaie.gainArgent(joueur.miseNoir*2);
        }
    }
}

public void montantMise(String jeux, ChoixJoueur joueur) {
  
       
        if(PorteMonnaie.argent != 0) {
            
        Scanner sc = new Scanner(System.in);
        System.out.println("Combien voulez vous miser?");
       int choixmise3 = sc.nextInt();
                  
         if(choixmise3 == 0) {
              System.out.println("Vous ne pouvez pas miser 0");
              this.montantMise(jeux, joueur);
                      } 
                   else {
                       if (choixmise3 != 0) {
                            this.verifMise(jeux, choixmise3, joueur);
                                    }
                            }
                   
          
       /*   else {
        System.out.println("Attention, veuillez rentrer un entier valide");
        this.montantMise(mise);
                   }    */
         } 
        
        else {
            System.out.println("Vous n'avez plus d'argent");
          //  this.choixJoueur();
        }
          

        
    }
    
public void verifMise(String jeux, int montant, ChoixJoueur joueur) {
         
          
        if(PorteMonnaie.argent-montant<0) {
            System.out.println("Vous n'avez pas assez d'argent, il ne vous reste que " + PorteMonnaie.argent);
            this.montantMise(jeux, joueur);
                   }
        
                else {
                   PorteMonnaie.miseArgent(montant);
                   System.out.println("Il vous reste  " + PorteMonnaie.argent);          
            
             switch (jeux) {
            
            case "Number":
                   ChoixJoueurList objet = new ChoixJoueurList(choixnombre,montant);
                   joueur.number.add(objet);
                   break;
          
             case"Rouge" :     
                   joueur.miseRouge = montant; 
                   break;
           
            case "Noir" :               
                   joueur.miseNoir = montant;
                   break;
                
            case"Pair" :     
                   joueur.misePair = montant; 
                   break;
           
            case "Impair" :               
                   joueur.miseImpair = montant;
                   break;
                
                     }   
               }
    }
    
    public void gainNombre() {
        
        if(misenombre[this.nombre]!=0) {
         
           PorteMonnaie.gainArgent(misenombre[this.nombre]*35);        
        }
    }


    
}