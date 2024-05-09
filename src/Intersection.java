
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class Intersection {
    private ArrayList<Lane>[] lanes;
    private ArrayList<Integer> waitList;
    private TrafficLight trafficLightHorizontal;
    private TrafficLight trafficLightVertical;
    private int prevTime = 0;
    private final int BAWKING_POINT = 10;
    private final int MAX_TIME = 500;

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
        waitList = new ArrayList<Integer>();
        for(int i = 0; i < lanes.length; i++) {
            lanes[i] = new ArrayList<Lane>();
            for(int j = 0; j < 2; j++){
                lanes[i].add(new Lane());
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
                lanes[dir].get(lane).addCar(new Car());
            } // adds a car to a random direction and a random lane in that direction

            if(trafficLightVertical.getLight() == 2){ //green
                if(needChange(time,1)){
                    trafficLightVertical.setLight(0);
                    trafficLightHorizontal.setLight(0);
                }
                removeCars(0);
                removeCars(2);

                addWaitTimes(1);
                addWaitTimes(3);
            }

            else if(trafficLightHorizontal.getLight() == 2){//green
                if(needChange(time,1)){
                    trafficLightHorizontal.setLight(0);
                    trafficLightVertical.setLight(2);
                }
                removeCars(1);
                removeCars(3);

                addWaitTimes(0);
                addWaitTimes(2);
            }

            time++;
        }
    }

    private boolean needChange(int time, int light){
        if(time - prevTime > MAX_TIME){
            return true;
        }
        if(light == 0){ //horizontal light
            if(getDirSize(0) + getDirSize(2) >= BAWKING_POINT){
                return true;
            }
            else if(getDirSize(0) + getDirSize(2) >= (BAWKING_POINT/2) && time-prevTime > (MAX_TIME/2)){
                return true;
            }
            else if(getDirWaitTime(0) + getDirWaitTime(2) > (BAWKING_POINT*(2/3))) {
                return true;
            }

        }
        if(light == 1){ //vertical light
            if(getDirSize(1) + getDirSize(3) >= BAWKING_POINT){
                return true;
            }
            else if(getDirSize(1) + getDirSize(3) >= (BAWKING_POINT/2) && time-prevTime > (MAX_TIME/2)){
                return true;
            }
            else if(getDirWaitTime(1) + getDirWaitTime(3) > (BAWKING_POINT*(2/3))) {
                return true;
            }
        }

        prevTime = time;
        return false; //TODO the rest of this method
    }
private int getDirSize(int dir){
        int output = 0;
        for(int i = 0; i < lanes[dir].size(); i++){
            output += lanes[dir].get(i).getSize();
        }
        return output;
}

private int getDirWaitTime(int dir){
    int output = 0;
    for(int i = 0; i < lanes[dir].size(); i++){
        output += lanes[dir].get(i).getTotalWait();
    }
    return output;
}

private void removeCars(int dir){
        for(int i = 0; i < lanes[dir].size(); i++){
            if(lanes[dir].get(i).getCar(0) != null) {
                waitList.add(lanes[dir].get(i).getCar(0).getWaitTime());
                lanes[dir].get(i).removeCar();
            }
        }
}

private void addWaitTimes(int lane){
        for(int j = 0; j < lanes[lane].size(); j++){
            for(int k = 0; k < lanes[lane].get(j).getSize(); k++)
                lanes[lane].get(j).getCar(k).addWaitTime(1);
        }
    }
public int getTotalWaitTime(){
        int output = 0;
        for(int i = 0; i < waitList.size(); i++){
            output += waitList.get(i);
        }
        return output;
}
}



