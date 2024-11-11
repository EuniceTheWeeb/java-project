package Project;

import java.util.Scanner;
import java.util.ArrayList;

public class hotels extends Main {
    private String roomType;
    private boolean canSmoke;
    private int totalRooms;
    private ArrayList<Room> rooms;

    public hotels() {
        super();
        roomType = "N/A";
        canSmoke = false;
        totalRooms = 0;
        rooms = new ArrayList<>();
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isCanSmoke() {
        return canSmoke;
    }

    public void setCanSmoke(boolean canSmoke) {
        this.canSmoke = canSmoke;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public hotels(String roomType, boolean canSmoke, int totalRooms, ArrayList<Room> rooms) {
        this.roomType = roomType;
        this.canSmoke = canSmoke;
        this.totalRooms = totalRooms;
        this.rooms = rooms;
    }

    

    
}
