
import java.util.Date;

public class Reservation {
    private String guestName;
    private Accommodation accommodation;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(String guestName, Accommodation accommodation, Date checkInDate, Date checkOutDate) {
        this.guestName = guestName;
        this.accommodation = accommodation;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void displayReservationDetails() {
        System.out.println("Guest: " + guestName);
        System.out.println("Accommodation: " + accommodation.getRoomType() + " (Room: " + accommodation.getRoomNumber() + ")");
        System.out.println("Check-in: " + checkInDate);
        System.out.println("Check-out: " + checkOutDate);
    }
}
