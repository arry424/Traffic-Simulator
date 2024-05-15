import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Car {
    private int waitTime;
    private int happiness;
    private  int xLoc;
    private int yLoc;
    private Color color;

    public Car(){
        waitTime = 0;
        happiness = (int)(Math.random()*100+1);
        xLoc = 300;
        yLoc = 300;
        color = Color.RED;
    }

    public Car(int wt, int hap){
        waitTime = wt;
        happiness = hap;
    }

    public void addWaitTime(int wt) {
        waitTime += wt;
    }

    //RunTime Graphics Callings
    public void drawUp(Graphics g,int lanePos){
        GraphicsEngine.drawCarUp(g,xLoc,yLoc,color);
    }
    public void drawDown(Graphics g,int lanePos){
        GraphicsEngine.drawCarDown(g,xLoc,yLoc,color);
    }
    public void drawLeft(Graphics g,int lanePos){
        GraphicsEngine.drawCarLeft(g,xLoc,yLoc,color);
    }
    public void drawRight(Graphics g,int lanePos){
        GraphicsEngine.drawCarRight(g,xLoc,yLoc,color);
    }

    //position updaters
    public void moveUp(){yLoc-=2;}
    public void moveDown(){yLoc+=2;}
    public void moveLeft(){xLoc-=2;}
    public void moveRight(){xLoc+=2;}

    public int getXLoc() {
        return xLoc;
    }

    public int getYLoc() {
        return yLoc;
    }

    public void setWaitTime(int wt){
        waitTime = wt;
    }

    public void setColor(Color c){color = c;}

    public int getWaitTime(){
        return waitTime;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void setXLoc(int x){xLoc = x;}
    public void setYLoc(int y){yLoc = y;}

    //TODO Make a toString that prints something that looks nice

}
