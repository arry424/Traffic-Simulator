import java.awt.*;
import java.util.ArrayList;
public class Lane {
    private ArrayList<Car> carLane;
    private int totalWait;
    public Lane(){
        carLane = new ArrayList<Car>();
        totalWait = 0;
    }

    public int getTotalWait(){
        totalWait = 0;
        for (Car car : carLane) {
            totalWait += car.getWaitTime();
        }
        return totalWait;
    }

    public void addCar(Car c){
        carLane.add(c);
    }

    public int getSize(){
        return carLane.size();
    }

    public void removeCar(){
        carLane.remove(0);
    }

    public Car getCar(int i){

            return carLane.get(i);

    }

    //graphics stuff
    public void drawSelfUp(Graphics g){}

    public void drawSelfDown(Graphics g){}

    public void drawSelfLeft(Graphics g){}

    public void drawSelfRight(Graphics g){}
}
