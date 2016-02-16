package coffeemaker;


public class Game {
    House house;
    String[] descriptions; 
    String[] uniqueItems;
    String[] items;
    String[] doors;
    Player player;
    // String description, String uniqueItem, String item, String southDoor, String northDoor

    public Game(String[] descriptions, String[] uniqueItems, String[] items, String[] doors) {
        this.descriptions = descriptions;
        this.uniqueItems = uniqueItems;
        this.items = items;
        this.doors = doors;
        house = new House();
        fillHouse(house); 
        player = new Player();
    }
    
    public int fillHouse(House house) {
        int door = 0;
        for(int i = 0; i < descriptions.length; i++) {
            house.addRoom(descriptions[i], uniqueItems[i], items[i], doors[door], doors[door+1]);
            door = door + 2;
        }
        return 1;
    }
    
    public String[] getCurrentRoom() {
        return house.getDetails();
    }
    
    public String handleInput(String input) {
        input = input.toLowerCase();
        
        switch (input) {
            case "n":
                house.goNorth();
                return "n";
            case "s":
                house.goSouth();
                return "s";
            case "l":
                String item = house.lookForItem();
                displayItem(item);
                if(item != null) {
                    player.addItem(item);
                }
                return item;
            case "i":
                player.checkInventory();
                return "i";
            case "d":
                return player.checkWin();
            case "h":
                displayHelp();
                return "h";
            default:
                break;
        }
        System.out.println("What?");
        return null;
    }
   
    public int displayItem(String item) {
        if(item == null) {
            System.out.println("You don't see anything out of the ordinary.");
            return 0;
        }
        switch (item) {
            case "coffee":
                System.out.println("There might be something here... ");
                System.out.println("You found some caffeinated coffee!");
                return 1;
            case "cream":
                System.out.println("There might be something here... ");
                System.out.println("You found some creamy cream!");
                return 2;
            case "sugar":
                System.out.println("There might be something here... ");
                System.out.println("You found some sweet sugar!");
                return 3;
            default:
                return -9999;
        }
        
        
    }
    public void displayHelp() {
        System.out.println("You are a busy student who needs to study but you don't have any coffee! "
                + "Search the house to look for coffee ingredients. " +
                "When all ingredients have been found you can drink your coffee and start studying.");
        System.out.println("Enter N to go north");
        System.out.println("Enter S to go south");
        System.out.println("Enter L to look around the room");
        System.out.println("Enter I to check your inventory");
        System.out.println("Enter D to drink coffee, this ends the game win/lose");
    }
        
}
