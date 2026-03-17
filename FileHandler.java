import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    public static void saveBooking(String data) {
        try (FileWriter writer = new FileWriter("bookings.txt", true)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            System.out.println("Error saving booking: " + e.getMessage());
        }
    }
}