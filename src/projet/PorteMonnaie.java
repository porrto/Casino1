/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author isen
 */
public class PorteMonnaie {
    public static int argent=20;
    public int tune23;
    
    public static void gainArgent(int gain) {
        
        argent=argent + gain;
    }
    
    public static void miseArgent(int mise) {
        
         argent=argent- mise;
        
    }
    
     public static int getArgent() {
            
            return argent;
        }
    }

