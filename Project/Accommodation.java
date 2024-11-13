public abstract class Accommodation {
    private String roomNumber;
    private String roomType;
    private boolean isAvailable;
    private double pricePerNight;  // Price for 1 night

    public Accommodation(String roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true;  // Default: Available
        this.pricePerNight = pricePerNight;
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

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
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
