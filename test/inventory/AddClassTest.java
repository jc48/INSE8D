/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SalimMatazu
 */
public class AddClassTest {
    HomeGui home = new HomeGui();
    
    public AddClassTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   

    /**
     * Test of getitemQuantity method, of class AddClass.
     */
    @Test
    public void testGetitemQuantity() {
        System.out.println("getitemQuantity");
        AddClass instance = new AddClass(home);
        instance.itemQuantityTxt.setText("5");
        int expResult = 5;
        int result = instance.getitemQuantity();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getItemName method, of class AddClass.
     */
    @Test
    public void testGetItemName() {
        System.out.println("getItemName");
        AddClass instance = new AddClass(home);
        instance.itemName.setText("chicken");
        String expResult = "chicken";
        String result = instance.getItemName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of clearUi method, of class AddClass.
     */
    @Test
    public void testClearUi() {
        System.out.println("clearUi");
        AddClass instance = new AddClass(home);
        instance.itemName.setText("5");
        instance.itemQuantityTxt.setText("5");
        instance.clearUi();
        String expResult = "";
        String result = "";
        assertEquals(expResult, result);    
    }

    
}
