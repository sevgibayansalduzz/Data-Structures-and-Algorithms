package Q1;

/**To worst-case*/
public class MainTest {
    public static void main(String[] args) {
        RedBlackTree<String> test=new RedBlackTree<>();
        for(char i='A';i<='V';++i)
        {
            test.add(String.valueOf(i));
            System.out.print(i+"-");
        }
        System.out.println(test.toString());
    }
}
