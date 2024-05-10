import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class GraphicsTester {
    public static synchronized void main(String args[]) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer("SFX/honk.wav", false);
        audioPlayer.play();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        DrawingPanel panel = new DrawingPanel(800, 800);
        panel.getGraphics().setColor(Color.green.darker().darker());
        panel.getGraphics().fillRect(0,0,800,800);


        while(true){
        for(int i = 800; i >0; i--) {

            if(i==540)
                Thread.sleep(1000);
            drawRoadUp(panel.getGraphics(), 2);
            drawRoadDown(panel.getGraphics(),2);
            drawRoadLeft(panel.getGraphics(),2);
            drawRoadRight(panel.getGraphics(),2);



            drawCarVeriticle(panel.getGraphics(), 430, i,Color.pink);
            drawCarVeriticle(panel.getGraphics(),480,i-10,Color.CYAN.darker());


            Thread.sleep(10);
        }
        }

    }

    public static void drawCarVeriticle(Graphics g, int x, int y, Color c){
        g.setColor(c);
        g.fillRoundRect(x-15, y-30, 30,60, 10,10);
        g.fillRoundRect(x-20,y-10,40,10,10,10);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x-13,y-17,26,13,10,10);
        g.fillRoundRect(x-13,y+15,26,12,10,10);
        g.setColor(c);
        g.fillRect(x-14,y-1,28,14);
        g.setColor(Color.ORANGE);
        g.fillRoundRect(x-15,y-30,5,5,10,10);
        g.fillRoundRect(x+10,y-30,5,5,10,10);

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

