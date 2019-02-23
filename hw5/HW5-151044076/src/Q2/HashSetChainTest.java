package Q2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class HashSetChainTest {

    @Test
    void size() {
        HashSetChain<Integer> test=new HashSetChain<>(10);
        System.out.println("Size:"+test.size());
        test.add(14);test.add(24);
        System.out.println("Size:"+test.size());
    }

    @Test
    void isEmpty() {
        HashSetChain<Integer> test=new HashSetChain<>(10);
        System.out.println("Empty:"+test.isEmpty());
        test.add(14);test.add(24);
        System.out.println("Empty:"+test.isEmpty());
    }

    @Test
    void contains() throws Throwable {
        HashSetChain<Integer> test=new HashSetChain<>(10);
        test.add(14);test.add(24);
        test.add(10);test.add(34);
        test.add(20);test.add(94);
        test.add(60);test.add(40);
        System.out.println("contains:"+test.contains(94));
        test.remove(94);
        System.out.println("contains:"+test.contains(94));
    }

    @Test
    void containsAll() {
        HashSetChain<Integer> test=new HashSetChain<>();
        test.add(1);test.add(2);
        test.add(0);test.add(4);
        test.add(5);test.add(8);
        test.add(11);test.add(13);
        test.add(17);test.add(19);
        test.add(31);test.add(23);
        List<Integer> test2=new ArrayList<>();
        test2.add(8);
        test2.add(5);
        System.out.println(test.containsAll(test2));
        test2.add(3);
        System.out.println(test.containsAll(test2));
    }

    @Test
    void add() {
     HashSetChain<Integer> test=new HashSetChain<>(10);
        test.add(14);test.add(24);
        test.add(10);test.add(34);
        test.add(20);
        test.add(94);
        test.add(60);test.add(40);
        System.out.println(test.toString()+"\nsize="+test.size());

    }

    @Test
    void remove() {
        HashSetChain<Integer> test=new HashSetChain<>(10);
        test.add(14);test.add(24);
        test.add(10);test.add(34);
        test.add(20);test.add(94);
        test.add(60);test.add(40);
        System.out.println(test.toString());
        try {
            test.remove(94);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(test.toString());
        try {
            test.remove(20);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(test.toString());
    }
}