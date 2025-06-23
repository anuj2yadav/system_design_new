package RideSharingService;

public class Driver  extends User{
    private final String licenceNumber;

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    private Location location;
    private DriverStatus status;
    private Trip currentTrip;

    public Driver(String name, String contact,String licenceNumber) {
        super(name, contact);
        this.licenceNumber=licenceNumber;
        this.status=DriverStatus.AVAILABLE;
    }
    public synchronized void updateLocation(Location location)
    {
        this.location=location;//  call the api to get the current driver

    }
    public Location getCurrentLocation()
    {
        Location location =new Location(434,43435);
        // user api to get the location
        updateLocation(location);
        return location;
    }
    public boolean isAvailable()
    {
        return this.status==DriverStatus.AVAILABLE;
    }
    public synchronized void assignTrip(Trip trip) throws Exception {
        if (DriverStatus.BUSY == this.status) {
            throw new Exception("Chose Another Driver");

        }
        this.currentTrip=trip;
        this.status=DriverStatus.BUSY;
    }
    public synchronized void completeTrip()
    {
        this.currentTrip=null;
        this.status=DriverStatus.AVAILABLE;
    }
}
