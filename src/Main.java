import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create Seats
        ArrayList<Seat> seats = new ArrayList<>();
        seats.add(new Seat("1A", "Economy", true, null));
        seats.add(new Seat("1B", "Economy", true, null));
        seats.add(new Seat("1C", "Economy", false, null)); // already booked
        seats.add(new Seat("2A", "Business", true, null));
        seats.add(new Seat("2B", "Business", true, null));

        // Create a Flight
        Flight flight = new Flight("AA123", "JFK", "LAX", new Date(), new Date(), seats);

        // Assign Flight to Seats
        for (Seat seat : seats) {
            seat.setFlight(flight);
        }

        // Create a Passenger
        Passenger passenger = new Passenger("John Doe", "A12345678", "john.doe@example.com", "123-456-7890");

        // Find available seats
        ArrayList<Seat> availableSeats = flight.findAvailableSeats();
        System.out.println("Available seats:");
        for (Seat seat : availableSeats) {
            System.out.println("Seat Number: " + seat.getSeatNumber() + ", Class: " + seat.getSeatClass());
        }

        // Create a reservation
        Seat seatToBook = availableSeats.get(0); // Assuming we book the first available seat
        Reservation reservation = passenger.createReservation(flight, seatToBook);

        if (reservation != null) {
            System.out.println("Reservation successful! Reservation ID: " + reservation.getReservationID());
        } else {
            System.out.println("Reservation failed. Seat is not available.");
        }

        // Print reservation details
        System.out.println("Passenger: " + reservation.getPassenger().getName());
        System.out.println("Flight Number: " + reservation.getFlight().getFlightNumber());
        System.out.println("Seat Number: " + reservation.getSeat().getSeatNumber());
    }
}
