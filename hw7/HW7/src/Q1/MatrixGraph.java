// Insert solution to programming project 1, chapter -1 here
package Q1;

import java.util.*;

public class MatrixGraph extends AbstractGraph {

    /** The two dimensional array to represent an edge */
    private double[][] edges;
    public MatrixGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new double[numV][];
        if (directed) {
            for (int i = 0; i != numV; ++i) {
                edges[i] = new double[numV];
                for (int j = 0; j != numV; ++j) {
                    edges[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
        else {
            for (int i = 0; i != numV; ++i) {
                edges[i] = new double[i + 1];
                for (int j = 0; j != i + 1; ++j) {
                    edges[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
    }

    /**
     * Insert functions for the graph
     * @param edge The new edge
     */
    @Override
    public void insert(Edge edge) {
        if (isDirected() || edge.getDest()<edge.getSource())
            edges[edge.getSource()][edge.getDest()]=edge.getWeight();
        else
            edges[edge.getDest()][edge.getSource()]=1.0;
    }
    /**
     * This methods determines whether an edge exists associated with source vertex for an entry.
     * @param source The source vertex
     * @param dest The destination vertex
     * @return
     */
    @Override
    public boolean isEdge(int source, int dest) {
        return is_connected(this,source,dest);
    }
    /**
     * Get the  edge method between two vertices.
     * @param source The source vertex
     * @param dest The destination vertex
     * @return
     */
    @Override
    public Edge getEdge(int source, int dest) {
       if (isDirected())
           return new Edge(source,dest,edges[source][dest]);
       else
           return new Edge(source,dest,edges[dest][source]);
    }

    /**
     * Iterator for the graph
     * @param source The source vertex
     * @return
     */
    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return new Iter(source);
    }

    /**
     *  Check if the graph object is undirected
     * @return
     */
    public boolean isUndirected(){
        return !isDirected();
    }

    /**
     *
     * The graph may or may not have cycles.
     * @return
     */
    public boolean is_acyclic_graph()
    {
        if(isUndirected())
            return !(new DepthFirstSearch(this).isCycle());
        else
        {
            for (int i=0;i<getNumV();++i)
                if(is_cycle(i))
                    return false;
            return true;
        }
    }
    private boolean is_cycle(int index) {
        Queue<Integer> queue=new LinkedList<>();
        Iterator<Edge> iter=edgeIterator(index);
        Set<Integer> old=new HashSet<>();
        if (!iter.hasNext())
            return false;
        queue.offer(iter.next().getDest());
        while (!queue.isEmpty())
        {
            while (iter.hasNext())
            {
                int temp=iter.next().getDest();
                if (temp==index || queue.peek()==index)
                    return true;
                queue.offer(temp);
            }
            int temp2=queue.poll();
            iter=edgeIterator(temp2);
            if (!old.add(temp2))
                return false;
        }
        return false;
    }

    /**
     * this method take any graph object and produce a visual representation of that graph
     * @param graph
     * @return
     */
    public String plot_graph(Graph graph)
    {
        StringBuilder sb=new StringBuilder();
        if (graph.isDirected()) {
            for(int i=0;i<getNumV();++i) {
                sb.append(i);
                for (int j=0;j<getNumV();++j)
                    if(edges[i][j]!=Double.POSITIVE_INFINITY)
                        sb.append("-->(w:"+edges[i][j]+")"+j);
                sb.append("\n");
            }
        }
        else{
            for(int i=0;i<getNumV();++i) {
                sb.append(i);
                for(int j=0;j<edges[i].length;++j)
                    if (edges[i][j] != Double.POSITIVE_INFINITY)
                        sb.append("--" + j);
                for (int j=i;j<getNumV();++j)
                    if (edges[j][i] != Double.POSITIVE_INFINITY)
                        sb.append("--" + j);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     *  Find the shortest path from vertex ​ v1 to vertex ​ v2 using Dijkstra’s algorithm
     */
    double distance=0.0;
    public Vector shortest_path(Graph graph,int v1,int v2,Vector<Integer> path)
    {
        DijkstrasAlgorithm dijk=new DijkstrasAlgorithm();
        int []pred= new int[graph.getNumV()];
        double []dist=new double[graph.getNumV()];
        dijk.dijkstrasAlgorithm(graph,v1,pred,dist);
        this.distance=dist[v2];
        path.add(v2);
        for(int i=v2;i!=v1;i=pred[i])
            path.add(pred[i]);
        for (int i=path.size()-1;i>=0;--i)
        {
            path.add(path.elementAt(i));
            path.remove(i);
        }
        return path;
    }
    /**
     *  Determine if there is any path between vertex ​ v1 and vertex ​ v2 in graph
     * @param graph
     * @param v1
     * @param v2
     * @return
     */
    public boolean is_connected(Graph graph,int v1,int v2)
    {
        if(v1 <0 || v1>getNumV() || v2<0 || v2>getNumV())
            throw new NoSuchElementException("v1 and v2 cannot found");
        if (graph.isDirected())
            return edges[v1][v2]!=Double.POSITIVE_INFINITY;
        else
            return edges[v2][v1]!=Double.POSITIVE_INFINITY;
    }
    // Iter class
    private class Iter  implements Iterator < Edge > {
        private int source;
        /** The current index for this iterator */
        private int index;

        // Constructor
        /** Construct an EdgeIterator for a given vertix
         *  @param source - The source vertix
         */
        public Iter(int source) {
            this.source = source;
            index = -1;
            advanceIndex();
        }
        /** Return true if there are more edges
         *  @return true if there are more edges
         */
        public boolean hasNext() {
            return index != getNumV();
        }
        /** Return the next edge if there is one
         *  @throws NoSuchElementException - there are no
         *  more edges
         *  @return the next Edge in the iteration
         */
        public Edge next() {
            if (index == getNumV()) {
                throw new java.util.NoSuchElementException();
            }
            Edge returnValue;
            if(isDirected() || index<source)
               returnValue = new Edge(source, index,edges[source][index]);
            else
                returnValue=new Edge(source,index,edges[index][source]);
            advanceIndex();
            return returnValue;
        }
        /** Remove is not implememted
         *  @throws UnsupportedOperationExeption if called
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /** Advance the index to the next edge */
        private void advanceIndex() {
            do {
                index++;
            }
            while (index != getNumV()
                    && Double.POSITIVE_INFINITY == getEdgeValue(source, index));
        }
    }
    private double getEdgeValue(int source, int dest) {
        if (isDirected() | source > dest) {
            return edges[source][dest];
        }
        else {
            return edges[dest][source];
        }
    }
}