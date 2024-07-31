import java.util.Scanner;

public class FlightReservationSystem {
    private Flight[] flights;
    private Reservation[] reservations;
    private int flightCount;
    private int reservationCount;

    public FlightReservationSystem(int flightCapacity, int reservationCapacity) {
        flights = new Flight[flightCapacity];
        reservations = new Reservation[reservationCapacity];
        flightCount = 0;
        reservationCount = 0;

        // Sample data
        addFlight(new Flight("AA101", "New York", "Los Angeles", 10));
        addFlight(new Flight("BB202", "Chicago", "Miami", 5));
    }

    public void addFlight(Flight flight) {
        if (flightCount < flights.length) {
            flights[flightCount++] = flight;
        } else {
            System.out.println("Flight capacity reached. Cannot add more flights.");
        }
    }

    public void addReservation(Reservation reservation) {
        if (reservationCount < reservations.length) {
            reservations[reservationCount++] = reservation;
        } else {
            System.out.println("Reservation capacity reached. Cannot add more reservations.");
        }
    }

    public void displayFlights() {
        System.out.println("Available Flights:");
        for (int i = 0; i < flightCount; i++) {
            System.out.println(flights[i]);
        }
    }

    public Flight findFlight(String flightNumber) {
        for (int i = 0; i < flightCount; i++) {
            if (flights[i].getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flights[i];
            }
        }
        return null;
    }

    public void makeReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Flight Number: ");
        String flightNumber = scanner.nextLine();
        Flight flight = findFlight(flightNumber);

        if (flight == null) {
            System.out.println("Flight not found.");
            return;
        }

        System.out.print("Enter Passenger Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Passport Number: ");
        String passportNumber = scanner.nextLine();

        Passenger passenger = new Passenger(name, passportNumber);
        Reservation reservation = new Reservation(flight, passenger);

        if (reservation.makeReservation()) {
            addReservation(reservation);
            System.out.println("Reservation successful!");
        } else {
            System.out.println("No available seats.");
        }
    }

    public static void main(String[] args) {
        FlightReservationSystem system = new FlightReservationSystem(10, 10); // Set initial capacities
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Display Flights");
            System.out.println("2. Make Reservation");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    system.displayFlights();
                    break;
                case 2:
                    system.makeReservation();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}