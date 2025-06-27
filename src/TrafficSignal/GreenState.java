package TrafficSignal;

public class GreenState implements SignalState{
    @Override
    public void handle(TrafficLight light, TrafficSignalController controller, Directions direction) {
        System.out.println("Direction: "+direction+" |State:Green");
        int duration=controller.getSignalDuration(direction,this);
        controller.scheduleStateChange(light,new YellowState(),duration);
    }

    @Override
    public String getName() {
        return "Green State";
    }
}
