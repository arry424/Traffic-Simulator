import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Car {
    private int waitTime;
    private int happiness;
    private  int xLoc;
    private int yLoc;
    private Image sprite;

    public Car(){
        waitTime = 0;
        happiness = (int)(Math.random()*100+1);
        xLoc = 300;
        yLoc = 300;
    }

    public Car(int wt, int hap){
        waitTime = wt;
        happiness = hap;
    }

    public void addWaitTime(int wt) {
        waitTime += wt;
    }
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRoundRect(xLoc, yLoc, 30,30,5,5);
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
