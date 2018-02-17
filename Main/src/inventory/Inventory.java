/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.util.ArrayList;

/**
 *
 * @author up812110
 */
public class Inventory {
    public String item;
    public int quantity, expiryDate;
    //ArrayList<String> inventory1 = new ArrayList<String>();
    public Inventory (){
    }
    
    public Inventory(String itemName, int itemQuantity, int itemExpiryDate){
        item = itemName;
        quantity = itemQuantity;
        expiryDate = itemExpiryDate;
    }
    
    public void setItemName(String setItemName){
        item = setItemName;
    }
    public String getItem(){
        return item;
    }
    
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setExpiry(int newExpiryDate){
       expiryDate = newExpiryDate;
    }
    public int getExpiryDate(){
        return expiryDate;
    }

    public void getItemInfo(){

    System.out.println("Item: " + item);
    System.out.println("Quantity: " + quantity);
    System.out.println("Expiry Date: " + expiryDate);
    }
    

}
