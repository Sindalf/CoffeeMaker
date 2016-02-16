package coffeemaker;

public class Room {
    
    String description;
    String uniqueItem;
    String item; //cream, sugar, coffee, null
    String northDoor;
    String southDoor;
    
    public Room(String description, String uniqueItem, String item, String southDoor, String northDoor) {
        this.description = description;
        this.uniqueItem = uniqueItem;
        this.item = item;
        this.southDoor = southDoor;
        this.northDoor = northDoor;
    }
    
    public String getItem() {
        return item;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getUniqueItem() {
        return uniqueItem;
    }
    
    public String getSouthDoor() {
        return southDoor;
    }
    
    public String getNorthDoor() {
        return northDoor;
    }
}
