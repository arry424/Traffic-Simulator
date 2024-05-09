public class TrafficLight {
    private int light;

    public TrafficLight(){
        this(0);
    }
    /**
     * 0 -> Red
     * 1 -> Yellow
     * 2 -> Green
     * 3 -> Left turn arrow
     */
    public TrafficLight(int l){
        light = l;
    }

    public void setLight(int l){
        light = l;
    }

    public int getLight(){
        return light;
    }
}
