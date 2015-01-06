/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roulette;

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
public  String choixnombre="";
public  int choixnombre2;
public  String choix;

public  String choixparité="";
public  boolean choixpair=false;
public  boolean choiximpair=false;

public String choixcouleur="";
public  boolean choixrouge=false;
public  boolean choixnoir=false;
public  boolean tabmiroir[] = new boolean[36];

public int gainnombre;
public int misenombre[] = new int[36];
public int miserouge=0;
public  int misenoir=0;
public  int misepair;
public  int miseimpair;
public int  choixmise;
  
public boolean isInteger(String verif) {
    
    try {
        Integer.valueOf(verif);
        return true;     
    } catch (NumberFormatException e) {
       return false;
    }
}
    
 public void setTabMiroir() {
     
     for (int i = 0 ;  i  <= 36 ; i++) {
     tabmiroir[i] = false; 
      }
     
 }
 
public void getCouleur() {
     
        if (nombre == 32 || nombre==  19 || nombre==21 ||nombre==25 || nombre==34 || nombre == 27 || nombre==  36 || nombre==30 ||nombre==23 || nombre==5 ||
            nombre == 16 || nombre==  1 || nombre==14 ||nombre==9 || nombre==18 || nombre == 7 || nombre==  12 || nombre==3 ) {              
            couleur="rouge";
           }
        else {
            if(nombre!=0){
                  couleur="noir";
            }
        }             
    }
    
public void getParité() {
        
        if (nombre % 2 == 0) {
            tiragepair=true;
        }
        else {
           tiragepair=false;
        }
    }
     
public void getSreenRoulette() {
    
    this.getCouleur();
    this.getParité();
    //System.out.println(couleur + tiragepair + nombre);
    this.choixJoueur();
}

public void choixNombre() {
     
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Quel nombre entre 0 et 36  ou retournez au menu (100)?  ");
    choixnombre =sc.next();
    if(this.isInteger(choixnombre)==true) {
    int quitter =Integer. parseInt(choixnombre);
    
    if(quitter==(100)) {
        this.choixJoueur();
     
    }
    else {
    if (quitter>=0 && quitter<=36) {
        this.addToTab();
    }
     else {
        System.out.println("Vous n'avez pas rentré un entier entre 0 et 36");
        this.choixNombre();
      }
    }
  }
    else {
        System.out.println("Attention, veuillez rentrer un entier valide");
        this.choixNombre();
    }
}

public void addToTab() {
    
  
choixnombre2 =Integer. parseInt(choixnombre);

if(tabmiroir[choixnombre2]==false) {
        tabmiroir[choixnombre2]=true;
    montantMise();
 
    }
else {
    System.out.println("Vous avez déjà choisis" + choixnombre);
    this.choixNombre();
}
          
}

public void choixParité() {
    
  
    Scanner sc = new Scanner(System.in);
    if (choixpair!=true || choiximpair!=true) { 
    System.out.println("Pair (P) , Impair (I) ou Retour (R)?  ");
    choixparité =sc.next();
    
    if(choixparité.equals("P")) {
        if(choixpair==true) {
            System.out.println("Vous avez déjà choisis pair");
            this.choixParité();
        }
        else {
        choixpair=true;
        montantMise();
        }
    }
       
    else{
        if(choixparité.equals("I")) {
             if(choiximpair==true) {
            System.out.println("Vous avez déjà choisis impair");
            this.choixParité();
             }
             else {
            choiximpair=true;
            montantMise();
             }
        }
        
         else{
        if(choixparité.equals("R")) {
            this.choixJoueur();
        }
   
        else {
            System.out.println("Vous n'avez pas rentré P , I ou R");
            this.choixParité();
        }
      }
    }
    }
    
    else {
        System.out.println("Vous avez déjà choisis pair et impair");
    }
    
     this.choixJoueur();
    
}

public void choixCouleur() {   
    

        if(choixrouge!=true || choixnoir!=true) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Couleur Rouge (R) , Noir (N) ou Menu (M) ?  ");
    choixcouleur =sc.next();
    
    if(choixcouleur.equals("R")) {
        if(choixrouge==true) {
            System.out.println("Vous avez déjà choisis rouge");
            this.choixCouleur();
        }
        else {
        choixrouge=true;
        montantMise();
        }
    }
       
    else{
        if(choixcouleur.equals("N")) {
             if(choixnoir==true) {
            System.out.println("Vous avez déjà choisis noir");
            this.choixCouleur();
             }
             else {
            choixnoir=true;
            montantMise();
             }
        }
        
         else{
        if(choixcouleur.equals("M")) {
            this.choixJoueur();
        }
     else {
            System.out.println("Vous n'avez pas rentré R ,N  ou M");
            this.choixCouleur();
        }
      }
    }  
    }
    else {
        System.out.println("Vous avez déjà choisis rouge et noir");
        this.choixJoueur();
    }
  
}

public void verifNombre() {
    

    if(tabmiroir[nombre]==true) {
       gainNombre();
         }
    
}

public void verifParité() {
    
      
        if(choixpair==true && tiragepair==true) {
       gainParité(tiragepair);
        }
        else {
            if(choiximpair==true && tiragepair==false) {
            
            gainParité(tiragepair);
            }
          }
}

public void verifCouleur() {
    
 

        
    if (choixrouge==true && couleur=="rouge") {
       gainCouleur("rouge");
    }
    else {
        if (choixnoir==true && couleur=="noir") {
            gainCouleur("noir");
        }
    }
}

public void choixJoueur() {
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Nombre (N) Parité (P) Couleur (C) ou Tourner la roue (R) ?  ");
     choix=sc.next();
    
    if("N".equals(choix) || "P".equals(choix) || "C".equals(choix) ||"R".equals(choix)) {
         switch(choix) {
        case "N": this.choixNombre();
            break;
        case "P": this.choixParité();
            break;
        case "C": this.choixCouleur();
            break;
        case "R":
                    if (choixnombre=="" & choixcouleur=="" && choixparité=="") {
                        System.out.println("Vous n'avez pas misé") ;
                        this.choixJoueur();
                                }
                    else {
                    
            this.verifNombre();
                         this.verifParité();
                      this.verifCouleur();
                        System.out.println("Le tirage était de couleur "+ couleur +"de parité" + tiragepair +"et le nombre" + nombre);
                         System.out.println("Votre porte monnaie est maintenant de" + PorteMonnaie.argent+"euros");
                       
                         if(PorteMonnaie.argent!=0) {
                         System.out.println("Voulez vous rejouez ? (Y) or (N) ");
                          String  choixnouvellepartie =sc.next();
                          if(choixnouvellepartie.equals("Y")) {
                              System.out.println("Vous disposez maintenant de " + PorteMonnaie.argent+"euros");
                                  Roulette rou = new Roulette();
                                  Random rand = new Random();
                                   nombre= rand.nextInt(37);
                                   rou.getSreenRoulette();
                          }
                          else {
                              if(choixnouvellepartie.equals("N")) {
                                
                              }
                              else {
                                  System.out.println("Veuillez entrer Y ou N ");
                                  this.choixJoueur();
                              }
                          }
            break;
    }
          }
    }
    }
    else {
            System.out.println("Vous n'avez pas entré N ,P , C ou R");
        this.choixJoueur();
  
       }
    }

    public void montantMise() {
    
       
        if(PorteMonnaie.argent!=0) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Combien voulez vous miser?");
        String choixmise2 =sc.next();
          if(this.isInteger(choixmise2)==true) {
              
          choixmise =Integer. parseInt(choixmise2);
          if(choixmise==0){
              System.out.println("Vous ne pouvez pas miser 0");
              this.montantMise();
          } 
          else {
              if (choixmise!=0) {
        this.verifMise(choixmise);
    }
          }
             }
          
          else {
        System.out.println("Attention, veuillez rentrer un entier valide");
        this.montantMise();
              }
        }
        
        else {
            System.out.println("Vous n'avez plus d'argent");
            this.choixJoueur();
        }
          
        
    }
    
    public void verifMise(int montant) {
        
        if(PorteMonnaie.argent-montant<0) {
            System.out.println("Vous n'avez pas assez d'argent, il ne vous reste que " + PorteMonnaie.argent);
            this.montantMise();
        }
        else {
            PorteMonnaie.miseArgent(montant);
            System.out.println("Il vous reste  " + PorteMonnaie.argent);          
             switch (choix) {
            
            case "N":
              
            misenombre[choixnombre2]=montant;
            this.choixJoueur();
            break;
          
            case "C":
            if(choixcouleur.equals("N")) {
                misenoir=montant; 
            }
                else {
                        if (choixcouleur.equals("R")) {
                        miserouge=montant;
                        }
                        else { 
                            System.out.println("erreur verif mise couleur");
                        }
            }
            this.choixJoueur();
            break;
                
            case"P":     
                 if(choixparité.equals("P")) {
                misepair=montant; 
            }
                else {
                        if (choixparité.equals("I")) {
                        miseimpair=montant;
                        }
                        else { 
                            System.out.println("erreur verif mise parité");
                        }
            }
               
            break;
                
        }
   
        }
    }
    
    public void gainNombre() {
        
        if(misenombre[this.nombre]!=0) {
         
           PorteMonnaie.gainArgent(misenombre[this.nombre]*35);        
        }
    }
    
    public void gainCouleur(String couleur) {
        
if (couleur.equals("rouge")) {
        
             PorteMonnaie.gainArgent(miserouge*2); }
    else {
                 PorteMonnaie.gainArgent(misenoir*2);
     }  
    }
        
    public void gainParité(boolean parité) {
        
                
if (parité==true) {
        
             PorteMonnaie.gainArgent(misepair*2);
}
    else {
                 PorteMonnaie.gainArgent(miseimpair*2);
     } 
    }
    
}