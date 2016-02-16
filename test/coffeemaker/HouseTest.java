package coffeemaker;

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class HouseTest {
    
    /*
    Tests if a new room is added to the House object.
    */
   @Test
    public void testAddRoom() {
        House house = new House();
        int result = house.addRoom("", "", "", "", "");
        assertEquals(result,1);
    }
    
    /*
    Test if goNorth still works for a house with one room in it. 
    Test if goNorth properly decrements larger than rooms.size() values to avoid a magical land
    */
    @Test
    public void testGoNorth() {
        House house = new House();
        house.rooms = Mockito.mock(LinkedList.class);
        when(house.rooms.size()).thenReturn(1);
        int result = house.goNorth();
        assertEquals(result,0);
        
        house.currentRoom = 50; 
        when(house.rooms.size()).thenReturn(10);
        result = house.goNorth();
        assertEquals(result,9);
    }
    /*
    Creates a new House object and checks if you can go south.
    GoSouth should decrement the currentroom counter by one every time 
    except in the case where it goes below zero then zero is returned
    */
    @Test
    public void testGoSouth() {
        House house = new House();
        int result = house.goSouth();
        assertEquals(result,0);
        
        house.currentRoom = 50;
        result = house.goSouth();
        assertEquals(result, 49);
    }
    /*
    Creates a new house object and checks if the items added are returned
    Also makes sure that when two items are added the currentRoom the newest
    added room is returned.
    Makes sure as well that you still return the same result if you go beyond 
    the room limit
    Test lookForItem. Should return the item in the current room.
    
    */
    @Test
    public void testLookForItem() {
        House house = new House();
        
        house.addRoom("", "", "coffee", "", "");
        String result = house.lookForItem();
        assertEquals(result, "coffee");
        
        house.addRoom("", "", "cream", "", "");
        result = house.lookForItem();
        assertNotEquals(result, "cream");
        
        house.goNorth();
        result = house.lookForItem();
        assertEquals(result, "cream");
    }
    /*
    Creates a new House object and tests if getDetails returns all details
    Tests getDetails. Should return the same array equal to the same input on
    addroom() minus the item.
    */
    @Test
    public void testGetDetails() {
        House house = new House();
        house.addRoom("A","B","C","D","E");
        String[] result = house.getDetails();
        Assert.assertArrayEquals(result,new String[]{"A","B","D","E"});        
    }

    
}
