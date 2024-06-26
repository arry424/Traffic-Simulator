
import java.awt.*;
import java.util.ArrayList;

public class Intersection {
    private ArrayList<Lane>[] lanes;
    private ArrayList<Integer> waitList;
    private TrafficLight trafficLightHorizontal;
    private TrafficLight trafficLightVertical;
    private int prevTime = 0;
    private boolean moveSprites;
    private DrawingPanel panel;
    private ArrayList<Car>[] offLanes;

    //private final int BALKING_POINT = 10; // used to be used as a check, but it never mattered to the output from what I can tell
    /**
     * The variables to mess with
     * Max time - how long can the combined number of cars at a red be waiting til it auto flips
     * Ratio  - for specific cases when the amount of cars waiting is 'Ratio times' more or less than those that can go
     *          - When the amount of cars waiting is less than 2, but the time collective waited is a ratio of the max time
     *          - When the amount of cars waiting is double the amount of cars driving, and the collective time waited is half the max time
     * Density - how many cars are showing up. For example, a density of 50 means there is a 50 percent chance a car shows up
     *           each of the add attempts. Currently, add is attempted 5 times.
     * numLanes - the number of lanes per direction
     */
    private final int MAX_TIME = 100;
    private final int RATIO = 2;
    private final int DENSITY = 50;
    private final int numLanes = 3;
    private final int turnChance = 50;

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
        offLanes = new ArrayList[4];
        waitList = new ArrayList<Integer>();

        panel = new DrawingPanel(800, 800);

        for(int i = 0; i < lanes.length; i++) {
            lanes[i] = new ArrayList<Lane>();
            offLanes[i] = new ArrayList<Car>();
            for(int j = 0; j < numLanes; j++){
                lanes[i].add(new Lane());
            }
        }
        trafficLightHorizontal = new TrafficLight();
        trafficLightVertical = new TrafficLight(2);
        setIsGreen(0,true);
        setIsGreen(2,true);
    }

    public synchronized void  run() throws InterruptedException {
        int time = 0;
        int yellowLightTime = 0;

        while(time<1000000) {
            System.out.println("Time.... " + time);

            panel.getGraphics().setColor(Color.green.darker().darker()); //green background
            panel.getGraphics().fillRect(0, 0, 800, 800);//also background

            //Draw lanes
            GraphicsEngine.drawRoadUp(panel.getGraphics(), lanes[0].size());
            GraphicsEngine.drawRoadDown(panel.getGraphics(), lanes[2].size());
            GraphicsEngine.drawRoadLeft(panel.getGraphics(), lanes[1].size());
            GraphicsEngine.drawRoadRight(panel.getGraphics(), lanes[3].size());

            //Draw Cars that are in the on-load sequence
            for (int i = 0; i < lanes[0].size(); i++)
                lanes[0].get(i).drawSelfUp(panel.getGraphics(), i);
            for (int i = 0; i < lanes[2].size(); i++)
                lanes[2].get(i).drawSelfDown(panel.getGraphics(), i);
            for (int i = 0; i < lanes[1].size(); i++)
                lanes[1].get(i).drawSelfLeft(panel.getGraphics(), i);
            for (int i = 0; i < lanes[3].size(); i++)
                lanes[3].get(i).drawSelfRight(panel.getGraphics(), i);

            //Draws offLoad
            for (int i = 0; i < offLanes[0].size(); i++) {
                offLanes[0].get(i).moveUp();
                offLanes[0].get(i).drawUp(panel.getGraphics(), i);
            }
            for (int i = 0; i < offLanes[2].size(); i++) {
                offLanes[2].get(i).moveDown();
                offLanes[2].get(i).drawDown(panel.getGraphics(), i);
            }
            for (int i = 0; i < offLanes[1].size(); i++) {
                offLanes[1].get(i).moveLeft();
                offLanes[1].get(i).drawLeft(panel.getGraphics(), i);
            }
            for (int i = 0; i < offLanes[3].size(); i++) {
                offLanes[3].get(i).moveRight();
                offLanes[3].get(i).drawRight(panel.getGraphics(), i);
            }


            if (time % 100 == 0) {
                for (int i = 0; i < 5; i++) { //Maximum chance of 5 new cars added, dependent on the randomizer and the density stat
                    int percentCar = (int) (Math.random() * 100 + 1);
                    if (percentCar <= DENSITY) {
                        int dir = (int) (Math.random() * lanes.length);
                        int lane = (int) (Math.random() * lanes[dir].size());
                        Car addedCar = new Car();
                        if (lane == lanes[dir].size() - 1) {
                            if (turnChance < (int) (Math.random() * 100 + 1)) {
                                addedCar.setTurn(1);
                            }
                        }
                        lanes[dir].get(lane).addCar(addedCar, dir, lane);
                        System.out.println("Added a car to the.... " + dir + " direction, and the " + lane + " lane");

                    } // adds a car to a random direction and a random lane in that direction
                }
                if(yellowLightTime == 0){
                    System.out.println("Got here");
                if (trafficLightVertical.getLight() == 2) { //green
                    System.out.println(needChange(1) + " " + (time-prevTime > (MAX_TIME/4)));
                    if (needChange(1) && (time - prevTime > (MAX_TIME / 4))) { // vertical
                        System.out.println("Vertical Light was green, now switched to yellow");
                        trafficLightVertical.setLight(1);
                        //trafficLightHorizontal.setLight(2);
                        setIsGreen(0, false);
                        setIsGreen(2, false);
                        prevTime = time;
                    } else {
                        //removeCars(0);
                        //removeCars(2);
                    }
                    addWaitTimes();

                } else if (trafficLightHorizontal.getLight() == 2) {//green
                    System.out.println(needChange(0) + " " + (time-prevTime > (MAX_TIME/4)));
                    if (needChange(0) && (time - prevTime > (MAX_TIME / 4))) {
                        System.out.println("Horizontal Light was green, now switched to yellow");
                        trafficLightHorizontal.setLight(1);
                        //trafficLightVertical.setLight(2);
                        setIsGreen(1, false);
                        setIsGreen(3, false);
                        prevTime = time;
                    } else {
                        //removeCars(1);
                        //removeCars(3);
                    }
                    addWaitTimes();

                }
            }
        }
            if(yellowLightTime >= 75){
                if(trafficLightHorizontal.getLight() == 1){
                    trafficLightHorizontal.setLight(0);
                    trafficLightVertical.setLight(2);
                    setIsGreen(0, true);
                    setIsGreen(1, false);
                    setIsGreen(2, true);
                    setIsGreen(3, false);
                }
                else if(trafficLightVertical.getLight() == 1){
                    trafficLightHorizontal.setLight(2);
                    trafficLightVertical.setLight(0);
                    setIsGreen(0, false);
                    setIsGreen(1, true);
                    setIsGreen(2, false);
                    setIsGreen(3, true);
                }
                yellowLightTime = 0;
            }
            if(trafficLightVertical.getLight() != 1 && trafficLightHorizontal.getLight() != 1) {
                removeCars(0);
                removeCars(2);
                removeCars(1);
                removeCars(3);
            }
            else{
                yellowLightTime++;
            }

            drawLights(trafficLightHorizontal.getLight(),trafficLightVertical.getLight());

            time++;
            Thread.sleep(10);
        }
    }

    private boolean needChange(int light){
        /**
         * If the amount of people waiting is RATIO times those that can move AND they have waited over max wait time/RATIO combined
         * If the amount of people waiting have a combined wait time larger than the max time
         * If the amount of people waiting is very small, but they have waited longer than a ratio of the max time
         */
        if(light == 0){ //horizontal light
            if((getDirSize(0) + getDirSize(2) > ((getDirSize(1) + getDirSize(3))*RATIO)&& getDirWaitTime(0) + getDirWaitTime(2) > (MAX_TIME/RATIO) )||  getDirWaitTime(0) + getDirWaitTime(2) > (MAX_TIME)){
                return true;
            }
            if(getDirSize(0) + getDirSize(2) <= 2 && getDirWaitTime(0) + getDirWaitTime(2) > (MAX_TIME/(RATIO*.75))){
                return true;
            }

        }
        if(light == 1){ //vertical light
            if((getDirSize(1) + getDirSize(3) > ((getDirSize(0) + getDirSize(2))*RATIO) && getDirWaitTime(1) + getDirWaitTime(3) > (MAX_TIME/RATIO)) || getDirWaitTime(1) + getDirWaitTime(3) > (MAX_TIME)){
                return true;
            }
            if(getDirSize(1) + getDirSize(3) <= 2 && getDirWaitTime(1) + getDirWaitTime(3) > (MAX_TIME/(RATIO*.75))){
                return true;
            }
        }
        return false;
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
            if(lanes[dir].get(i).getSize() > 0 && lanes[dir].get(i).getCar(0) != null && lanes[dir].get(i).shouldRemove(dir)) {
                waitList.add(lanes[dir].get(i).getCar(0).getWaitTime());
                System.out.println("Removed the car in direction " + dir + " and lane " + i + " with wait time " + lanes[dir].get(i).getCar(0).getWaitTime());
                if(offLanes[dir].size() > 10){
                    offLanes[dir].remove(0);
                }
                if(lanes[dir].get(i).getCar(0).getTurn() == 0)
                    offLanes[dir].add(lanes[dir].get(i).removeCar());
                else if(lanes[dir].get(i).getCar(0).getTurn() == 1)
                    if(dir == 0)
                        offLanes[3].add(lanes[dir].get(i).removeCar());
                    else
                        offLanes[dir-1].add(lanes[dir].get(i).removeCar());
            }
        }
    }

    private void addWaitTimes(){
       for(int dir = 0; dir < lanes.length; dir++) {
           for (int lane = 0; lane < lanes[dir].size(); lane++) {
               for (int car = 0; car < lanes[dir].get(lane).getSize(); car++)
                   lanes[dir].get(lane).getCar(car).addWaitTime(1);
           }
       }
    }



    public int getTotalWaitTime(){
        int output = 0;
        for (Integer integer : waitList)
            output += integer;
        for(int i = 0; i < lanes.length; i++)
            output += getDirWaitTime(i);
        return output;
    }

    public int getAverageWaitTime(){
        int sizeLeft = 0;
        for(int i = 0; i < lanes.length; i++)
            sizeLeft += getDirSize(i);
        return getTotalWaitTime()/(waitList.size()+sizeLeft);
    }

    private void setIsGreen(int lane, boolean b){
        for(int i = 0; i < lanes[lane].size(); i++){
            lanes[lane].get(i).setIsGreen(b);
        }
    }

    private void drawLights(int a, int b){
        Graphics g = panel.getGraphics();

        switch(a){
            case 0: g.setColor(Color.RED);
            break;
            case 1: g.setColor(Color.ORANGE);
            break;
            case 2: g.setColor(Color.green);
        }

        g.fillOval(387,397,6,6);
        g.fillOval(407,397,6,6);
        switch(b){
            case 0: g.setColor(Color.RED);
                break;
            case 1: g.setColor(Color.ORANGE);
                break;
            case 2: g.setColor(Color.green);
        }
        g.fillOval(397,387,6,6);
        g.fillOval(397,407,6,6);
        g.setColor(Color.BLACK.brighter());
        g.fillRoundRect(390,390,20,20,5,5);
    }
}