import java.util.ArrayList;
public class Lane {
    private ArrayList<Car> lanes;
    private int totalWait;
    public Lane(){
        lanes = new ArrayList<Car>();
        totalWait = 0;
    }



    public int getTotalWait(){
        totalWait = 0;
        for (Car lane : lanes) {
            totalWait += lane.getWaitTime();
        }
        return totalWait;
    }

    public void addCar(Car c){
        lanes.add(c);
    }

    public int getSize(){
        return lanes.size();
    }

    public void removeCar(){
        lanes.remove(0);
    }

    public Car getCar(int i){

            return lanes.get(i);

    }
}
