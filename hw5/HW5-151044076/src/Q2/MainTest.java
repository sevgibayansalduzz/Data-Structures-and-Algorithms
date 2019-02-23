package Q2;

public class MainTest {

    public static void main(String[] args) {

        ///////first array
        System.out.println("Test 1 (Table length = 10)");
        HashSetChain<Integer> test=new HashSetChain<>(10);
        System.out.println("Is set empty? :"+test.isEmpty());
        test.add(15);test.add(30);
        test.add(16);test.add(32);
        test.add(20);test.add(40);
        test.add(80);test.add(50);
        test.add(12);test.add(22);
        System.out.println("Is set empty? :"+test.isEmpty()+"Set: "+test.toString()+"\n Size of the set: "+test.size());
       try {
            test.remove(80);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Set after removing: "+test.toString());
        System.out.println("***********************************************************************");

        System.out.println("Test 2  (Table length = 14)");
        HashSetChain<Integer> test2=new HashSetChain<>(17);
        System.out.println("Is set empty? :"+test2.isEmpty());
        test2.add(15);test2.add(30);
        test2.add(16);test2.add(32);
        test2.add(20);test2.add(50);
        test2.add(80);test2.add(40);
        test2.add(12);test2.add(22);
        test2.add(17);test2.add(34);
        test2.add(54);test2.add(47);
        System.out.println("Is set empty? :"+test2.isEmpty()+"Set: "+test2.toString()+"\n Size of the set: "+test2.size());
       try {
           test2.remove(12);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Set after removing: "+test2.toString());
        try {
            test2.remove(47);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Set after removing: "+test2.toString()+"\nSet contains 30: "+test2.contains(30));

    }
}
