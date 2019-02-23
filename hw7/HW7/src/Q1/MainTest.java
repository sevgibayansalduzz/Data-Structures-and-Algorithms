package Q1;

import java.util.Vector;

/**Create directed acyclic graph with 10 vertices and 20 edges*/
public class MainTest
{
    public static void main(String[] args) {
        MatrixGraph test=new MatrixGraph(10,true);
        /*Edges*/
        Edge e1=new Edge(0,1,30);
        Edge e2=new Edge(0,2,10);
        Edge e3=new Edge(0,3,20);
        Edge e4=new Edge(2,1,5);
        Edge e5=new Edge(2,3,15);
        Edge e6=new Edge(2,4,10);
        Edge e7=new Edge(2,6,12);
        Edge e8=new Edge(3,6,5);
        Edge e9=new Edge(4,1,5);
        Edge e10=new Edge(4,5,5);
        Edge e11=new Edge(4,7,15);
        Edge e12=new Edge(2,5,5);
        Edge e13=new Edge(5,6,20);
        Edge e14=new Edge(5,1,2);
        Edge e15=new Edge(5,8,12);
        Edge e16=new Edge(5,7,7);
        Edge e17=new Edge(5,9,50);
        Edge e18=new Edge(6,9,40);
        Edge e19=new Edge(7,8,4);
        Edge e20=new Edge(8,9,5);

        test.insert(e1);test.insert(e2);test.insert(e3);test.insert(e4);test.insert(e5);
        test.insert(e6);test.insert(e7);test.insert(e8);test.insert(e9);test.insert(e10);
        test.insert(e11);test.insert(e12);test.insert(e13);test.insert(e14);test.insert(e15);
        test.insert(e16);test.insert(e17);test.insert(e18);test.insert(e19);test.insert(e20);

        System.out.println("*************************************");
        System.out.println("Plot of graph:");
        System.out.println(test.plot_graph(test));
        System.out.println("*************************************");
        System.out.println("Is an undirected graph? : "+ test.isUndirected());
        System.out.println("*************************************");
        System.out.println("Is an acyclic graph? : "+test.is_acyclic_graph());
        System.out.println("*************************************");
        Vector<Integer> path=new Vector<>();
        System.out.println("********Shortest path  for v1:0, v2:9 *********");
        path=test.shortest_path(test,0,9,path);
        System.out.println("Shortest path: "+path+"\nDistance of shortest path: "+test.distance);
        path.clear();
        System.out.println("\n********Shortest path  for v1:2, v2:9 *********");
        path=test.shortest_path(test,2,9,path);
        System.out.println("Shortest path: "+path+"\nDistance of shortest path: "+test.distance);
        path.clear();
        System.out.println("\n********Shortest path  for v1:4, v2:8 *********");
        path=test.shortest_path(test,4,8,path);
        System.out.println("Shortest path: "+path+"\nDistance of shortest path: "+test.distance);
        System.out.println("*************************************");
    }
}
