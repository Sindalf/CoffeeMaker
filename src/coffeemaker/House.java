package coffeemaker;

import java.util.LinkedList;

public class House {
    LinkedList<Room> rooms;
    
    int currentRoom;
    
    public House() {
        rooms = new LinkedList<Room>();
        currentRoom = 0;
    }
    
    public int addRoom(String description, String uniqueItem, String item, String southDoor, String northDoor) {
       rooms.add(new Room(description, uniqueItem, item, southDoor, northDoor));
       
       return 1; // Success
   }
   
    public String lookForItem() {
        return rooms.get(currentRoom).getItem();
    }
    
    public int goNorth() {
        currentRoom = currentRoom + 1;
        if(currentRoom >= rooms.size()) {
            currentRoom = rooms.size() - 1;
        }
        return currentRoom;
    }
    public int goSouth() {
        currentRoom = currentRoom - 1;
        if(currentRoom < 0) {
            currentRoom = 0;
        }
        return currentRoom;
    }
    
    public String[] getDetails() {
        String[] details = new String[4];
        Room room = rooms.get(currentRoom);
        details[0] = room.getDescription();
        details[1] = room.getUniqueItem();
        details[2] = room.getSouthDoor();
        details[3] = room.getNorthDoor();
        return details;
    }
}