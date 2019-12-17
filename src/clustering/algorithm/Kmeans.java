package clustering.algorithm;

import java.util.ArrayList;

/**
 * Kmeans
 */
public class Kmeans extends PointAssignment {
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;

    private static final int MAX_X = 800;
    private static final int MAX_Y = 150000;

    private int maxGenerations = 10;

    private boolean randomClusters = true;
    private ArrayList < Centroid > centroids;
    
    private int historyCount = 0;
    private ArrayList < ArrayList < String > > history;
    
    public Kmeans(int maxGenerations, int numberOfClusters,  ArrayList< Datapoint > points, ArrayList< Cluster > clusters, Boolean randomCluster, ArrayList < Centroid > centroids) {
        super(numberOfClusters, points, clusters);
        setMaxGenerations(maxGenerations);
        setRandomClusters(randomClusters);
        setCentroids(centroids);
    }

    public Kmeans(int maxGenerations, int numberOfClusters,  ArrayList< Datapoint > points, Boolean randomCluster, ArrayList < Centroid > centroids) {
        super(numberOfClusters, points);
        setMaxGenerations(maxGenerations);
        setRandomClusters(randomClusters);
        setCentroids(centroids);
    }
    
    public void setMaxGenerations(int maxGenerations) { this.maxGenerations = maxGenerations; }
    public void setRandomClusters(Boolean randomClusters) { this.randomClusters = randomClusters; }
    public void setCentroids(ArrayList < Centroid > centroids) { this.centroids = centroids; }

    public int getMaxGenerations() { return maxGenerations; }

    public void initialize() throws DivisionByZeroException {
        history = new ArrayList<>();

        if(randomClusters) createRandomClusters();
        else createClusters();

        for(int i = 0; i < getMaxGenerations(); i ++) {
            clearClusters();
            assignPointsToCluster();
            calculateClustersCentroids();
            //System.out.println(clusters);

            ArrayList < String > _clusters = new ArrayList<>();
            for(Cluster cluster : clusters) {
                _clusters.add(cluster.toString());
            }
            history.add(_clusters);
            historyCount++;
        }
        
    }

    public void clearClusters() {
        for(Cluster cluster : clusters) {
            cluster.clearCluster();
        }
    }

    public void createClusters() {
        for(int i = 0; i < getK(); i++) {
            Cluster _cluster = new Cluster(i);
            Centroid centroid = new Centroid(centroids.get(i).getX(), centroids.get(i).getY());
            _cluster.setCentroid(centroid);
            getClusters().add(_cluster);
        }
    }

    public void createRandomClusters() {
        for(int i = 0; i < getK(); i++) {
            Cluster _cluster = new Cluster(i);
            _cluster.setCentroid(Centroid.randomPoint(MIN_X, MIN_Y, MAX_X, MAX_Y));
            getClusters().add(_cluster);
        }
    }

    public void assignPointsToCluster() {
        Datapoint pointMin = new Datapoint(MIN_X,MIN_Y);
        Datapoint pointMax = new Datapoint(MAX_X,MAX_Y);
        double max = Datapoint.calculateDistance(pointMin, pointMax);
        double min = max;
        double distance = 0;
        int clusterIndex = 0;

        for(Datapoint point : points) {
            min = max;
            for(int i = 0; i < getK(); i++) {
                Cluster _cluster = getClusters().get(i);
                distance = Datapoint.calculateDistance(point, _cluster.getCentroid());
                if( distance < min ) {
                    min = distance;
                    clusterIndex = i;
                }
            }
            point.setCluster(clusterIndex);
            getClusters().get(clusterIndex).addPoint(point);
        }
    }

    public void calculateClustersCentroids() throws DivisionByZeroException {
        for(int i = 0; i < getK(); i++) {
            Cluster _cluster = getClusters().get(i);
            _cluster.setCentroid(Centroid.calculateCentroid(_cluster));
        }
    }

    public String toString() {
        String _return = "History to String\n";
        for(int i = 0; i < historyCount; i++) {
            _return += "-----------------------\nGen: " + i + "\n";
            for(String cluster : history.get(i)) {
                _return += cluster + "\n";
            }
        }
        return _return;
    } 

}