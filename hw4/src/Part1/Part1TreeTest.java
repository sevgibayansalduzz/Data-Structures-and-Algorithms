package Part1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Part1TreeTest {

    /**
     * Test for the add method that adds the first element into the tree.
     */
    @Test
    void add() {
        Part1Tree test=new Part1Tree<String>();
        test.add("First Item");
        System.out.println(test.toString());
    }

    /**
     * Test for the add method that adds the given ChildItem according to given ParentItem into the tree.
     */
    @Test
    void add1() {
        Part1Tree test=new Part1Tree<String>();
        test.add("A");
        test.add("A","B");
        test.add("A","C");
        test.add("A","D");
        test.add("A","E");
        test.add("A","F");
        test.add("B","G");
        test.add("B","H");
        test.add("E", "I");
        test.add("E", "J");
        test.add("G","K");
        test.add("G","L");
        test.add("I", "M");
        test.add("J", "N");
        System.out.println("Test for add\n ToString method is called(ToString method uses PreOrderTraverse method):  "+test.toString());
    }

    @Test
    void levelOrderSearch() {
        Part1Tree test=new Part1Tree<String>();
        test.add("A");
        test.add("A","B");
        test.add("A","C");
        test.add("A","D");
        test.add("A","E");
        test.add("A","F");
        test.add("B","G");
        test.add("B","H");
        test.add("E", "I");
        test.add("E", "J");
        test.add("G","K");
        test.add("G","L");
        test.add("I", "M");
        test.add("J", "N");
        System.out.print("Level order traverse: ");
        System.out.print("\nReturn:"+test.levelOrderSearch("N"));
    }

    @Test
    void postOrderSearch() {
        Part1Tree test=new Part1Tree<String>();
        test.add("A");
        test.add("A","B");
        test.add("A","C");
        test.add("A","D");
        test.add("A","E");
        test.add("A","F");
        test.add("B","G");
        test.add("B","H");
        test.add("E", "I");
        test.add("E", "J");
        test.add("G","K");
        test.add("G","L");
        test.add("I", "M");
        test.add("J", "N");
        System.out.print("Post order traverse: ");
        System.out.print("\nReturn:"+test.postOrderSearch("N"));
    }

}