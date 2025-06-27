package TrafficSignal;

public interface SignalState {
    void handle(TrafficLight light,TrafficSignalController controller,Directions direction);
    String getName();
}
