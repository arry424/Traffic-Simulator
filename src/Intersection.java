
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class Intersection {
    private ArrayList<Queue<Car>>[] lanes;
    private TrafficLight trafficLightHorizontal;
    private TrafficLight trafficLightVertical;

    /**
     * The intersection is represented by an array of lists of queues
     * Each spot in the array is one of the four directions, and each list
     * holds queues that represent each lane that stores the cars
     *
     * 0 and 2 are the verticals (0 is top, 2 is bottom)
     * 1 and 3 are the horizontals (1 is left, 3 is right)
     */
    public Intersection(){
        lanes = new ArrayList[4];
        for(int i = 0; i < lanes.length; i++) {
            lanes[i] = new ArrayList<Queue<Car>>();
            for(int j = 0; j < 2; j++){
                lanes[i].add(new LinkedList<Car>());
            }
        }
        trafficLightHorizontal = new TrafficLight();
        trafficLightVertical = new TrafficLight();
    }

    public void run(){
        int time = 0;
        while(time<1000){

            int percentCar = (int)(Math.random()*100+1);
            if(percentCar <= 30){
                int dir = (int)(Math.random()*4);
                int lane = (int)(Math.random() * lanes[dir].size());
                lanes[dir].get(lane).add(new Car());
            } // adds a car to a random direction and a random lane in that direction

            if(trafficLightVertical.getLight() == 3){ //green

            }

            if(trafficLightHorizontal.getLight() == 3){//green

            }

            time++;
        }
    }
}
