package movieBooking;

import movieBooking.seat.Seat;

import java.util.Map;

public class Show {
    private final String showId;
    private final Movie movie;
    private final Integer theatreId;
    private final Map<String, Seat> seats;

    public Movie getMovie() {
        return movie;
    }

    public Integer getTheatreId() {
        return theatreId;
    }

    public Map<String,Seat> getSeats() {
        return seats;
    }

    public String getShowId() {
        return showId;
    }

    public Show(String showId, Movie movie, Integer theatreId, Map<String, Seat> seats) {
        this.showId = showId;
        this.movie = movie;
        this.theatreId = theatreId;
        this.seats = seats;
    }
}
