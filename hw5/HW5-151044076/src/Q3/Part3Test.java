package Q3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Part3Test {

    @Test
    void mergeSort() {

        Part3<Integer> test=new Part3<>();
        test.addLast(40);test.addLast(15);
        test.addLast(80);test.addLast(90);
        test.addLast(24);test.addLast(43);
        test.mergeSort();
        System.out.println(test.toString());
        System.out.println(test.reversetoString());

        List<String> list=new ArrayList<>();
        list.add("A");list.add("Z");
        list.add("R");list.add("D");
        list.add("U");list.add("G");
        Part3<String> test2= new Part3<>(list);
        test2.mergeSort();
        System.out.println(test2.toString());
        System.out.println(test2.reversetoString());
    }
}