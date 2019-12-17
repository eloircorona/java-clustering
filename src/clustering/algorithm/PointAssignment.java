package clustering.algorithm;

import java.util.ArrayList;

/**
 * PointAssignment
 */
public class PointAssignment extends Clustering {
    private int k = 4;

    public PointAssignment(int k, ArrayList< Datapoint > points, ArrayList< Cluster > clusters) {
        super(points, clusters);
        setK(k);
    }

    public PointAssignment(int k, ArrayList< Datapoint > points) {
        super(points);
        setK(k);
    }
    
    public void setK(int k) { this.k = ( k >= 0 ) ? k : 0; }
    public int getK() { return k; }
    
}