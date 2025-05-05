package movieBooking.Exceptions;

public class SeatsNotAvailable extends Exception{
    public SeatsNotAvailable(String message) {
        super(message);
    }
}
