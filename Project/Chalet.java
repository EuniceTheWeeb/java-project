public class Chalet extends Accommodation {
    private String view;

    public Chalet(String roomNumber, String view, double pricePerNight) {
        super(roomNumber, "Chalet", pricePerNight);
        this.view = view;
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Number: " + getRoomNumber());
        System.out.println("Type: " + getRoomType());
        System.out.println("View: " + view);
        System.out.println("Price per night: $" + getPricePerNight());
        System.out.println("Availability: " + (isAvailable() ? "Available" : "Unavailable"));
    }
}
