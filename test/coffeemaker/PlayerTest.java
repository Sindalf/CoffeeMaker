package coffeemaker;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    
  /*
    System.getProperty("line.separator") is required in order for this to work
    on multiple systems. "/r/n" on windows, "/n" on unix/linux systems. 
    TESTED ON WINDOWS
    
    Tests if the data shown on screen is the same as the expected data. 
    Since multiple lines are shown at once it must be tested in bulk
    */
    @Test
    public void testCheckInventory() throws IOException {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        Player player = new Player();
        player.checkInventory();
        String line = System.getProperty("line.separator");
        String result = "You have no coffee" + line +
        "You have no cream" + line +
        "You have no sugar" + line;
        assertEquals(result , os.toString());
        
        player.inventory[0] = "a cup of delicious coffee.";
        player.inventory[1] = "some fresh cream.";
        player.inventory[2] = "some tasty sugar.";
        

        os.close();
        os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
      
        player.checkInventory();
        result = "You have a cup of delicious coffee." + line +
                "You have some fresh cream." + line +
                "You have some tasty sugar." + line;
        assertEquals(result, os.toString());
        
        os.close();
    }
    
    /*
    Tests the output for win and lose
    Only tests for a win and a total lose. 
    */
    @Test
    public void testWin() throws IOException {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        Player player = new Player();
        player.checkWin();
        String line = System.getProperty("line.separator");
        String result = "You drink the air, as you have no coffee, sugar, or cream.\n" + 
        "The air is invigorating, but not invigorating enough.  You cannot study" + line +
                "You lose!" + line;
        assertEquals(result, os.toString());
        os.close();
        
        os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        player.truth = new String[]{"1", "1", "1"};
        player.checkWin();
        result = "You drink the beverage and are ready to study!" + line + "You win!" + line;
        assertEquals(result, os.toString());
        os.close();
    }
    
    
    /*
    Testing if items get added properly to the player's inventory
    */
    @Test
    public void testAddItem() {
        Player player = new Player();
        assertEquals(1, player.addItem("coffee"));
        assertEquals(1, player.addItem("cream"));
        assertEquals(1, player.addItem("sugar"));
        assertEquals(0, player.addItem("foo"));
    }
}
