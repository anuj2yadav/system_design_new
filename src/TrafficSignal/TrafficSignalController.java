package TrafficSignal;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrafficSignalController {
    private final Map<Directions,TrafficLight> signals;
    private final Map<Directions,Map<String,Integer>> signalDurations;
    private final ScheduledExecutorService scheduler= Executors.newSingleThreadScheduledExecutor();

    public TrafficSignalController(Map<Directions, TrafficLight> signals, Map<Directions, Map<String, Integer>> signalDurations) {
        this.signals = signals;
        this.signalDurations = signalDurations;
    }
    public void start(Directions startDirection)
    {
        TrafficLight light=signals.get(startDirection);
        light.setState(new GreenState());
        light.handle(this);
    }
    public void scheduleStateChange(TrafficLight light,SignalState nextState,int delaySeconds)
    {
        scheduler.schedule(()->{
            light.setState(nextState);
            light.handle(this);

        },delaySeconds, TimeUnit.SECONDS);
    }
    public int getSignalDuration(Directions direction ,SignalState state)
    {
        return signalDurations.get(direction).get(state.getName());
    }
    public TrafficLight getTrafficLight(Directions direction){
        return signals.get(direction);
    }
    public void manualOverrride(Directions direction){
        TrafficLight light =signals.get(direction);
        light.setState(new GreenState());
        light.handle(this);

    }

    public Directions getNextDirection(Directions currentDirection) {
       Directions [] direction=Directions.values();
       int nextDirection =(currentDirection.ordinal()+1)%direction.length;
       return direction[nextDirection];
    }
}
