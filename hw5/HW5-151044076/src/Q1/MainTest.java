package Q1;

public class MainTest {

    public static void main(String[] args) {

        System.out.println("Test 1 ");
        DoubleHashingMap<String,Integer> test1=new DoubleHashingMap<>();

        System.out.println("IS EMPTY:"+test1.isEmpty());
        test1.put("First",1);
        test1.put("Second",2);
        test1.put("Z",29);
        test1.put("F",7);
        test1.put("I",10);
        test1.put("E",6);
        test1.put("D",5);
        System.out.println("IS EMPTY:"+test1.isEmpty()+"\n SIZE: "+test1.size());
        try {
            System.out.print("The value of Z is : ");
            System.out.println(test1.get("Z"));
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
