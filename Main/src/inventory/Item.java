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
     *
     */
    public String item;

    /**
     *
     */
    public int quantity,

    /**
     *
     */
    addedDate, expiryDate;
    //ArrayList<String> inventory1 = new ArrayList<String>();

    /**
     *
     */
    public Item (){
    }
    
    /**
     *
     * @param itemName
     * @param itemQuantity
     * @param itemAddedDate
     * @param itemExpiryDate
     */
    public Item(String itemName, int itemQuantity, int itemAddedDate, int itemExpiryDate){
        item = itemName;
        quantity = itemQuantity;
        expiryDate = itemExpiryDate;
        addedDate = itemAddedDate;
    }
    
    /**
     *
     * @param setItemName
     */
    public void setItemName(String setItemName){
        item = setItemName;
    }

    /**
     *
     * @return
     */
    public String getItemName(){
        return item;
    }
    
    /**
     *
     * @param newQuantity
     */
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }

    /**
     *
     * @return
     */
    public int getQuantity(){
        return quantity;
    }
    
    /**
     *
     * @param newAddedDate
     */
    public void setAddedDate(int newAddedDate){
       expiryDate = newAddedDate;
    }

    /**
     *
     * @return
     */
    public int getAddedDate(){
        return addedDate;
    }

    /**
     *
     * @param newExpiryDate
     */
    public void setExpiry(int newExpiryDate){
       expiryDate = newExpiryDate;
    }

    /**
     *
     * @return
     */
    public int getExpiryDate(){
        return expiryDate;
    }

    /**
     *
     */
    public void getItemInfo(){

    System.out.println("Item: " + item);
    System.out.println("Quantity: " + quantity);
    System.out.println("Date Added: " + addedDate);
    System.out.println("Expiry Date: " + expiryDate);
    }
    

}
