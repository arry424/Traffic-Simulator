public class Car {
    private int waitTime;
    private int happiness;

    public Car(){
        waitTime = 0;
        happiness = (int)(Math.random()*100+1);
    }

    public Car(int wt, int hap){
        waitTime = wt;
        happiness = hap;
    }

    public void setWaitTime(int wt){
        waitTime = wt;
    }

    public int getWaitTime(){
        return waitTime;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    //TODO Make a toString that prints something that looks nice

}
