import java.util.*;

public class Theater {
    private String name;
    private List<Show> shows = new ArrayList<>();

    public Theater(String name) {
        this.name = name;
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }

    public String getName() {
        return name;
    }
}
