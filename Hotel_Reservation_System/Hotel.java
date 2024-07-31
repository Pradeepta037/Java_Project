import java.time.LocalDate;

public class Hotel {
    private Room[] rooms;
    private Reservation[] reservations;
    private int reservationCount;

    public Hotel(int numberOfRooms, int maxReservations) {
        rooms = new Room[numberOfRooms];
        reservations = new Reservation[maxReservations];
        reservationCount = 0;
        for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new Room(i + 1);
        }
    }

    public boolean checkAvailability(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room.isAvailable();
            }
        }
        return false;
    }

    public boolean bookRoom(int roomNumber, String guestName, LocalDate checkInDate, LocalDate checkOutDate) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                if (reservationCount < reservations.length) {
                    Reservation reservation = new Reservation(room, guestName, checkInDate, checkOutDate);
                    reservations[reservationCount++] = reservation;
                    return true;
                } else {
                    System.out.println("Reservation limit reached.");
                    return false;
                }
            }
        }
        return false;
    }

    public void cancelReservation(int roomNumber) {
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i].getRoom().getRoomNumber() == roomNumber) {
                reservations[i].cancel();
                // Shift reservations
                for (int j = i; j < reservationCount - 1; j++) {
                    reservations[j] = reservations[j + 1];
                }
                reservations[--reservationCount] = null; // Remove the last reservation
                break;
            }
        }
    }

    public void showAvailableRooms() {
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    public void showReservations() {
        for (int i = 0; i < reservationCount; i++) {
            System.out.println(reservations[i]);
        }
    }
}
