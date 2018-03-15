
package inventory;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author INSE8D
 */
public class ShopGUITest {
    HomeGui home = new HomeGui();
    
    public ShopGUITest() {
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
     * Test of getAddItem method, of class ShopGUI.
     */
    @Test
    public void testGetAddItem() {
        System.out.println("getAddItem");
        ShopGUI instance = new ShopGUI(home);
        instance.addItem.setText("beef");
        String expResult = "beef";
        String result = instance.getAddItem();
        assertEquals(expResult, result);
        
    }


    /**
     * Test of addItem method, of class ShopGUI.
     */
    @Test
    public void testAddItem() {
        System.out.println("getAddItem");
        ShopGUI instance = new ShopGUI(home);
        instance.addItem.setText("beef");
        String expResult = "beef";
        String result = instance.getAddItem();
        assertEquals(expResult, result);
    }

   
}
