package Q4;

import Q3.Part3;

import java.util.Random;

/**
 * Create arrays of random integers for given size and then measure the time it takes to sort for each algorithm.
 */
public class SortArray {
    protected Integer[] array,finall;
    public SortArray(int size){create(size);}

    protected void create(int size)
    {
        array=new Integer[size];
        finall=new Integer[size];
        Random random = new Random();
        for(int i = 0, len = finall.length; i < len; i++)
            finall[i] = random.nextInt(5000);
    }
    public void testSortAlgorithms( ) {
        //HeapSort
        long res=0,before;
        for (int i=0;i<10;++i)
        {
            HeapSort test1=new HeapSort();
            System.arraycopy(finall,0,array ,0,finall.length);
            before = System.nanoTime();
            test1.sort(array);
            before=System.nanoTime() - before;
            res=res+before;
        }
        res=res/10;
        System.out.println("Before sorted:"+toString(finall) +"SortArray2:"+toString(array)+"\nSorted with heap sort in: " +res + " nanoseconds.");
        res=0;
       //Insertion Sort
        for (int i=0;i<10;++i)
        {
            InsertionSort test2=new InsertionSort();
            System.arraycopy(finall,0,array ,0,finall.length);
            before=System.nanoTime();
            test2.sort(array);
            before=System.nanoTime()-before;
            res=res+before;
        }
        res=res/10;
        System.out.println( "Sorted with insertion sort in: " + res+ " nanoseconds.");

        res=0;
        //Merge Sort from the textbook
        for (int i=0;i<10;++i)
        {
            MergeSort test3=new MergeSort();
            System.arraycopy(finall,0,array,0,finall.length);
            before=System.nanoTime();
            test3.sort(array);
            before=System.nanoTime()-before;
            res=res+before;
        }
        res=res/10;
        System.out.println( "Sorted with merge sort (from the textbook)in: " + res + " nanoseconds.");


        //Merge Sort from the Part3
        res=0;
        for (int i=0;i<10;++i)
        {
            System.arraycopy(finall,0,array,0,finall.length);
            Part3<Integer> test4=new Part3<Integer>(array);
            before=System.nanoTime();
            test4.mergeSort();
            before=System.nanoTime()-before;
            res=res+before;
        }res=res/10;
        System.out.println("Sorted with merge sort (from the Part3)in: " + res + " nanoseconds.");

        //QuickSort
        res=0;
        for (int i=0;i<10;++i)
        {
            System.arraycopy(finall,0,array,0,finall.length);
            QuickSort test5=new QuickSort();
            before=System.nanoTime();
            test5.sort(array);
            before=System.nanoTime()-before;
            res=res+before;
        }
        res=res/10;
        System.out.println( "Sorted with quick sort  in: " + res + " nanoseconds.");


    }
    public static String toString(Object [] array) {
        StringBuffer sb = new StringBuffer("[ ");
        int len = array.length;
        for(int i = 0; i < len - 1; i++) {
            sb.append(array[i] + ", ");
        }
        sb.append(array[len - 1] + " ]");
        sb.append("\n");
        return sb.toString();
    }
}
