import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Sample data
        Movie movie = new Movie("Inception", "Sci-Fi", "7:00 PM");
        Theater theater = new Theater("Cinema Hall 1", 10);
        Booking booking = new Booking(movie, theater);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. View Movie Details");
            System.out.println("2. View Theater Seats");
            System.out.println("3. Book a Seat");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Movie Details:");
                    System.out.println(booking.getMovieDetails());
                    break;
                case 2:
                    System.out.println("Theater Seats:");
                    booking.viewTheaterSeats();
                    break;
                case 3:
                    System.out.print("Enter seat number to book: ");
                    int seatNumber = scanner.nextInt();
                    if (booking.bookTicket(seatNumber)) {
                        System.out.println("Booking successful!");
                    } else {
                        System.out.println("Seat not available or invalid seat number.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
