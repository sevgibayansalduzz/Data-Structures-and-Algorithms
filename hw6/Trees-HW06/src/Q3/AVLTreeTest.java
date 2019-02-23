package Q3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    void add() {
        AVLTree<String> tree=new AVLTree<>();
        tree.add("Pineapple");
        tree.add("strawberry");
        tree.add("apple");
        tree.add("banana");
        tree.add("grape");
        tree.add("orange");
        tree.add("pineapple");
        tree.add("mandarin");
        tree.add("cherry");
        System.out.println(tree.toString());
    }

    @Test
    void is()
    {
         BinarySearchTree<Integer> tree=new BinarySearchTree();
         tree.add(10);
         tree.add(15);
         tree.add(25);
         tree.add(20);
         System.out.println(tree);
         AVLTree<Integer> test=new AVLTree<>(tree);

        BinarySearchTree<Integer> tree2=new BinarySearchTree();
        tree2.add(10);
        tree2.add(8);
        tree2.add(25);
        tree2.add(20);
        System.out.println(tree);
        AVLTree<Integer> test2=new AVLTree<>(tree2);
    }
}