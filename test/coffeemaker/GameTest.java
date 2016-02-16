
package coffeemaker;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
public class GameTest {
    
    String[] descriptions = {"Small", "Funny", "Refinanced", "Dumb", "Bloodthirsty", "Rough"}; 
    String[] uniqueItems = {"Quaint sofa", "Sad record player", "Tight pizza", "Flat energy drink", "Beautiful bag of money", "Perfect air hockey table"};
    String[] items = {"cream", null, "coffee", null, null, "sugar"};
    String[] doors = {null, "Magenta", "Massive", "Beige", "Smart", "Dead", "Slim", "Vivacious", "Sandy", "Purple", " Minimalist", null};

    /*
    Creates a mockHouse object and fills the house from the method in the Game object.
    
    */
    @Test
    public void testFillHouse() {
        House mockHouse = Mockito.mock(House.class);
        Game game = new Game(descriptions, uniqueItems, items, doors);
        int result = game.fillHouse(mockHouse);
        assertEquals(result,1);
    }
    
    /*
    Creates a Game object and tests various inputs.
    Tests all proper input and one incorrect input
    Tests .toLowerCase with "N"
    */
    @Test
    public void testHandleInput(){
        Game game = new Game(descriptions, uniqueItems, items, doors);
        game.house = Mockito.mock(House.class);
        
        assertEquals("n", game.handleInput("N"));
        assertEquals("n", game.handleInput("n"));
        assertEquals("s", game.handleInput("s"));
        assertEquals("i", game.handleInput("i"));
        assertEquals("h", game.handleInput("h"));
        
        when(game.house.lookForItem()).thenReturn("cream");
        assertEquals("cream", game.handleInput("l"));
        
        game.player = Mockito.mock(Player.class);
        
        when(game.player.checkWin()).thenReturn("true");
        assertEquals(true, Boolean.parseBoolean(game.handleInput("d")));
        
        assertNull(game.handleInput("q"));
    }
    
    /*
    Creates a game object and tests if the if statements in game.displayItem
    are being accessed properly given the proper item input
    */
    @Test
    public void testDisplayItem() {
        Game game = new Game(descriptions, uniqueItems, items, doors);
        
        assertEquals(game.displayItem(null), 0);
        assertEquals(game.displayItem("coffee"), 1);
        assertEquals(game.displayItem("cream"), 2);
        assertEquals(game.displayItem("sugar"), 3);
        assertEquals(game.displayItem("abcd"), -9999);
    }
    
    /*
    Creates a Game object and tests if the getCurrentRoom method returns an
    array of details about the current room.
    */
    @Test
    public void testCurrentRoom() {
        Game game = new Game(descriptions, uniqueItems, items, doors);
        game.house = Mockito.mock(House.class);
        
        when(game.house.getDetails()).thenReturn(new String[]{"a", "b", "c"});
        Assert.assertArrayEquals(new String[]{"a", "b", "c"}, game.getCurrentRoom());
    }

    
}
