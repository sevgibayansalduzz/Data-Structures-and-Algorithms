package Part2;

import org.junit.jupiter.api.Test;

class Part2LinkedListTest {

    Part2LinkedList<String> try_it =new Part2LinkedList<>();
    void creatData()
    {
        try_it.add("A");    try_it.add("B");    try_it.add("C");    try_it.add("D");
        try_it.add("E");    try_it.add("F");    try_it.add("G");    try_it.add("H");
        try_it.add("I");    try_it.add("J");    try_it.add("K");    try_it.add("L");
    }

    @Test
    void DisableTest() {

        creatData();
        System.out.println("The first contents of the list :"+try_it);
        try_it.Disable("A");
        try_it.Disable("E");
        try_it.Disable("F");
        try_it.Disable("e");
        try_it.Disable("K");
        System.out.println("The contents of the list after the disabling\n"+try_it);
        System.out.println("\nDisables: ");
        try_it.showDisabled();
    }

    @Test
    void EnableTest() {
        creatData();
        System.out.println("The first contents of the list :"+try_it);
        try_it.Disable("A");
        try_it.Disable("E");
        try_it.add(4,"S");
        System.out.println("The contents of the list after the adding 2 items and disabling 2 items :"+try_it);
        try_it.Disable("F");
        try_it.Disable("D");
        System.out.println("The contents of the list after the disabling :"+try_it);
        System.out.println("\nDisables: ");
        try_it.showDisabled();
        try_it.Enable("A");
        try_it.Enable("F");
        try_it.Enable("E");
        try_it.Enable("S");
        try_it.Enable("K");
        try_it.Enable("D");
        System.out.println("The contents of the list after the enabling:"+try_it);
        System.out.println("Disables: \n");
        try_it.showDisabled();
    }
}