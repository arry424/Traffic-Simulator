import java.awt.*;

public class GraphicsEngine {
    public static void drawCarUp(Graphics g, int x, int y, Color c){
        g.setColor(c);
        g.fillRoundRect(x-15, y-30, 30,60, 10,10);
        g.fillRoundRect(x-20,y-10,40,10,10,10);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x-13,y-17,26,40,10,10);
        g.fillRoundRect(x-13,y+15,26,12,10,10);
        g.setColor(c);
        g.fillRect(x-14,y-1,28,14);
        g.setColor(Color.ORANGE);
        g.fillRoundRect(x-15,y-30,5,5,10,10);
        g.fillRoundRect(x+10,y-30,5,5,10,10);

    }

    public static void drawCarDown(Graphics g, int x, int y, Color c){
        g.setColor(c);
        g.fillRoundRect(x-15, y-30, 30,60, 10,10);
        g.fillRoundRect(x-20,y+2,40,10,10,10);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x-13,y+7,26,13,10,10);
        g.fillRoundRect(x-13,y-26,26,40,10,10);
        g.setColor(c);
        g.fillRect(x-14,y-13,28,18);
        g.setColor(Color.ORANGE);
        g.fillRoundRect(x-15,y+25,5,5,10,10);
        g.fillRoundRect(x+10,y+25,5,5,10,10);

    }

    public static void drawCarRight(Graphics g, int x, int y, Color c){
        g.setColor(c);
        g.fillRoundRect(x-30,y-15,  60,30, 10,10);
        g.fillRoundRect(x+2,y-20,10,40,10,10);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x+7,y-13,13,26,10,10);
        g.fillRoundRect(x-26,y-13,40,26,10,10);
        g.setColor(c);
        g.fillRect(x-13,y-14,17,28);
        g.setColor(Color.ORANGE);
        g.fillRoundRect(x+25,y-15,5,5,10,10);
        g.fillRoundRect(x+25,y+10,5,5,10,10);

    }

    public static void drawCarLeft(Graphics g, int x, int y, Color c){
        g.setColor(c);
        g.fillRoundRect(x-30,y-15,  60,30, 10,10);
        g.fillRoundRect(x-10,y-20,10,40,10,10);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x-20,y-13,40,26,10,10);
        g.fillRoundRect(x+2,y-13,23,26,10,10);
        g.setColor(c);
        g.fillRect(x-5,y-14,17,28);
        g.setColor(Color.ORANGE);
        g.fillRoundRect(x-30,y-15,5,5,10,10);
        g.fillRoundRect(x-30,y+10,5,5,10,10);
    }

    public static void drawRoadUp(Graphics g, int lanes){
        g.setColor(Color.GRAY);
        g.fillRect(410,0,lanes*(45),800);
    }

    public static void drawRoadDown(Graphics g,int lanes){
        g.setColor(Color.GRAY);
        g.fillRect(390-(lanes*(45)),0,lanes*(45),800);
    }

    public static void drawRoadLeft(Graphics g, int lanes){
        g.setColor(Color.GRAY);
        g.fillRect(0,390-(lanes*(45)),800,lanes * (45));
    }

    public static void drawRoadRight(Graphics g, int lanes){
        g.setColor(Color.GRAY);
        g.fillRect(0,410,800,lanes*(45));
    }
}
