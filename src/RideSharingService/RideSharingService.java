package RideSharingService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RideSharingService {
    private static RideSharingService instance;
    private final Map<String,Driver> drivers;
    private final Map<String,Trip> trips;
    private final Map<String,Rider> rider;



    public RideSharingService()
    {
        this.drivers=new ConcurrentHashMap<>();
        this.trips=new ConcurrentHashMap<>();
        this.rider =new ConcurrentHashMap<>();

    }


    // creating singelton instance
    public static synchronized RideSharingService getInstance()
    {
        if(instance==null) {
            return instance=new RideSharingService();
        }
        return instance;
    }
    public Driver registerDriver(String name,String contact,String licencePlate,Location location)
    {
        Driver driver =new Driver(name,contact,licencePlate);
        drivers.put(driver.getId(),driver);
        return driver;
    }
    public Rider registerRider(String name ,String contact)
    {
        Rider rider =new Rider(name,contact);
        this.rider.put(rider.getId(),rider);
        return rider;

    }
    public void updateDriverLocation(String driverId,Location location) throws Exception {
        Driver driver =drivers.get(driverId);
        if(driver!=null)
        {
            driver.updateLocation(location);
        }
        else throw new Exception("Driver Not found");

    }
    public synchronized  void  requestRide(String riderId,Location from,Location to) throws Exception
    {
        Rider ridr =rider.get(riderId);
        if(ridr!=null) throw new Exception("rider not found");
//        Trip trip =new Trip(ridr,from ,to);
//
     //   notifyNearbyDrivers(trip);

    }
    private void notifyNearbyDrivers(Trip trip) throws Exception
    {
        boolean foundNearByAvailableDriver=false;
        for(Driver driver :drivers.values()){
            if(driver.isAvailable())
            {
                double distance =trip.getOrigin().distanceTo(driver.getLocation());
                if(distance<=15.0)
                {
                    foundNearByAvailableDriver=true;
                    System.out.println("Notifying driver "+dirver.getName()+" about ride request"+trip.getId());
                  return ;
                }
            }
        }
        if(!foundNearByAvailableDriver)
        {
            throw new Exception("No available driver");
        }
    }
    public void notifyRider(Trip trip)
    {
        User  user =trip.getRider();
        String message=
                switch(trip.getStatus())
                {
                    case REQUESTED -> "Ride isin progress";
                    case COMPLETED -> "Ride is completed";
                    default -> "";
                };
        //send notification to rider or customer
        System.out.println("Notigying rider: "+user.getName()+"-"+message);

    }
    public double calculateFare(Trip trip)
    {
        double baseFare=2.0;
        double perKmFare=1.5;
        double distance =trip.getOrigin().distanceTo(trip.getDestination());
        double fare =baseFare+(distance*perKmFare);
        return  Math.round(fare*100.0)/100.0; // round to 2 decimal place;
    }

    public void acceptRide(String driverId,String tripid)
    {
        Driver driver=drivers.get(driverId);
        Trip trip =trips.get(tripid);
        if(trip.getStatus()==TripStatus.REQUESTED)
        {
            Rider rider =trip.getRider();
//            (driver);
        }
    }
    public void startRider(String tripId)
    {
        Trip trip =trips.get(tripId);
        if(trip.getStatus()==TripStatus.ACCEPTED)
        {
            trip.setTripStatus(TripStatus.INPROGRESS);
            notifyRider(trip);
        }
    }
    public synchronized void completeRide(String tripId)
    {
        Trip trip=trips.get(tripId);
        if(trip.getStatus()==TripStatus.INPROGRESS)
        {
            trip.setTripStatus(TripStatus.COMPLETED);
            double fare =calculateFare(trip);
            trip.setFare(fare);
            notifyRider(trip);
//            notifyNearbyDrivers();
            System.out.printf("Trip %s completed %n",trip.getId());
        }
    }
    public void notifyDriver(Trip trip)
    {
        Driver driver =trip.getDriver();
        if(driver!=null)
        {
            String message=switch(trip.getStatus())
            {
                case COMPLETED -> "Ride completed. Fare :$ "+trip.getFare();
                case CANCELLED ->  "Ride cancelled by passenger";
                default ->"";
            };
            System.out.println("Notify driver successfully");

        }
    }
    public void cancelRide(String tripId){
        Trip trip =trips.get(tripId);
//        if(trip.getStaus())

    }

}
