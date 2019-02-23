package Q1;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class MatrixGraphTest {
    MatrixGraph g=new MatrixGraph(5,true);
    void create() {
        Edge a=new Edge(0,4,100);
        Edge b=new Edge(0,3,30);
        Edge c=new Edge(0,1,10);
        Edge d=new Edge(1,2,50);
        Edge e=new Edge(2,4,10);
        Edge aa=new Edge(3,2,20);
        Edge bb=new Edge(3,4,60);
        g.insert(a);g.insert(b);g.insert(c);g.insert(d);g.insert(e);
        g.insert(aa);g.insert(bb);
    }
    @Test
    void is_acyclic_graph() {
        create();
        if(g.is_acyclic_graph())
            System.out.println("not cycle");
        else
            System.out.println("is cycle");
    }
    @Test
    void shortestPath()
    {
        create();
        Vector<Integer> path=new Vector<>();
        path=g.shortest_path(g,0,4,path);
        System.out.println("Shortest path: "+path+"\nDistance of shortest path: "+g.distance);
    }

    @Test
    void plotgGraph()
    {
        create();
        System.out.println(g.plot_graph(g));
    }

    @Test
    void isUndirected()
    {
        create();
        System.out.println("Is an undirected graph? : "+g.isUndirected());
    }
}