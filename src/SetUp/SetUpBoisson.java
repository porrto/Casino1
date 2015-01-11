/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetUp;

import java.util.ArrayList;
import java.util.List;
import projetbar.Food;

/**
 *
 * @author isen
 */
public class SetUpBoisson {
    
 
    

    
 public List<Food> setUpAlcool() {
     
     Food vodka = new Food("vodka",6,1);
     Food martini = new Food("martini",6,2);
     Food wiskie = new Food("wiskie",6,3);
     
     List<Food> listAlcool = new ArrayList();
     
     listAlcool.add(vodka);
     listAlcool.add(martini);
     listAlcool.add(wiskie);
     
     return listAlcool;
     
 }
    
 public List<Food> setUpSoda() {
     
     Food cocacola = new Food("Coca-Cola",5,1);
     Food icetea = new Food("Ice Tea",5,2);
     Food redbull = new Food("Red Bull",6,3);
     
     List<Food> listSoda = new ArrayList();
     
     listSoda.add(cocacola);
     listSoda.add(icetea);
     listSoda.add(redbull);
     
     return listSoda;
 }
 
 public List<Food> setUpCocktails() {
     
     Food mojito = new Food("Mojito",7,1);
     Food pinacolada = new Food("Pina Colada",7,2);
     Food soholong = new Food("Soho Long",7,3);
     
     List<Food> listCocktails = new ArrayList();
     
     listCocktails.add(mojito);
     listCocktails.add(pinacolada);
     listCocktails.add(soholong);
     
     return listCocktails;    
     
 }
 
}
