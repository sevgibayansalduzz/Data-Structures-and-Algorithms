package Part2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MDSTreeTest {

    ArrayList<Integer> item1 = new ArrayList<>(),item2=new ArrayList<>(),item3 =new ArrayList<>(), item4=new ArrayList<>(),
            item5=new ArrayList<>(),item6 =new ArrayList<>(),item7=new ArrayList<>(),item8=new ArrayList<>(),
            item9=new ArrayList<>(),item10=new ArrayList<>();
    BInaryTree.Node<Integer> node;
    MDSTree< Integer> deneme;
    @Test
    void add() {

        item1.add(40); item1.add(45);item1.add(30);
        item2.add(70);item2.add(10);item2.add(15);
        item3.add(69); item3.add(50);item3.add(35);
        item4.add(15); item4.add(70);item4.add(25);
        item5.add(85); item5.add(50);item5.add(10);
        item6.add(66);item6.add(85);item6.add(45);
        item7.add(15); item7.add(80);item7.add(50);
        item8.add(13); item8.add(80);item8.add(55);
        item9.add(69);item9.add(50);item9.add(35);
        item10.add(68); item10.add(16);item10.add(30);

        node = new BInaryTree.Node<Integer> (item1);
        deneme = new MDSTree(node);

        deneme.add(item2);
        deneme.add(item3);deneme.add(item4);
        deneme.add(item5);deneme.add(item6);
        deneme.add(item7);deneme.add(item8);
        deneme.add(item9); deneme.add(item10);

        System.out.print("\nTree :"+deneme.toString());
    }

    @Test
    void contains() {
        add();
        System.out.print(deneme.contains(item6));
    }

    @Test
    void find() {
        add();
        System.out.print("Find result:"+deneme.find(item8));
    }

    @Test
    void delete() {
        add();
        deneme.delete(item3);
        System.out.println("Tree after deleting:"+deneme.toString());
    }

    @Test
    void remove() {
        add();
        deneme.remove(item3);
        System.out.print("Tree after removing:"+deneme.toString());
    }
}