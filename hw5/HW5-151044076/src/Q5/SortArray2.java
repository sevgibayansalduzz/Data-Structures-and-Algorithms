package Q5;

import Q4.SortArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SortArray2 extends SortArray {
    public SortArray2(int size) {
        super(size);
    }
    @Override
    protected void create(int size)
    {
        array=new Integer[size];
        finall=new Integer[size];
        Random random = new Random();
        for(int i = 0, len = finall.length; i < len; i++)
            finall[i] = random.nextInt(5000);

    //Only difference from SortArray class
        Arrays.sort(finall, Collections.reverseOrder());
    }

}
