package Q5;

import Q4.SortArray;

public class MainTest {
    public static void main(String[] args) {

        System.out.println("First Array(size:100)");
        SortArray2 array1=new SortArray2(100);
        array1.testSortAlgorithms();

        System.out.println("\n\n*******************************************************\n"
                +"Second Array(size:1000)");
        SortArray2 array2=new SortArray2(1000);
        array2.testSortAlgorithms();

        System.out.println("\n\n*******************************************************\n" +
                "Third Array(size:5000)");
        SortArray2 array3=new SortArray2(5000);
        array3.testSortAlgorithms();

        System.out.println("\n\n*******************************************************\n" +
                "Fourth Array(size:10000)");
        SortArray2 array4=new SortArray2(10000);
        array4.testSortAlgorithms();
    }
}
