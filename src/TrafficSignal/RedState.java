package TrafficSignal;

public class RedState implements SignalState{

    @Override
    public void handle(TrafficLight light, TrafficSignalController controller, Directions direction) {
        System.out.println("Directions: "+ direction +" |State:Red");
        int duration=controller.getSignalDuration(direction,this);
        //After red mpve to next direction's green
        Directions newDirection =controller.getNextDirection(direction);
        controller.scheduleStateChange(controller.getTrafficLight(direction),new GreenState(),duration);

    }

    @Override
    public String getName() {
        return "Red Light";
    }
}
