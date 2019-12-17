package clustering.algorithm;

import java.util.ArrayList;

/**
 * Cluster
 */
public class Cluster {
    private int index = 0;
    private Centroid centroid;
    private ArrayList< Datapoint > points;

    public Cluster(int index) {
        setIndex(index);
        points = new ArrayList<>();
    }

    public void setIndex(int index) { this.index = ( index >= 0 ) ? index : 0; }
    public void setCentroid(Centroid centroid) { this.centroid = centroid; }
    public void setPoints(ArrayList< Datapoint > points) { this.points = points; }

    public int getIndex() { return index; }
    public Centroid getCentroid() { return centroid; }
    public ArrayList< Datapoint > getPoints() { return points; }

    public void addPoint(Datapoint point) {
        points.add(point);
        point.setCluster(index);
    }

    public void clearCluster() { points.clear(); }

    public String toString() {
        return "-----\nCluster " + getIndex() + "\nCentroide (" + centroid.getX() + "," + centroid.getY() + ")\nPuntos: " + points.size();
    }

    public String pointsToString() {
        String toReturn = "Puntos:";
        for(Point p : points)
            toReturn += "\n(" + p.getX() + "," + p.getY() + ")";
        return toReturn;
    }
}