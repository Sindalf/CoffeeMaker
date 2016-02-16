package coffeemaker;

import org.junit.Test;
import static org.junit.Assert.*;


public class RoomTest {


    
    /*
    Creates a new room object and tests if the item added is what is returned
    Checks for a string value and a null value
    */
    @Test
    public void testGetItem() {
        Room testroom = new Room("","","testitem","","");
        assertTrue("testitem".equals(testroom.getItem()));
        
        testroom = new Room("","",null,"","");
        assertNull(testroom.getItem());
    }
    /*
    Creates a new room object and test is if the description added is what is returned;
    */
    @Test
    public void testGetDescription() {
        Room testroom = new Room("test description","","","","");
        assertTrue("test description".equals(testroom.getDescription()));
        
        testroom = new Room("test description","","","","");
        assertFalse("".equals(testroom.getDescription()));
    }
     
    /*
    Creates a new room object and checks if the unique item entered is returned
    */
    @Test
    public void testGetUniqueItem() {
        Room testroom = new Room("","test UniqueItem","","","");
        assertTrue("test UniqueItem".equals(testroom.getUniqueItem()));
    }
    
    /*
    Creates a new room object and checks the south door
    Testing if the southdoor you put in gets returned
    null is a possible value
    */
    @Test
    public void testGetSouthDoor() {
        Room testroom = new Room("","","","testdoor","");
        assertTrue("testdoor".equals(testroom.getSouthDoor()));
        
        testroom = new Room("","","",null,"");
        assertNull(testroom.getSouthDoor());
    }
    /*
    Creates a new room object and checks the north door
    Testing if the northdoor you put in gets returned
    null is a possible value
    */
    @Test
    public void testGetNorthDoor() {
        Room testroom = new Room("","","","","testdoor");
        assertTrue("testdoor".equals(testroom.getNorthDoor()));
        
        testroom = new Room("","","","",null);
        assertNull(testroom.getNorthDoor());     
    }
    
}
