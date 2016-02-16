package coffeemaker;

import java.io.IOException;
import java.util.Scanner;

public class CoffeeMaker {

    
    public static void main(String[] args) throws IOException {
        System.out.println("gdh12 Coffee Maker Quest 1.0");
        String[] descriptions = {"Small", "Funny", "Refinanced", "Dumb", "Bloodthirsty", "Rough"}; 
        String[] uniqueItems = {"Quaint sofa", "Sad record player", "Tight pizza", "Flat energy drink", "Beautiful bag of money", "Perfect air hockey table"};
        String[] items = {"cream", null, "coffee", null, null, "sugar"};
        String[] doors = {null, "Magenta", "Massive", "Beige", "Smart", "Dead", "Slim", "Vivacious", "Sandy", "Purple", "Minimalist", null};
        
        Game game = new Game(descriptions, uniqueItems, items, doors);
        gameLoop(game, false);
    }
    
    public static String gameLoop(Game game, boolean end) {
        while(end != true) {
            String[] details = getDetails(game);
            System.out.println();
            displayDetails(details);
            showInstructions();
            String input = getInput();
            String result = inputHandler(game, input);
            end = Boolean.parseBoolean(result);
        }
        return "end";
    }
    
    public static String getInput() {
        Scanner scan = new Scanner(System.in);
        String result = scan.nextLine();
        return result;
    }
    
    public static String[] getDetails(Game game) {
        return game.getCurrentRoom();
    }
    
    public static String inputHandler(Game game, String input) {
        return game.handleInput(input);
    }
    
    public static void showInstructions() {
        System.out.println(" INSTRUCTIONS (N,S,L,I,D,H) >");
    }
    
    public static void displayDetails(String[] details) {
        System.out.println("You see a " + details[0] + " room");
        System.out.println("It has a " + details[1]);
            
        if(details[2] != null) {
            System.out.println("A " + details[2] + " door leads south");
        }
        if(details[3] != null) {
            System.out.println("A " + details[3] + " door leads north");
        }
    }
}
