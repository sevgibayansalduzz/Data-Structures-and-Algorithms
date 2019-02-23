package Q2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTreeTest {
    @Test
    void add() {
        BTree<Integer> test = new BTree<>(4);
        test.add(20);test.add(30);test.add(8);test.add(10);
        test.add(15);test.add(18);test.add(44);test.add(26);
        test.add(28);test.add(23);test.add(25);test.add(43);
        System.out.print(test.toString());
    }
}