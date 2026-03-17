import java.util.*;

public class Show {

    private String movieName;
    private String time;
    private boolean[][] seats;

    public Show(String movieName, String time, int rows, int cols) {
        this.movieName = movieName;
        this.time = time;
        this.seats = new boolean[rows][cols];
    }

    // Convert A1 → [0][0]
    private int[] parseSeat(String seat) throws BookingException {
        if (seat.length() < 2) {
            throw new BookingException("Invalid seat format!");
        }

        char rowChar = Character.toUpperCase(seat.charAt(0));
        int row = rowChar - 'A';

        int col;
        try {
            col = Integer.parseInt(seat.substring(1)) - 1;
        } catch (NumberFormatException e) {
            throw new BookingException("Invalid seat number!");
        }

        if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
            throw new BookingException("Seat out of range!");
        }

        return new int[]{row, col};
    }

    // Thread-safe booking using seat name
    public synchronized void bookSeat(String seat) throws BookingException {
        int[] pos = parseSeat(seat);
        int row = pos[0];
        int col = pos[1];

        if (seats[row][col]) {
            throw new BookingException("Seat already booked!");
        }

        seats[row][col] = true;
    }

    // Display seats like A1 A2...
    public void displaySeats() {
        System.out.print("   ");
        for (int j = 0; j < seats[0].length; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            char rowLabel = (char) ('A' + i);
            System.out.print(rowLabel + "  ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTime() {
        return time;
    }
}