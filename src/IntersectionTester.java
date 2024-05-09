import java.awt.*;

public class IntersectionTester {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        intersection.run();
        System.out.println(intersection.getTotalWaitTime());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        DrawingPanel panel = new DrawingPanel((int)screenSize.getWidth()-100,(int)screenSize.getHeight()-100 );
    }
}