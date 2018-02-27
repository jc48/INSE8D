/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author up812110
 */
public class Main {

   // public Main() {    /* Creates a new instance of Main */
   // }   
    //static Scanner console = new Scanner(System.in);  //object of Scanner class
    
    public static void main(String[] args) {
        Inventory item1 = new Inventory("apple", 2, 2);
        Inventory item2 = new Inventory("banana",303, 3);
        
        
        Inventory item3 = new Inventory();
        item3.setItemName("chicken");
        item3.setQuantity(23);
        item3.setExpiry(20);
        
       
        ArrayList<Inventory> inventory1 = new ArrayList<>();
        inventory1.add(item1);
        inventory1.add(item2);
        inventory1.add(item3);
        
        Home home1 = new Home(inventory1);
        
        home1.itemIn();
        home1.printOut();
        
        HomeGui home = new HomeGui();
        home.setTitle("keepFridge");
        home.setVisible(true);
        home.setLocationRelativeTo(null); 
    }
    
}
