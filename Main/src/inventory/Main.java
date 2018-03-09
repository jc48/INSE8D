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
public class Main {

   // public Main() {    /* Creates a new instance of Main */
   // }   
    //static Scanner console = new Scanner(System.in);  //object of Scanner class
    
    public static void main(String[] args) {
        Item item1 = new Item("apple", 2,3, 2);
        Item item2 = new Item("banana",303,4, 3);
        
        
        Item item3 = new Item();
        item3.setItemName("chicken");
        item3.setQuantity(23);
        item3.setExpiry(20);
        
       /**
        ArrayList<Item> inventory1 = new ArrayList<>();
        inventory1.add(item1);
        inventory1.add(item2);
        inventory1.add(item3);
        **/
        Inventory hisInventory = new Inventory();
       
        hisInventory.addItem(item3);
       // Inventory ThisInventory = new Inventory(inventory1);
        
        hisInventory.getInveItem();
        hisInventory.getInventoryItemInfo();
        
        HomeGui home = new HomeGui();
        home.setTitle("keepFridge");
        home.setVisible(true);
        home.setLocationRelativeTo(null); 
    }
    
}
