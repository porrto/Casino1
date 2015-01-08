/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbar;


import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author isen
 */
public class Bar {
    
    public String choix;
    public int choixverre;
    boolean pass;
    
  
    public String C1="Mojito";
    public String C2="";
    public String C3="";
    public String C4="";
    public String C5="";
    
    public String S1="Coca cola";
    public String S2="Perrier";
    public String S3="";
    public String S4="";
    public String S5="";
    
    public String A1="";
    public String A2="";
    public String A3="";
    public String A4="";
    public String A5="";
    
    public int prixC1=12;
    public int prixC2;
    public int prixC3;
    public int prixC4;
    public int prixC5;
    
    public int prixS1=5;
    public int prixS2=6;
    public int prixS3;
    public int prixS4;
    public int prixS5;
    
    public int prixA1;
    public int prixA2;
    public int prixA3;
    public int prixA4;
    public int prixA5;
    
    public int tauxC1=12;
    public int tauxC2;
    public int tauxC3;
    public int tauxC4;
    public int tauxC5;
    
    public double tauxS1=0.4;
    public double tauxS2=0.4;
    public int tauxS3;
    public int tauxS4;
    public int tauxS5;
    
    public int tauxA1;
    public int tauxA2;
    public int tauxA3;
    public int tauxA4;
    public int tauxA5;
    
    
   //public  String carte[][]= {{C1,C2,C3,C4,C5,S1,S2,S3,S4,S5,A1,A2,A3,A4,A5},{prixC1,prixC2,prixC3,prixC4,prixC5,prixS1,prixS2,prixS3,prixS4,prixS5,prixA1,prixA2,prixA3,prixA4,prixA5}};
    
    
    
    
    
    public void choixJoueur() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Vous avez" +  PorteMonnaie.argent);
        if(Alcoolémie.soul==true){
                this.fired();
                
                   }
        
          
            else {
        
        System.out.println("Voulez vous un Cocktail (C), un Soda (S) ou un Alcool fort (A) ? ");
        choix = sc.next();
        
        if(choix.equals("C") || choix.equals("S") || choix.equals("A")) {
        switch (choix) {
           
         case "C": this.choixCoktails();
             break;
         case "S": this.choixSoda();
             break; 
         case "A": this.choixAlcools();  
             break;
       }
        }
       else {
            System.out.println("Vous n'avez pas rentrée C, S ou A ");
            this.choixJoueur();
            
        }
            }
        
    }

    public void choixCoktails() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel Cocktail voulez-vous ? ");
        System.out.println("-"+ C1 +"\n"+ "-"+C2 +"\n"+ "-"+C3 +"\n"+ "-"+C4 +"\n"+ "-"+C5);
        choix = sc.next();
        
        
      switch(choix) {
           case "C1":
                 verifArgent(prixC1,tauxC1);
               break;
               
               case "C2":
                 verifArgent(prixC2,tauxC2);
               break;
                   case "C3":
                 verifArgent(prixC3,tauxC3);
               break;
                       case "C4":
                 verifArgent(prixC4,tauxC4);
               break;
                           case "C5":
                 verifArgent(prixC5,tauxC5);
               break;
                   
                           default:
                 System.out.println("Veuillez entrer " +C1 + C2 + C3 + C4+ "ou" + C5);                     
                    this.choixCoktails();
        }
          
        }

    public void choixSoda() {
        
       Scanner sc = new Scanner(System.in);
        System.out.println("Quel Soda voulez-vous ? ");
        System.out.println("-"+ S1+"( S1)" +"\n"+ "-"+S2 + "(S2)" +"\n"+ "-"+S3+"(S3)"+"\n"+ "-"+S4+"(S4)" +"\n"+ "-"+S5+"(S5)");
       choix = sc.next();

       switch(choix) {
           case "S1":
                 verifArgent(prixS1,tauxS1);
               break;
               
               case "S2":
                 verifArgent(prixS2,tauxS2);
               break;
                   case "S3":
                 verifArgent(prixS3,tauxS3);
               break;
                       case "S4":
                 verifArgent(prixS4,tauxS4);
               break;
                           case "S5":
                 verifArgent(prixS5,tauxS5);
               break;
                   
                           default:
            System.out.println("Veuillez entrer " +S1 + S2 + S3 + S4+ "ou" + S5);
                               this.choixSoda();
        }
        
    }

    public void choixAlcools() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel Alcool voulez-vous ? ");
        System.out.println("-"+ A1 +"\n"+ "-"+A2 +"\n"+ "-"+A3 +"\n"+ "-"+A4 +"\n"+ "-"+A5);
        choix = sc.next();

        switch(choix) {
           case "A1":
                 verifArgent(prixA1,tauxA1);
               break;
               
               case "A2":
                 verifArgent(prixA2,tauxA2);
               break;
                   case "A3":
                 verifArgent(prixA3,tauxA3);
               break;
                       case "A4":
                 verifArgent(prixA4,tauxA4);
               break;
                           case "a5":
                 verifArgent(prixA5,tauxA5);
               break;
                   
                           default:
            System.out.println("Veuillez entrer " +A1 + A2 + A3 + A4+ "ou" + A5);
                               this.choixAlcools();
        }
        
        
    }
    
     public boolean isInteger(String verif) {
    
    try {
        Integer.valueOf(verif);
        return true;     
    } catch (NumberFormatException e) {
       return false;
    }
}
     
      public void verifArgent(int prix, double taux) {
        
        
        if(PorteMonnaie.argent-prix<0) {
            System.out.println("Vous n'avez pas assez d'argent, il ne vous reste que " + PorteMonnaie.argent);
            this.choixJoueur();
        }
        
        else {
            
           Alcoolémie.verifTaux(taux);
           if(Alcoolémie.drink==true) {
                       PorteMonnaie.miseArgent(prix);
            System.out.println("Il vous reste  " + PorteMonnaie.argent);          
            this.choixJoueur();
               
           }
    
           else {
               this.choixJoueur();
           }
        }
   
        }
    
      public void fired() {
          
         Scanner sc = new Scanner(System.in);
          if(Alcoolémie.soul==true) {
              System.out.println("Vous êtes viré du casino, vous êtes soul");
              System.out.println("Voulez vous rententer votre chance ? (Y) or (N) ");
         choix=sc.next();
         
         switch(choix) {
             case "Y":
                 System.out.println("Vous allez essayer de passer malgrès le videur ...");
                 Random rand = new Random();
                  pass=  rand.nextBoolean();
                 
                 if(pass==true) {
                     System.out.println(" Vous êtes re-rentré dans le casino");
                        MenuCasino.Menu.fired=true;
                     
                 }
             
                 else {
                     MenuCasino.Menu.fired=true;
                     MenuCasino.Menu.quitter=true;
                 }
             break;
                 
             case "N": 
                 System.out.println("au revoir");
                  MenuCasino.Menu.quitter=true;
                  break;
                 
             default : System.out.println("Vous n'avez pas rentré (Y) or (N)");    
         }
     
          }
      }
    
}
