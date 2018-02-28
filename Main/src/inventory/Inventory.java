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
public class Inventory extends Item{
   
    private ArrayList <Item> inventory1 = new ArrayList<Item>();
    
    public Inventory( ArrayList<Item> inventoryItems){
        inventory1=inventoryItems;
    }
    public ArrayList<Item> getInveItem(){
        return inventory1;
    }
    
    public int getInvenItemListSize(){
        return inventory1.size();
    }

    public void addItem(Item i){
        inventory1.add(i);
    }
    
    public void removeItem(Item i){
        inventory1.remove(i);
    
    }
    
    public void getInventoryItemInfo(){
        for(Item x : inventory1){
            System.out.print("Item: " + x.getItem() + "\n" + "Quantity: " + x.getQuantity() + "\n" + "Date Added: " + x.getAddedDate() + "\n" + "Expiry Date: " + x.getExpiryDate() + "\n");
        }
        
    
    }
    
}