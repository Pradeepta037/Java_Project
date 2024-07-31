import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(10, 20); // Initialize a hotel with 10 rooms and a maximum of 20 reservations
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Check Room Availability");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Show Available Rooms");
            System.out.println("5. Show Reservations");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter room number to check availability: ");
                    int roomNumber = scanner.nextInt();
                    System.out.println("Room " + roomNumber + " is " + (hotel.checkAvailability(roomNumber) ? "available" : "not available"));
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    LocalDate checkInDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());
                    if (hotel.bookRoom(roomNumber, guestName, checkInDate, checkOutDate)) {
                        System.out.println("Room booked successfully.");
                    } else {
                        System.out.println("Failed to book room. It might be unavailable or invalid.");
                    }
                    break;
                case 3:
                    System.out.print("Enter room number to cancel reservation: ");
                    roomNumber = scanner.nextInt();
                    hotel.cancelReservation(roomNumber);
                    System.out.println("Reservation cancelled.");
                    break;
                case 4:
                    hotel.showAvailableRooms();
                    break;
                case 5:
                    hotel.showReservations();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
