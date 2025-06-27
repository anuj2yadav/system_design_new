package TrafficSignal;

public class TrafficLight {
    private SignalState state;
    private final Directions direction;
    public TrafficLight(Directions direction){
        this.direction=direction;
        this.state =new RedState();
    }
    public SignalState getState() {
        return state;
    }

    public void setState(SignalState state) {
        this.state = state;
    }

    public Directions getDirection() {
        return direction;
    }

    public void handle(TrafficSignalController controller)
    {
        state.handle(this,controller,direction);
    }

}
