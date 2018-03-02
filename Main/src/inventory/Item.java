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
public class Item {
    public String item;
    public int quantity, addedDate, expiryDate;
    //ArrayList<String> inventory1 = new ArrayList<String>();
    public Item (){
    }
    
    public Item(String itemName, int itemQuantity, int itemAddedDate, int itemExpiryDate){
        item = itemName;
        quantity = itemQuantity;
        expiryDate = itemExpiryDate;
        addedDate = itemAddedDate;
    }
    
    public void setItemName(String setItemName){
        item = setItemName;
    }
    public String getItemName(){
        return item;
    }
    
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }
    public int getQuantity(){
        return quantity;
    }
    
    public void setAddedDate(int newAddedDate){
       expiryDate = newAddedDate;
    }
    public int getAddedDate(){
        return addedDate;
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
    System.out.println("Date Added: " + addedDate);
    System.out.println("Expiry Date: " + expiryDate);
    }
    

}
