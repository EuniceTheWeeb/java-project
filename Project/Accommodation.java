
import java.util.Date;

public abstract class Accommodation {
    private String roomNumber;
    private String roomType;
    private boolean isAvailable;
    private Date checkInDate;
    private Date checkOutDate;

    public Accommodation(String roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true; // Default: Available
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public abstract void displayRoomDetails();
    
    public void bookRoom() {
        this.isAvailable = false;
    }

    // isAvailable becomes true again
    public void releaseRoom() {
        this.isAvailable = true;
    }
}
