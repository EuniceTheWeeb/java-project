public class Hotel extends Accommodation {
    private String whichRoom;

    public Hotel(String roomNumber, String whichRoom) {
        super(roomNumber, "Hotel Room");
        this.whichRoom = whichRoom;
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Number: " + getRoomNumber());
        System.out.println("Type: " + getRoomType());
        System.out.println("Which Room: " + whichRoom);
        System.out.println("Availability: " + (isAvailable() ? "Available" : "Unavailable"));
    }
}
