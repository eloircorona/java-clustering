package clustering.algorithm;

/**
 * Point
 */
public abstract interface Point {

    public abstract double getX();
    public abstract double getY();
    
    public static double calculateDistance(Point p1, Point p2) {
        return 0;
    };
    
    public static Datapoint randomPoint(int minX, int minY, int maxX, int maxY) {
        return new Datapoint(0,0);
    }

}