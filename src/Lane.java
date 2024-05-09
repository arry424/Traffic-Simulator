import java.util.LinkedList;
import java.util.Queue;
public class Lane {
    private Queue<Car> lanes;
    private int totalWait;
    public Lane(){
        lanes = new LinkedList<Car>();
        totalWait = 0;
    }

    public void addWaitTime(int w){
        totalWait += w;
    }

    public int getTotalWait(){
        return totalWait;
    }

    public void addCar(Car c){
        lanes.add(c);
    }

    public int getSize(){
        return lanes.size();
    }
}
