public class Hotel extends Accommodation {
    private String whichRoom;

    public Hotel(String roomNumber, String whichRoom, double pricePerNight) {
        super(roomNumber, "Hotel Room", pricePerNight);
        this.whichRoom = whichRoom;
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Number: " + getRoomNumber());
        System.out.println("Type: " + getRoomType());
        System.out.println("Which Room: " + whichRoom);
        System.out.println("Price per night: $" + getPricePerNight());
        System.out.println("Availability: " + (isAvailable() ? "Available" : "Unavailable"));
    }
}
