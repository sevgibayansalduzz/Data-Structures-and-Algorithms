package Part3;

import Part1.GTUCoursesList;
import org.junit.jupiter.api.Test;

class GTULinkListTest {

    private GTUCoursesList list= new GTUCoursesList();
    private GTULinkList try_linkedlist=new GTULinkList ();
    @Test
    void add() {
        try_linkedlist.add(list.get(0));
        System.out.println(try_linkedlist.get(0));
    }

    @Test
    void remove() {
        try_linkedlist.add(list.get(2));
        System.out.println(try_linkedlist.get(0));
        try_linkedlist.remove(0);
        try{
            System.out.println(try_linkedlist.get(0));
        }catch (IndexOutOfBoundsException e)
        {
            System.out.println("List is empty.");
        }
    }

    @Test
    void size() {
        try_linkedlist.add(list.get(2));
        try_linkedlist.add(list.get(0));
        System.out.println(try_linkedlist.size());
    }

    @Test
    void next() {
        try_linkedlist.add(list.get(2));
        try_linkedlist.add(list.get(3));
        try_linkedlist.add(list.get(4));
        try_linkedlist.add(list.get(5));
        for (int i=0;i<try_linkedlist.size();++i)
            System.out.println(try_linkedlist.get(i));

        System.out.println("\nNext of the "+try_linkedlist.get(1).getCourseName()+" is "+
                try_linkedlist.Next(1).getData().getCourseName());
    }

    @Test
    void nextInSemester() {
            try_linkedlist.add(list.get(2));
            try_linkedlist.add(list.get(10));
            try_linkedlist.add(list.get(4));
            try_linkedlist.add(list.get(8));
            for (int i=0;i<try_linkedlist.size();++i)
                System.out.println(try_linkedlist.get(i));

            System.out.println("\nNext course of the same semester is "+try_linkedlist.get(0).getCourseName()
                    +" is "+try_linkedlist.nextInSemester(0).getData().getCourseName());
    }
}