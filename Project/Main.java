import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Accommodation> accommodations = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        accommodations.add(new Hotel("H101", "Queen bed for 2"));
        accommodations.add(new Hotel("H102", "Twin single beds"));
        accommodations.add(new Hotel("H103", "2 queen beds"));
        accommodations.add(new Hotel("H104", "4 single beds"));
        accommodations.add(new Chalet("C101", "Forest View"));
        accommodations.add(new Chalet("C102", "Sea View"));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Display Available Accommodations");
            System.out.println("2. Display Reservations");
            System.out.println("3. Add a Reservation");
            System.out.println("4. Edit Reservation");
            System.out.println("5. Delete Reservation");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAvailableAccommodations();
                    break;
                case 2:
                    displayReservations();
                    break;
                case 3:
                    addReservation(scanner);
                    break;
                case 4:
                    editReservation(scanner);
                    break;
                case 5:
                    deleteReservation(scanner);
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void displayAvailableAccommodations() {
        System.out.println("\n---- Available Accommodations ----");
        for (Accommodation acc : accommodations) {
            if (acc.isAvailable()) {
                acc.displayRoomDetails();
            }
        }
    }

    private static void displayReservations() {
        System.out.println("\n---- Reservations ----");
        if (reservations.isEmpty()) {
            System.out.println("No reservations made.");
        } else {
            for (Reservation res : reservations) {
                res.displayReservationDetails();
            }
        }
    }

    private static void addReservation(Scanner scanner) {
        System.out.print("Enter guest name: ");
        scanner.nextLine();
        String guestName = scanner.nextLine();

        displayAvailableAccommodations();
        System.out.print("Enter room number to book: ");
        String roomNumber = scanner.nextLine();

        Accommodation selectedAccommodation = null;
        for (Accommodation acc : accommodations) {
            if (acc.getRoomNumber().equals(roomNumber) && acc.isAvailable()) {
                selectedAccommodation = acc;
                break;
            }
        }

        if (selectedAccommodation != null) {
            System.out.print("Enter check-in date (MM/dd/yyyy): ");
            String checkInString = scanner.nextLine();
            System.out.print("Enter check-out date (MM/dd/yyyy): ");
            String checkOutString = scanner.nextLine();

            try {
                Date checkInDate = new Date(checkInString);
                Date checkOutDate = new Date(checkOutString);

                Reservation reservation = new Reservation(guestName, selectedAccommodation, checkInDate, checkOutDate);
                reservations.add(reservation);
                selectedAccommodation.bookRoom();

                System.out.println("Reservation made!");
            } catch (Exception e) {
                System.out.println("Invalid date format.");
            }
        } else {
            System.out.println("Room not available.");
        }
    }

    private static void editReservation(Scanner scanner) {
        System.out.print("Enter guest name to edit: ");
        scanner.nextLine();
        String guestName = scanner.nextLine();

        for (Reservation res : reservations) {
            if (res.getGuestName().equalsIgnoreCase(guestName)) {
                System.out.println("Editing reservation for " + guestName);
                System.out.print("Enter new guest name: ");
                String newGuestName = scanner.nextLine();
                res.setGuestName(newGuestName);
                System.out.println("Reservation updated.");
                return;
            }
        }

        System.out.println("No reservation found for that guest.");
    }

    private static void deleteReservation(Scanner scanner) {
        System.out.print("Enter guest name to delete reservation: ");
        scanner.nextLine();
        String guestName = scanner.nextLine();

        for (Reservation res : reservations) {
            if (res.getGuestName().equalsIgnoreCase(guestName)) {
                accommodations.stream().filter(acc -> acc.getRoomNumber().equals(res.getAccommodation().getRoomNumber()))
                        .forEach(acc -> acc.releaseRoom());
                reservations.remove(res);
                System.out.println("Reservation deleted.");
                return;
            }
        }

        System.out.println("No reservation found for that guest.");
    }
}
