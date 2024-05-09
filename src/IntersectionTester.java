import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class IntersectionTester {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Intersection intersection = new Intersection();
        intersection.run();
        System.out.println("Total wait time: " + intersection.getTotalWaitTime());
        System.out.println("Average wait time per car: " + intersection.getAverageWaitTime());

        //System.out.println("Hello world!");



    }
}