/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetbar;

/**
 *
 * @author isen
 */
public class Boisson {

    public String name;
    public int price;
    public double taux = 0.20;
    public int number;

    public Boisson(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

}
