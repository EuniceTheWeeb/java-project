import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Accommodation> accommodations = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {

        accommodations.add(new Hotel("H101", "Queen bed for 2", 120));
        accommodations.add(new Hotel("H102", "Twin single beds", 140));
        accommodations.add(new Hotel("H103", "2 queen beds", 100));
        accommodations.add(new Hotel("H104", "4 single beds", 110));
        accommodations.add(new Chalet("C101", "Forest View", 175));
        accommodations.add(new Chalet("C102", "Sea View", 200));

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
                System.out.println("----------");
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
                System.out.println("----------");
            }
        }
    }

    private static void addReservation(Scanner scanner) {
        System.out.print("Enter guest name: ");
        scanner.nextLine();
        String guestName = scanner.nextLine();
    
        displayAvailableAccommodations();
        System.out.print("Enter room number to book: ");
        String roomNumber = scanner.nextLine().toLowerCase();
    
        Accommodation selectedAccommodation = null;
        for (Accommodation acc : accommodations) {
            if (acc.getRoomNumber().toLowerCase().equals(roomNumber) && acc.isAvailable()) {
                selectedAccommodation = acc;
                break;
            }
        }
    
        if (selectedAccommodation != null) {
            System.out.print("Enter number of nights: ");
            int nights = scanner.nextInt();
    
            Reservation reservation = new Reservation(guestName, selectedAccommodation, nights);
            reservations.add(reservation);
            selectedAccommodation.bookRoom();
            System.out.println("Reservation made!");

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
    
                // Edit guest name
                System.out.print("Enter new guest name (leave empty if unchanged): ");
                String newGuestName = scanner.nextLine();
                if (!newGuestName.isEmpty()) {
                    res.setGuestName(newGuestName);
                }
    
                // Edit room num
                displayAvailableAccommodations();
                System.out.print("Enter new room number (leave empty if unchanged): ");
                String newRoomNumber = scanner.nextLine();
                if (!newRoomNumber.isEmpty()) {

                    Accommodation newAccommodation = null;
                    for (Accommodation acc : accommodations) {
                        if (acc.getRoomNumber().toLowerCase().equals(newRoomNumber) && acc.isAvailable()) {
                            newAccommodation = acc;
                            break;
                        }
                    }
    
                    if (newAccommodation != null) {
                        res.getAccommodation().releaseRoom();
                        res.setAccommodation(newAccommodation);
                        newAccommodation.bookRoom();
                    } else {
                        System.out.println("New room not available.");
                    }
                }
    
                // Edit number of nights
                System.out.print("Enter new number of nights (leave empty if unchanged): ");
                String nightsInput = scanner.nextLine();
                if (!nightsInput.isEmpty()) {
                    try {
                        int newNights = Integer.parseInt(nightsInput);
                        res.setNights(newNights);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number of nights. Please enter a valid number.");
                    }
                }
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
                res.getAccommodation().releaseRoom();
                reservations.remove(res);
                System.out.println("Reservation deleted for " + guestName);
                return;
            }
        }
        System.out.println("No reservation found for that guest.");
    }
    
}
