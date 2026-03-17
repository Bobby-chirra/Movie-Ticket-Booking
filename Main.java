import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookingService service = new BookingService();

        // Create Theaters
        Theater t1 = new Theater("PVR");
        t1.addShow(new Show("Avengers", "10:00 AM", 5, 5));
        t1.addShow(new Show("Batman", "2:00 PM", 5, 5));

        Theater t2 = new Theater("INOX");
        t2.addShow(new Show("Interstellar", "1:00 PM", 5, 5));
        t2.addShow(new Show("Joker", "6:00 PM", 5, 5));

        service.addTheater(t1);
        service.addTheater(t2);

        // User
        System.out.print("Enter your name: ");
        String username = sc.nextLine();

        while (true) {
            System.out.println("\n==== MOVIE BOOKING SYSTEM ====");
            System.out.println("1. Book Ticket");
            System.out.println("2. View My Bookings");
            System.out.println("3. Exit");

            int choice = getSafeInt(sc);

            switch (choice) {

                case 1:
                    List<Theater> theaters = service.getTheaters();

                    // Select Theater
                    int tChoice;
                    while (true) {
                        for (int i = 0; i < theaters.size(); i++) {
                            System.out.println((i + 1) + ". " + theaters.get(i).getName());
                        }

                        System.out.print("Select Theater: ");
                        tChoice = getSafeInt(sc) - 1;

                        if (tChoice >= 0 && tChoice < theaters.size()) break;
                        System.out.println("❌ Invalid theater! Try again.");
                    }

                    Theater selectedTheater = theaters.get(tChoice);

                    // Select Show
                    List<Show> shows = selectedTheater.getShows();
                    int sChoice;

                    while (true) {
                        for (int i = 0; i < shows.size(); i++) {
                            Show s = shows.get(i);
                            System.out.println((i + 1) + ". " + s.getMovieName() + " - " + s.getTime());
                        }

                        System.out.print("Select Show: ");
                        sChoice = getSafeInt(sc) - 1;

                        if (sChoice >= 0 && sChoice < shows.size()) break;
                        System.out.println("❌ Invalid show! Try again.");
                    }

                    Show selectedShow = shows.get(sChoice);

                    // Seat Booking
                    while (true) {
                        selectedShow.displaySeats();

                        System.out.print("Enter Seat (e.g., A1, B3): ");
                        String seat = sc.next();
                        

                        try {
                            service.bookTicket(username, selectedTheater, selectedShow, seat);
                            break;
                        } catch (BookingException e) {
                            System.out.println("❌ " + e.getMessage());
                        }
                    }
                    break;

                case 2:
                    service.showUserBookings(username);
                    break;

                case 3:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    // ✅ SAFE INPUT METHOD
    private static int getSafeInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("❌ Please enter a valid number: ");
            sc.next(); // discard invalid input
        }
        return sc.nextInt();
    }
}