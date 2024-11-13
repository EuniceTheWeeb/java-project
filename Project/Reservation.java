public class Reservation {
    private String guestName;
    private Accommodation accommodation;
    private int nights; 

    public Reservation(String guestName, Accommodation accommodation, int nights) {
        this.guestName = guestName;
        this.accommodation = accommodation;
        this.nights = nights;
    }

    public String getGuestName() {
        return guestName;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public int getNights() {
        return nights;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public double calculateTotalCost() {
        return accommodation.getPricePerNight() * nights;
    }

    public void displayReservationDetails() {
        System.out.println("Guest: " + guestName);
        System.out.println("Accommodation: " + accommodation.getRoomType() + " (Room: " + accommodation.getRoomNumber() + ")");
        System.out.println("Nights: " + nights);
        System.out.println("Price per night: $" + accommodation.getPricePerNight());
        System.out.println("Total cost: $" + calculateTotalCost());
    }
}
