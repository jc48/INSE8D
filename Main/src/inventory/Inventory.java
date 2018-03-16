/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.util.ArrayList;

/**
 *
 * @author INSE8D
 */
public class Inventory extends Item{
   
    /**
     * Instance variables for Inventory class.
     */
    public ArrayList <Item> inventory1 = new ArrayList<>();
   
     /**
     * Constructor for Inventory class.
     */
    public Inventory(){
    }
    
    /**
     * Gets inventory item.
     * @return inventory1
     */
    
    public ArrayList<Item> getInveItem(){
        return inventory1;
    }
    
    /**
     * Gets the inventory size.
     * @return inventory.size()
     */
    public int getInvenItemListSize(){
        return inventory1.size();
    }
   
    /**
     * Adds item to inventory
     * @param i identifies the item.
     */
    public void addItem(Item i){
        inventory1.add(i);
    }
    
    /**
     * Removes item from inventory
     * @param i identifies the item.
     */
    public void removeItem(Item i){
        inventory1.remove(i);
    
    }
   
    /**
    * Shows information of each item in inventory.
    */
    public void getInventoryItemInfo(){
        for(Item x : inventory1){
            System.out.print("Item: " + x.getItemName() + "\n" + "Quantity: " + x.getQuantity() + "\n" + "Date Added: " + x.getAddedDate() + "\n" + "Expiry Date: " + x.getExpiryDate() + "\n");
        }
        
    
    }
    
}
