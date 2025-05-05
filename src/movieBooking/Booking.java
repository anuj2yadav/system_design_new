package movieBooking;

import movieBooking.seat.Seat;

import java.util.List;

public class Booking {
    private final String bookingId;
    private final Integer userID;
    private final Integer showId;
    private List<Seat> seats;
    private double totalPrice;
    private BookingStatus bookingStatus;

    public String getBookingId() {
        return bookingId;
    }

    public Integer getUserID() {
        return userID;
    }

    public Integer getShowId() {
        return showId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Booking(String bookingId, Integer userID, Integer showId,double totalPrice) {
        this.bookingId = bookingId;
        this.userID = userID;
        this.showId = showId;
        this.totalPrice=totalPrice;
    }
}
