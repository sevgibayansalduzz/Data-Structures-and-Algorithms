package Part2;

import java.util.ArrayList;

public class MainTest {

    public static void main(String[] args) {

        ArrayList<Integer> item1 = new ArrayList<>(),item2=new ArrayList<>(),item3 =new ArrayList<>(), item4=new ArrayList<>(),
                item5=new ArrayList<>(),item6 =new ArrayList<>(),item7=new ArrayList<>(),item8=new ArrayList<>(),
                item9=new ArrayList<>(),item10=new ArrayList<>(),item11=new ArrayList<>(),item12=new ArrayList<>();
        item1.add(40); item1.add(45);
        item2.add(70);item2.add(10);
        item3.add(69); item3.add(50);
        item4.add(15); item4.add(70);
        item5.add(85); item5.add(50);
        item6.add(66);item6.add(85);
        item7.add(15); item7.add(80);
        item8.add(13); item8.add(80);
        item9.add(40); item9.add(30);
        item10.add(75); item10.add(10);
        item11.add(69);item11.add(50);
        item12.add(68); item12.add(16);

        BInaryTree.Node<Integer> node = new BInaryTree.Node<Integer> (item1);
        MDSTree< Integer> deneme = new MDSTree(node);
        deneme.add(item2);
        deneme.add(item3);deneme.add(item4);
        deneme.add(item5);deneme.add(item6);
        deneme.add(item7);deneme.add(item8);
        deneme.add(item9); deneme.add(item10);
        deneme.add(item11);deneme.add(item12);

      //  System.out.println(deneme.toString());
        //System.out.println(deneme.find(item7));
        System.out.println(deneme.delete(item10));
        System.out.println("fghjk\n");
        System.out.println(deneme.toString());
    }
}
