import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class GraphicsTester {
    public static void main(String args[]) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer("SFX/honk.wav", false);
        audioPlayer.play();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        DrawingPanel panel = new DrawingPanel(800, 600);
        while(true){
        for(int i = 600; i >0; i--) {
            drawRoadVerticle(panel.getGraphics(), 1);
            drawCarVeriticle(panel.getGraphics(), 422, i);
            Thread.sleep(10);
        }
        }

    }

    public static void drawCarVeriticle(Graphics g, int x, int y){
        g.setColor(new Color(255,50,50));
        g.fillRoundRect(x-15, y-30, 30,60, 10,10);
        g.fillRoundRect(x-20,y-10,40,10,10,10);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x-13,y-17,26,13,10,10);
        g.fillRoundRect(x-13,y+15,26,12,10,10);
        g.setColor(new Color(255,75,75));
        g.fillRect(x-14,y-1,28,14);
        g.setColor(Color.ORANGE);
        g.fillRoundRect(x-15,y-30,5,5,10,10);
        g.fillRoundRect(x+10,y-30,5,5,10,10);

    }

    public static void drawRoadVerticle(Graphics g, int lanes){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(400,0,lanes*(45),800);
    }
}
