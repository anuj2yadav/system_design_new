package TrafficSignal;

import TrafficSignal.Directions;
import TrafficSignal.SignalState;
import TrafficSignal.TrafficLight;
import TrafficSignal.TrafficSignalController;

public class YellowState implements SignalState {
    @Override
    public void handle(TrafficLight light, TrafficSignalController controller, Directions direction) {
        System.out.println("Direction: "+direction+" |State:Green");
        int duration=controller.getSignalDuration(direction,this);
        controller.scheduleStateChange(light,new GreenState(),duration);
    }

    @Override
    public String getName() {
        return "Green State";
    }
}