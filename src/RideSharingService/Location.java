package RideSharingService;

public class Location {
    private final double latitude;
    private final double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public int distanceTo(Location location)
    {
        return 100; // write an api or fucntion to calculate the location from origin
    }
}
