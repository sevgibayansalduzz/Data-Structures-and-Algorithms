package Q1;

import org.junit.jupiter.api.Test;

class DoubleHashingMapTest {
    @Test
    void size() {
        DoubleHashingMap<String,Integer> test1=new DoubleHashingMap<>();
        test1.put("First",1);
        test1.put("Second",2);
        test1.put("Third",3);
        System.out.println("Size of the test1: "+test1.size());
        test1.put("Fourth",4);
        test1.put("Fifth",5);
        System.out.println("After adding two element,size of the test1: "+test1.size());
    }

    @Test
    void isEmpty() {
        DoubleHashingMap<String,Integer> test1=new DoubleHashingMap<>();
        System.out.println("Is the test1  empty?: "+test1.isEmpty());
        test1.put("First",1);
        test1.put("Second",2);
        test1.put("Third",3);
        System.out.println("After adding two element,Is the test1 empty?: "+test1.isEmpty());
    }

    @Test
    void get() {
        DoubleHashingMap<String,Integer> test1=new DoubleHashingMap<>();
        test1.put("First",1);
        test1.put("Second",2);
        test1.put("Third",3);
        System.out.println("The value of First is : "+test1.get("First"));
    }

    @Test
    void put() {
        DoubleHashingMap<String,Integer> test1=new DoubleHashingMap<>();
        test1.put("First",1);
        System.out.println("Is adding elements successful?: "+!test1.isEmpty());
        System.out.println("Size of the test1: "+test1.size());
        System.out.println("The value of First is : "+test1.get("First"));
    }

    @Test
    void remove() {
        DoubleHashingMap<String,Integer> test1=new DoubleHashingMap<>();
        test1.put("First",1);
        test1.put("Second",2);
        test1.put("Third",3);
        try {
            System.out.print("The value of Second is : ");
            System.out.println(test1.get("Second"));
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        test1.remove("Second");
        try {
            System.out.print("After removing,The value of Second is :");
            System.out.println(test1.get("Second"));
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        test1.remove("Second");
    }
}