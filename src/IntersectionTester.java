import java.awt.*;

public class IntersectionTester {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        DrawingPanel panel = new DrawingPanel((int)screenSize.getWidth()-100,(int)screenSize.getHeight()-100 );
    }
}