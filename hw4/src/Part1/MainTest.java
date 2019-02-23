package Part1;

public class MainTest {
    public static void main(String[] args) {

        Part1Tree deneme=new Part1Tree<String>();
        deneme.add("William I");
        deneme.add("William I","Robert");
        deneme.add("Robert","William");
        deneme.add("William I","William II");
        deneme.add("William I","Adela");
        deneme.add("William I","Henry I");
        deneme.add("Adela","Stephen");
        deneme.add("Henry I","Matilda");
        deneme.add("Matilda","Henry II");
        deneme.add("Henry II", "John");
        deneme.add("Henry II", "Geofffrey");
        deneme.add("Geofffrey","Arthur");
        System.out.println( deneme.add("Al", "s"));
        System.out.println("ToString method uses PreOrderTraverse method:"+deneme.toString());

        System.out.println("\n\nLevel Order:\n");
        try {
            System.out.println("\nReturn Data:"+deneme.levelOrderSearch("Arthur"));
        }catch (NullPointerException e)
        {
            System.out.println("null");
        }


        System.out.println("\n\nPost Order:\n");
        try {
            System.out.println("\n" + "Return Data:"+deneme.postOrderSearch("William I"));
        }catch (NullPointerException e)
        {
            System.out.println("null");
        }

    }
}
