package clustering.algorithm;

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

    public static Centroid calculateCentroid(Cluster cluster) throws DivisionByZeroException {
        int sumPointsX = 0;
        int sumPointsY = 0;
        int clusterSize = 0;
        for(Datapoint point : cluster.getPoints()) {
            sumPointsX += point.getX();
            sumPointsY += point.getY();
        }
        
        if(cluster.getPoints().size() == 0 && sumPointsX > 0) throw new DivisionByZeroException("cluster " + cluster.getIndex());
        else clusterSize = 1;
        return new Centroid( (sumPointsX / clusterSize) , (sumPointsY / clusterSize)) ;
    }

    public static Centroid randomPoint(int minX, int minY, int maxX, int maxY) {
        Random r = new Random();
    	return new Centroid( Math.round(minX + (maxX - minX) * r.nextDouble()) , Math.round(minY + (maxY - minY) * r.nextDouble()) );
    }
}