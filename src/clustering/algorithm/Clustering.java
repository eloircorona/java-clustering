package clustering.algorithm;

import java.util.ArrayList;

/**
 * Clustering
 */
public class Clustering {

    protected ArrayList< Datapoint > points;
    protected ArrayList< Cluster > clusters;

    public Clustering(ArrayList< Datapoint > points, ArrayList< Cluster > clusters) {
        this.points = new ArrayList< >();
        this.clusters = new ArrayList< >();
        setPoints(points);
        setClusters(clusters);
    }

    public Clustering(ArrayList< Datapoint > points) {
        this.points = new ArrayList< >();
        this.clusters = new ArrayList< >();
        setPoints(points);
    }
    
    public void setPoints(ArrayList< Datapoint > pointsData) { this.points = pointsData; }
    public void setClusters( ArrayList< Cluster > clusters ) { this.clusters = clusters; }

    public ArrayList< Datapoint > getPoints() { return points; }
    public ArrayList< Cluster > getClusters() { return clusters; }

    public String toString() { return "Número de datos: " + getPoints().size(); }
}