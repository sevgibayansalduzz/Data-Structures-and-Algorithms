package Q1;

import org.junit.jupiter.api.Test;

class RedBlackTreeTest {

    @Test
    void add() {

        RedBlackTree<String> test=new RedBlackTree<>();
        test.add("apple");
        test.add("Banana");
        test.add("grape");
        test.add("melon");
        test.add("watermelon");
        test.add("orange");
        test.add("mandarin");
        test.add("pineapple");
        test.add("apricot");
        System.out.println(test.toString());
    }

    @Test
    void delete() {
        RedBlackTree<Integer> test=new RedBlackTree<>();
        test.add(10);test.add(20);
        test.add(15);test.add(30);
        test.add(25);test.add(40);
        test.add(35);test.add(50);
        test.add(45);test.add(60);
        test.add(55);test.add(70);
        System.out.println(test.toString());
        System.out.println("*********************************************");
        test.delete(25);
        test.delete(55);
        System.out.println("After Deleting");
        System.out.println(test.toString());

    }
}