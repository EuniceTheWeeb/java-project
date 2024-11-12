public class Chalet extends Accommodation {
    private String view;

    public Chalet(String roomNumber, String view) {
        super(roomNumber, "Chalet");
        this.view = view;
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Number: " + getRoomNumber());
        System.out.println("Type: " + getRoomType());
        System.out.println("View: " + view);
        System.out.println("Availability: " + (isAvailable() ? "Available" : "Unavailable"));
    }
}
