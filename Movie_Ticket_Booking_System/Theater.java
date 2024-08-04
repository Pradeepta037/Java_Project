public class Theater {
    private String name;
    private int totalSeats;
    private boolean[] seats; // true for booked, false for available

    public Theater(String name, int totalSeats) {
        this.name = name;
        this.totalSeats = totalSeats;
        this.seats = new boolean[totalSeats];
    }

    public String getName() {
        return name;
    }

    public boolean bookSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > totalSeats || seats[seatNumber - 1]) {
            return false; // Seat not available
        }
        seats[seatNumber - 1] = true;
        return true;
    }

    public void viewSeats() {
        for (int i = 0; i < totalSeats; i++) {
            System.out.print((seats[i] ? "X" : "O") + " ");
        }
        System.out.println();
    }
}
