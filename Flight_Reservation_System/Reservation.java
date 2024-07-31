public class Reservation {
    private Flight flight;
    private Passenger passenger;

    public Reservation(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.passenger = passenger;
    }

    public boolean makeReservation() {
        return flight.bookTicket();
    }

    @Override
    public String toString() {
        return "Reservation [Flight: " + flight + ", Passenger: " + passenger.getName() + "]";
    }
}
