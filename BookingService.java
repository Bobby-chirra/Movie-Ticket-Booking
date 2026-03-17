import java.util.*;

public class BookingService {

    private List<Theater> theaters = new ArrayList<>();

    // Thread-safe map
    private Map<String, List<String>> userBookings = Collections.synchronizedMap(new HashMap<>());

    public void addTheater(Theater theater) {
        theaters.add(theater);
    }

    public List<Theater> getTheaters() {
        return theaters;
    }

public void bookTicket(String username, Theater theater, Show show, String seat) throws BookingException {

    show.bookSeat(seat);

    String details = "Theater: " + theater.getName() +
            ", Movie: " + show.getMovieName() +
            ", Time: " + show.getTime() +
            ", Seat: " + seat;

    userBookings.putIfAbsent(username, new ArrayList<>());
    userBookings.get(username).add(details);

    System.out.println("✅ Booking successful!");

    FileHandler.saveBooking(username + " -> " + details);
}

    public void showUserBookings(String username) {

        List<String> list = userBookings.get(username);

        if (list == null || list.isEmpty()) {
            System.out.println("No bookings found!");
            return;
        }

        System.out.println("\nYour Bookings:");
        for (String s : list) {
            System.out.println(s);
        }
    }
}