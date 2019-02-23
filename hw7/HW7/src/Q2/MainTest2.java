package Q2;

import Q1.Edge;
import Q1.MatrixGraph;

public class MainTest2 {
    public static void main(String[] args) {
        MatrixGraph test=new MatrixGraph(15,false);
        /*Edges*/
        Edge e1=new Edge(0,1);
        Edge e2=new Edge(0,3);
        Edge e3=new Edge(1,4);
        Edge e4=new Edge(1,7);
        Edge e5=new Edge(2,8);
        Edge e6=new Edge(2,12);
        Edge e7=new Edge(3,9);
        Edge e8=new Edge(11,12);
        Edge e9=new Edge(4,8);
        Edge e10=new Edge(4,5);
        Edge e12=new Edge(6,11);
        Edge e13=new Edge(6,13);
        Edge e14=new Edge(8,14);
        Edge e15=new Edge(9,10);
        test.insert(e1);test.insert(e2);test.insert(e3);test.insert(e4);test.insert(e5);
       test.insert(e6);test.insert(e7);test.insert(e8);test.insert(e9);test.insert(e10);
       test.insert(e12);test.insert(e13);test.insert(e14);test.insert(e15);

        System.out.println("*************************************");
        System.out.println("Plot of graph:");
        System.out.println(test.plot_graph(test));
        System.out.println("*************************************");
        System.out.println("Is an undirected graph? : "+ test.isUndirected());
        System.out.println("*************************************");
        System.out.println("Is an acyclic graph? : "+test.is_acyclic_graph());
        System.out.println("*************************************");

        System.out.println("Is there a path from v1:4 to v2:11  ?  == "+ test.is_connected(test,4,11));
        System.out.println("Is there a path from v1:0 to v2:14  ?  == "+ test.is_connected(test,0,14));
        System.out.println("Is there a path from v1:6 to v2:13  ?  == "+ test.is_connected(test,6,13));


    }
}
