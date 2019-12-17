package clustering.algorithm;

import java.util.ArrayList;
import java.util.Random;

/**
 * Centroid
 */
public class Centroid implements Point {
    private double x = 0;
    private double y = 0;

    public Centroid(double x, double y) {
        setX(x);
        setY(y);
    }

    public void setX(double x) { this.x = ( x >= 0 ) ? x : 0; }
    public void setY(double y) { this.y = ( y >= 0 ) ? y : 0; }
    
    public void setCentroid(double x, double y) {
        setX(x);
        setY(y);
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public static double calculateDistance(Centroid p1, Centroid p2) {
        return Math.sqrt(Math.pow( (p2.getY() - p1.getY()) , 2 ) + Math.pow( (p2.getX() - p1.getX()) , 2 ));
    }

    public static Centroid calculateCentroid(Cluster cluster) {
        int sumPointsX = 0;
        int sumPointsY = 0;
        int pointsCount = (cluster.getPoints().size() > 0) ? cluster.getPoints().size() : 1;
        for(Datapoint point : cluster.getPoints()) {
            sumPointsX += point.getX();
            sumPointsY += point.getY();
        }

        return new Centroid( (sumPointsX / pointsCount) , (sumPointsY / pointsCount));
    }

    public static Centroid randomPoint(int minX, int minY, int maxX, int maxY) {
        Random r = new Random();
    	return new Centroid( Math.round(minX + (maxX - minX) * r.nextDouble()) , Math.round(minY + (maxY - minY) * r.nextDouble()) );
    }
}