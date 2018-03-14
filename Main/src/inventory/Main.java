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
        
    	
        HomeGui home = new HomeGui();
        home.setTitle("keepFridge");
        home.setVisible(true);
        home.setLocationRelativeTo(null); 
    }
       
}
