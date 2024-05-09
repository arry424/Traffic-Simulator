import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class IntersectionTester {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println("Hello world!");

        SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer("SFX/honk.wav",true);
        audioPlayer.play();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();



        DrawingPanel panel = new DrawingPanel(600,600 );

        Car car = new Car();
        car.draw(panel.getGraphics());

    }
}