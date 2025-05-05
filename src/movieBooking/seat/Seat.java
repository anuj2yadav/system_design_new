package movieBooking.seat;

public class Seat {
    private final String seatId;
    private  final int row;
    private final int column;
    private final SeatType seatType;
    private SeatStatus seatStatus;
    private final double price;

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public String getSeatId() {
        return seatId;
    }

    public double getPrice() {
        return price;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public Seat(String seatId, int row, int column, SeatType seatType,double price) {
        this.seatId = seatId;
        this.row = row;
        this.column = column;
        this.seatType = seatType;
        this.seatStatus=SeatStatus.AVAILABLE;
        this.price=price;
    }
}
