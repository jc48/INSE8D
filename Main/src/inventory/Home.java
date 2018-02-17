/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.util.ArrayList;

/**
 *
 * @author ShaunahRose
 */
public class Home extends Inventory{
   
    ArrayList<Inventory> inventory1 = new ArrayList<>();
    public Home( ArrayList<Inventory> items){
        inventory1=items;
    }
    public ArrayList<Inventory> itemIn(){
        return inventory1;
    
    }
    public void printOut(){
        for(Inventory x : inventory1){
            System.out.print("Item: " + x.getItem() + "\n" + "Quantity: " + x.getQuantity() + "\n" + "Expiry Date: " + x.getExpiryDate() + "\n");
        }
        
    
    }
    
}
