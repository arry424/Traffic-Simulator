public class Location2D {
    private int xLoc;
    private int yLoc;

    public Location2D(int x, int y){
        int xLoc = x;
        int yLoc = y;
    }

    public int getX() {
        return xLoc;
    }

    public int getY() {
        return yLoc;
    }

    public void setX(int xLoc) {
        this.xLoc = xLoc;
    }

    public void setY(int yLoc) {
        this.yLoc = yLoc;
    }
}
