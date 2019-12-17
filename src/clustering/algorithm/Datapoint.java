package clustering.algorithm;

import java.util.Random;

/**
 * Datapoint
 */
public class Datapoint implements Point {
    private double x = 0;
    private double y = 0;
    private int cluster = 0;

    public Datapoint(double x, double y) {
        setX(x);
        setY(y);
    }

    public void setX(double x) { this.x = ( x >= 0 ) ? x : 0; }
    public void setY(double y) { this.y = ( y >= 0 ) ? y : 0; }
    public void setCluster(int cluster) { this.cluster = ( cluster >= 0 ) ? cluster : 0; }

    public double getX() { return x; }
    public double getY() { return y; }
    public int getCluster() { return cluster; }

    public static double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow( (p2.getY() - p1.getY()) , 2 ) + Math.pow( (p2.getX() - p1.getX()) , 2 ));
    }

    public static Datapoint randomPoint(int minX, int minY, int maxX, int maxY) {
        Random r = new Random();
    	return new Datapoint( Math.round(minX + (maxX - minX) * r.nextDouble()) , Math.round(minY + (maxY - minY) * r.nextDouble()) );
    }
}