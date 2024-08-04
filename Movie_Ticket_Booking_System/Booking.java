public class Booking {
    private Movie movie;
    private Theater theater;

    public Booking(Movie movie, Theater theater) {
        this.movie = movie;
        this.theater = theater;
    }

    public boolean bookTicket(int seatNumber) {
        return theater.bookSeat(seatNumber);
    }

    public void viewTheaterSeats() {
        theater.viewSeats();
    }

    public String getMovieDetails() {
        return movie.toString();
    }
}
