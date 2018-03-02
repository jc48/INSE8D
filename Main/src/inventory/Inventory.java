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
   
    public ArrayList <Item> inventory1 = new ArrayList<>();
    //public int id;
    public Inventory(){
       //id = id1;
       // this.inventory1;
    }
    
    // create a list of users
    public ArrayList createInven()
    {
        ArrayList<Item> list = new ArrayList<>(); 
        inventory1 = list;
        return inventory1;
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
    /**
    public void getItemInfo(ArrayList inv){
        for(int i = 1; i < inv.size(); ++i){
            System.out.print("Item: " + i.getItemName() + "\n" + "Quantity: " + i.getQuantity() + "\n" + "Date Added: " + i.getAddedDate() + "\n" + "Expiry Date: " + i.getExpiryDate() + "\n");
        }
        **/
    public void getInventoryItemInfo(){
        for(Item x : inventory1){
            System.out.print("Item: " + x.getItemName() + "\n" + "Quantity: " + x.getQuantity() + "\n" + "Date Added: " + x.getAddedDate() + "\n" + "Expiry Date: " + x.getExpiryDate() + "\n");
        }
        
    
    }
    
}