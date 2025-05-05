package movieBooking;

import java.util.List;

public class Theatre {
    private final String theatreId;
    private final String name;
    private final String location;
    private final List<Show> shows;

    public Theatre(String theatreId, String name, String location, List<Show> shows) {
        this.theatreId = theatreId;
        this.name = name;
        this.location = location;
        this.shows = shows;
    }
}
