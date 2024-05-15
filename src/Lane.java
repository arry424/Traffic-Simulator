import java.awt.*;
import java.util.ArrayList;
public class Lane {
    private ArrayList<Car> carLane;
    private int totalWait;
    private boolean isGreen;
    public Lane(){
        carLane = new ArrayList<Car>();
        totalWait = 0;
        isGreen=false;
    }

    public boolean getIsGreen(){return isGreen;}
    public void setIsGreen(boolean a){isGreen = a;}

    public int getTotalWait(){
        totalWait = 0;
        for (Car car : carLane) {
            totalWait += car.getWaitTime();
        }
        return totalWait;
    }

    public void addCar(Car c,int dir, int lane){
        if(dir == 0){
            c.setYLoc(800);
            c.setXLoc(425 + lane*45);}
        if(dir == 2){
            c.setYLoc(0);
            c.setXLoc(375 - lane*45);}
        if(dir == 1){
            c.setXLoc(800);
            c.setYLoc(375 - lane*45);}
        if(dir == 3){
            c.setXLoc(0);
            c.setYLoc(425 + lane*45);}

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
    public void drawSelfUp(Graphics g,int laneNum){
        if(isGreen)
            for(Car c: carLane){
                c.moveUp();
            }
        for(Car c: carLane)
            c.drawUp(g, laneNum);
    }

    public void drawSelfDown(Graphics g, int laneNum){
        if(isGreen)
            for(Car c: carLane){
                c.moveDown();
            }
        for(Car c: carLane)
            c.drawDown(g, laneNum);
    }

    public void drawSelfLeft(Graphics g, int laneNum){
        if(isGreen)
            for(int i = 0; i< carLane.size(); i++){
                carLane.get(i).moveLeft();
            }
        for(Car c: carLane)
            c.drawLeft(g, laneNum);
    }

    public void drawSelfRight(Graphics g, int laneNum){
        if(isGreen)
            for(int i = 0; i< carLane.size(); i++){
                carLane.get(i).moveRight();
            }
        for(int i = 0; i< carLane.size(); i++)
            carLane.get(i).drawRight(g, laneNum);
    }
}
