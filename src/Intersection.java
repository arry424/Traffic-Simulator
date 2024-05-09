
import java.util.ArrayList;
import java.util.Queue;
public class Intersection {
    private ArrayList[] lanes;
    private TrafficLight trafficLightHorizontal;
    private TrafficLight trafficLightVertical;

    public Intersection(){
        lanes = new ArrayList[4];
        for(int i = 0; i < lanes.length; i++)
            lanes[i]  = new ArrayList<Queue<Car>>();
        trafficLightHorizontal = new TrafficLight();
        trafficLightVertical = new TrafficLight();
    }
}
