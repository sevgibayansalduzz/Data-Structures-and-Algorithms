package Q3;

import Q1.BreadthFirstSearch;
import Q1.DepthFirstSearch;
import Q1.Edge;
import Q1.MatrixGraph;

public class MainTest3 {
    public static void main(String[] args) {
        MatrixGraph test=new MatrixGraph(10,false);
        Edge e1=new Edge(0,7);
        Edge e2=new Edge(0,8);
        Edge e3=new Edge(5,6);
        Edge e4=new Edge(1,2);
        Edge e5=new Edge(7,9);
        Edge e6=new Edge(8,1);
        Edge e7=new Edge(7,3);
        Edge e8=new Edge(2,4);
        Edge e9=new Edge(4,6);
        Edge e10=new Edge(4,9);
        Edge e11=new Edge(5,9);
        Edge e12=new Edge(3,5);

        test.insert(e1);
        test.insert(e2);
        test.insert(e3);
        test.insert(e4);
        test.insert(e5);
        test.insert(e6);
        test.insert(e7);
        test.insert(e8);
        test.insert(e9);
        test.insert(e10);
        test.insert(e11);
        test.insert(e12);

        System.out.println("*************************************");
        System.out.println("Plot of graph:");
        System.out.println(test.plot_graph(test));
        System.out.println("*************************************");
        System.out.println("Is an undirected graph? : "+ test.isUndirected());
        System.out.println("*************************************");
        System.out.println("Is an cyclic graph? : "+!(test.is_acyclic_graph()));
        System.out.println("*************************************");

        DepthFirstSearch test1=new DepthFirstSearch(test);
        int[] k=test1.getFinishOrder();int i=0;
        StringBuilder sb=new StringBuilder();
        do {
            sb.append(k[i]);
            ++i;
        }while (i<k.length && sb.append(",")!=null);
        System.out.println("DFS: "+sb.toString());
        System.out.println("*************************************");
        i=0;
        sb=new StringBuilder();
        BreadthFirstSearch test2=new BreadthFirstSearch();
        int []a=test2.breadthFirstSearch(test,0);
        do {
            sb.append(a[i]);
            ++i;
        }while (i<a.length && sb.append(",")!=null);
        System.out.println("BFS: "+sb.toString());
        System.out.println("*************************************");
    }
}
