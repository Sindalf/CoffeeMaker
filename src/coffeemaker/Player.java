package coffeemaker;
 
import java.util.HashMap;

public class Player {
    String[] inventory;
    String[] truth;
    HashMap answers = new HashMap();
    public Player() {
        inventory = new String[3];
        truth = new String[3];
        inventory[0] = "no coffee";
        inventory[1] = "no cream";
        inventory[2] = "no sugar";
        truth[0] = "0";
        truth[1] = "0";
        truth[2] = "0";
        populateMap(answers);
    }
                    
    public int addItem(String item) {
        if(item.equals("coffee")) {
            inventory[0] = "a cup of delicious coffee.";
            truth[0] = "1";
            return 1;
        }
        else if(item.equals("cream")) {
            inventory[1] = "some fresh cream.";
            truth[1] = "1";
            return 1;
        }
        else if(item.equals("sugar")) {
            inventory[2] = "some tasty sugar.";
            truth[2] = "1";
            return 1;
        }
        return 0;
    }

    public int checkInventory() {
        for(int i = 0; i < inventory.length; i++) {
            System.out.println("You have " + inventory[i]);
        }
        return 1;
    }
    
    public String checkWin() {
        String result = truth[0] + truth[1] + truth[2];
        System.out.println(answers.get(result));
        if(result.equals("111")) {
            System.out.println("You win!");
        }
        else {
            System.out.println("You lose!");
        }
        return "true";
    }
    
    private void populateMap(HashMap answers) {
        answers.put("000", "You drink the air, as you have no coffee, sugar, or cream.\n" +
        "The air is invigorating, but not invigorating enough.  You cannot study");
        
        answers.put("010", "You drink the cream, but without caffeine, you cannot study");
        answers.put("100", "Without cream, you get an ulcer and cannot study.");
        answers.put("001", "You eat the sugar, but without caffeine, you cannot study.");
        
        answers.put("110", "Without sugar, the coffee is too bitter.  You cannot study.");
        answers.put("011", "You drink the sweetened cream, but without caffeine, you cannot study.");
        answers.put("101", "Without cream, you get an ulcer and cannot study.");
        
        answers.put("111", "You drink the beverage and are ready to study!");
    }
}
