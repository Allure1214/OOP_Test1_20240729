import java.util.ArrayList;
import java.util.Random;

public class Passenger {
    private String name;
    private String passportNumber;
    private String email;
    private String phoneNumber;
    private ArrayList<Reservation> reservations;

    public Passenger(String name, String passportNumber, String email, String phoneNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.reservations = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Reservation createReservation(Flight flight, Seat seat) {
        if (seat.isAvailable()) {
            String reservationID = generateRandomString(10);
            Reservation reservation = new Reservation(reservationID, this, seat, flight);
            reservations.add(reservation);
            seat.setAvailability(false); // Mark the seat as booked
            return reservation;
        } else {
            // Seat is not available
            return null;
        }
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }
}
