package Q4;

public class MainTest {

    public static void main(String[] args) {

        System.out.println("First Array(size:10)");
        SortArray array1=new SortArray(10);
        array1.testSortAlgorithms();

        System.out.println("\n\n*******************************************************\n"
                +"Second Array(size:20)");
        SortArray array2=new SortArray(20);
        array2.testSortAlgorithms();

        System.out.println("\n\n*******************************************************\n" +
                "Third Array(size:50)");
        SortArray array3=new SortArray(50);
        array3.testSortAlgorithms();

        System.out.println("\n\n*******************************************************\n" +
                "Fourth Array(size:100)");
        SortArray array4=new SortArray(100);
        array4.testSortAlgorithms();

        System.out.println("\n\n*******************************************************\n" +
                "Fifth Array(size:200)");
        SortArray array5=new SortArray(200);
        array5.testSortAlgorithms();

        System.out.println("\n\n*******************************************************\n" +
                "Sixth Array(size:500)");
        SortArray array6=new SortArray(500);
        array6.testSortAlgorithms();

        System.out.println("\n\n*******************************************************\n"+
                "Seventh Array(size:1000)");
        SortArray array7=new SortArray(1000);
        array7.testSortAlgorithms();

        System.out.println("\n\n*******************************************************\n"+
                "Eighth Array(size:2000)");
        SortArray array8=new SortArray(2000);
        array8.testSortAlgorithms();

        System.out.println("\n\n*******************************************************\n"+
                "Ninth Array(size:5000)");
        SortArray array9=new SortArray(5000);
        array9.testSortAlgorithms();

        System.out.println("\n\n*******************************************************\n"+
                "Tenth Array(size:100000)");
        SortArray array10=new SortArray(10000);
        array10.testSortAlgorithms();
    }
}
