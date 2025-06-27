package TrafficSignal;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TrafficSignalDemo {

    public static void main(String [] args) {
        Map<Directions, Map<String, Integer>> signalDurations =
                new EnumMap<Directions, Map<String, Integer>>(Directions.class);
        signalDurations.put(Directions.NORTH, Map.of("GREEN", 4, "YELLOW", 2, "RED", 3));
        signalDurations.put(Directions.SOUTH, Map.of("GREEN", 3, "YELLOW", 2, "RED", 4));
        signalDurations.put(Directions.EAST, Map.of("GREEN", 5, "YELLOW", 2, "RED", 3));
        signalDurations.put(Directions.WEST, Map.of("GREEN", 2, "YELLOW", 2, "RED", 5));

        // Initilaize
    }

}

