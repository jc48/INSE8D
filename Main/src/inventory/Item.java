/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

/**
 *
 * @author up812110
 */
public class Item {

    /**
     * Instance variables for Item class.
     */
    public String item;
    public int quantity, addedDate, expiryDate;
    
    /**
     * Constructor for Inventory class.
     */
    public Item (){
    }
    
    /**
     * Constructor for Inventory class.
     * @param itemName identifies the item name.
     * @param itemQuantity identifies the item Quantity.
     * @param itemAddedDate identifies the date of the added item.
     * @param itemExpiryDate identifies the expiry date of the added item .
     */
    public Item(String itemName, int itemQuantity, int itemAddedDate, int itemExpiryDate){
        item = itemName;
        quantity = itemQuantity;
        expiryDate = itemExpiryDate;
        addedDate = itemAddedDate;
    }
    
     /**
     * Sets the item name.
     * @param setItemName identifies the item name.
     */
    public void setItemName(String setItemName){
        item = setItemName;
    }

     /**
     * Gets the Item Name.
     * @return item 
     */
    public String getItemName(){
        return item;
    }
    
    /**
     * Sets a new quantity
     * @param newQuantity  identifies the item quantity.
     */
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }

    /**
     * Gets the quantity of item.
     * @return quantity
     */
    public int getQuantity(){
        return quantity;
    }
    
    /**
     * Sets a the added date
     * @param newAddedDate identifies the date item was added.
     */
    public void setAddedDate(int newAddedDate){
       expiryDate = newAddedDate;
    }

    /**
     * Gets the added date of item.
     * @return addedDate 
     */
    public int getAddedDate(){
        return addedDate;
    }

    /**
     * Sets the ExpiryDate
     * @param newExpiryDate identifies the expiry date for item.
     */
    public void setExpiry(int newExpiryDate){
       expiryDate = newExpiryDate;
    }
    
    /**
     * Gets the expiry date of item.
     * @return expiryDate
     */
    public int getExpiryDate(){
        return expiryDate;
    }


}
