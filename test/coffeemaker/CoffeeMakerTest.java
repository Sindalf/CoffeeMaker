/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeemaker;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;


public class CoffeeMakerTest {
    /*
    Creates a new output and tests if details are properly shown on screen.
    */
    @Test
    public void testDisplayDetails() throws IOException {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        
        CoffeeMaker.displayDetails(new String[]{"A","B","C","D"});
        String line = System.getProperty("line.separator");
        String result = "You see a A room" + line + "It has a B" + line +
                "A C door leads south" + line + "A D door leads north" + line;
        assertEquals(result, os.toString());
        os.close();
    }
    
    /*
    Testing that show instructions outputs the full instruction set
    */
    @Test
    public void testShowInstructions() throws IOException {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        CoffeeMaker.showInstructions();
        String line = System.getProperty("line.separator");
        String result = " INSTRUCTIONS (N,S,L,I,D,H) >" + line;
        assertEquals(result, os.toString());
    }
    
    /*
    Tests if the details added to a room are returned properly. 
    */
    @Test
    public void testGetDetails() {
        Game mockGame = Mockito.mock(Game.class);
        when(mockGame.getCurrentRoom()).thenReturn(new String[]{"A","B","C","D"});
        String[] result = CoffeeMaker.getDetails(mockGame);
        Assert.assertArrayEquals(result, new String[]{"A","B","C","D"});
    }
    
    /*
    Tests to make sure the input handler is handling input
    In this case we are going for the "what?" output by tossing in bad input.
    */
    @Test
    public void testInputHandler() {
        String input = "abc";
        Game mockGame = Mockito.mock(Game.class);
        when(mockGame.handleInput(input)).thenReturn(null);
        String result = CoffeeMaker.inputHandler(mockGame, input);
        assertNull(result);
    }
    
    /*
    Testing enter and exit of game loop
    */
    @Test
    public void testGameLoop() {
        Game mockGame = Mockito.mock(Game.class);
        String result = CoffeeMaker.gameLoop(mockGame, true);
        assertEquals(result, "end");
        
        when(mockGame.getCurrentRoom()).thenReturn(new String[]{"A","B","C","D"});
        when(CoffeeMaker.getInput()).thenReturn("d");
        result = CoffeeMaker.gameLoop(mockGame, false);
        assertEquals(result, "end");
    }
   
}
    

    

