package Q1;
import java.util.*;

/** A class for calling Dijkstra's algorithm.
 *  @author Koffman and Wolfgang
 */

public class DijkstrasAlgorithm {

    /** Dijkstra’s Shortest-Path algorithm.
     @param graph The weighted graph to be searched
     @param start The start vertex
     @param pred Output array to contain the predecessors
     in the shortest path
     @param dist Output array to contain the distance
     in the shortest path
     */
    public static void dijkstrasAlgorithm(Graph graph, int start, int[] pred, double[] dist) {
        int numV = graph.getNumV();
        HashSet < Integer > vMinusS = new HashSet < Integer > (numV);
        // Initialize V–S.
        for (int i = 0; i < numV; i++) {
            if (i != start) {
                vMinusS.add(i);
            }
        }
        // Initialize pred and dist.
        for (int v : vMinusS) {
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }
        // Main loop
        while (vMinusS.size()!=0) {
            // Find the value u in V–S with the smallest dist[u].
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int v : vMinusS) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }
            // Remove u from vMinusS.
            vMinusS.remove(u);
            if(u==-1)
                break;
            Iterator<Edge> edgeIter=graph.edgeIterator(u);
            while (edgeIter.hasNext()){
                Edge edge=edgeIter.next();
                int v=edge.getDest();
                if (vMinusS.contains(new Integer(v))){
                    double weight=edge.getWeight();
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pred[v] = u;
                    }
                }
            }
        }
    }
}
