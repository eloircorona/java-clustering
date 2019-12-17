package testing;

import java.util.ArrayList;

import clustering.algorithm.*;
import clustering.db.*;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        String src = "C:\\Users\\eloir\\Desktop\\iter_14_cpv2010\\conjunto_de_datos\\iter_14_cpv2010-1.csv";
        ArrayList < Integer > data_x = Database.reading(src, 4);
        ArrayList < Integer > data_y = Database.reading(src, 9);
        
        ArrayList < Datapoint > points = new ArrayList<>();
        ArrayList < Centroid > centroids = new ArrayList<>();

        int maxGenerations = 10;
        int numberOfClusters = 5;

        boolean randomCluster = true;

        for(int i = 0; i < data_x.size(); i++) {
            Datapoint p1 = new Datapoint(data_x.get(i), data_y.get(i));
            points.add(p1);
        }

        Kmeans k = new Kmeans(maxGenerations, numberOfClusters, points, randomCluster, centroids);

        k.initialize();
        System.out.println(k.toString());

    }
    

}