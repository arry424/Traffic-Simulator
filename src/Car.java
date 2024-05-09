public class Car {
    private int waitTime;

    public Car(){
        waitTime = 0;
    }

    public Car(int wt){
        waitTime = wt;
    }

    public void setWaitTime(int wt){
        waitTime = wt;
    }

    public int getWaitTime(){
        return waitTime;
    }

    //TODO Make a toString that prints something that looks nice

}
