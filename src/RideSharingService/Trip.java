package RideSharingService;

import java.util.UUID;

public class Trip {
    private final String id;
    private Driver driver;

    public Rider getRider() {
        return rider;
    }

    private final Rider rider;
    private final Location origin;
    private final Location destination;
    private TripStatus status;

    public void setTripStatus(TripStatus tripStatus)
    {
        this.status=tripStatus;
    }
    private PaymentStatus paymentStatus;
    private double fare;

    public void setFare(double fare)
    {
        this.fare=fare;
    }

    public String getId() {
        return id;
    }

    public Driver getDriver() {
        return driver;
    }


    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }

    public TripStatus getStatus() {
        return status;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public double getFare() {
        return fare;
    }

    public void getCompleted() {
        return ;
    }

    public Trip(Driver driver ,Rider rider, Location origin, Location destination)
    {
        this.id= UUID.randomUUID().toString();
        this.driver=driver;
        this.origin=origin;
        this.rider=rider;
        this.destination=destination;
        this.status=TripStatus.REQUESTED;
        this.paymentStatus=PaymentStatus.PENDING;

    }
    private synchronized void completed()
        {
        this.status=TripStatus.COMPLETED;
    }
    public void markPayment()
    {
       this.paymentStatus=PaymentStatus.COMPLETED;
    }


}
