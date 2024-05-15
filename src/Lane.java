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

    public Car removeCar(){
        Car temp = carLane.get(0);
        carLane.remove(0);
        return temp;
    }

    public Car getCar(int i){

            return carLane.get(i);

    }

    //graphics stuff
    public void drawSelfUp(Graphics g,int laneNum){
        if(isGreen)
            for (int i = 0; i < carLane.size(); i++) {
                carLane.get(i).moveUp();
            }
        else {
            for(int i = 0; i< carLane.size(); i++){
                if(carLane.get(i).getYLoc()  >= 500+ i*(100))
                    carLane.get(i).moveUp();
            }}
        for(Car c: carLane)
            c.drawUp(g, laneNum);
    }

    public void drawSelfDown(Graphics g, int laneNum){
            if (isGreen)
                for (int i = 0; i < carLane.size(); i++) {
                    carLane.get(i).moveDown();
                }
            else {
                for (int i = 0; i < carLane.size(); i++) {
                    if (carLane.get(i).getYLoc() <= 300 - i * (100))
                        carLane.get(i).moveDown();
                }}
                for (Car c : carLane)
                    c.drawDown(g, laneNum);
            }

            public void drawSelfLeft (Graphics g,int laneNum){
                if (isGreen)
                    for (int i = 0; i < carLane.size(); i++) {
                        carLane.get(i).moveLeft();
                    }
                else {
                    for (int i = 0; i < carLane.size(); i++) {
                        if (carLane.get(i).getXLoc()  >= 500+ i * (100))
                            carLane.get(i).moveLeft();
                    }}

                for (Car c : carLane)
                    c.drawLeft(g, laneNum);
            }

            public void drawSelfRight (Graphics g,int laneNum){
                if (isGreen)
                    for (int i = 0; i < carLane.size(); i++) {
                        carLane.get(i).moveRight();
                    }
                else {
                    for (int i = 0; i < carLane.size(); i++) {
                        if (carLane.get(i).getXLoc()  <= 300- i * (100))
                            carLane.get(i).moveRight();
                    }}
                    for (int i = 0; i < carLane.size(); i++)
                        carLane.get(i).drawRight(g, laneNum);
                }
            }
