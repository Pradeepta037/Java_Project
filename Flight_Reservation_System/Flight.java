public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int availableSeats;

    public Flight(String flightNumber, String origin, String destination, int availableSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookTicket() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Flight Number: " + flightNumber + ", Origin: " + origin + ", Destination: " + destination + ", Available Seats: " + availableSeats;
    }
}
