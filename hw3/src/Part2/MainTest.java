package Part2;

import Part1.GTUCourse;
import Part1.GTUCoursesList;

import java.util.LinkedList;

public class MainTest {

    public static void main(String[] args) {
        GTUCoursesList list=new GTUCoursesList();

        /*ADDING NEW COURSES DATA INTO THE COURSES DATA FİELD*/
        Part2LinkedList<GTUCourse> courses= new Part2LinkedList<GTUCourse>(list.getByRange(0,53));

        /*PRINTING COURSES*/
        courses.print();

        /*DISABLING ITEMS*/
        LinkedList<GTUCourse> test=list.getByeCode("CSE 101");
        courses.Disable(test.getFirst());
        test.addAll(list.getByeCode("CSE 108"));
        courses.Disable(test.get(1));
        test.addAll(list.getByeCode("MATH 102"));
        courses.Disable(test.get(2));
        test.addAll(list.getByeCode("PHYS 122"));
        courses.Disable(test.get(3));
        test.addAll(list.getByeCode("PHYS 152"));
        courses.Disable(test.get(4));

        System.out.println("***********************************************************************");
        System.out.println("**LIST OF COURSES AFTER DISABLING**");
        /*PRINTING COURSES*/
        courses.print();
        System.out.println("***********************************************************************");
        System.out.println("************DISABLE COURSES********");
        courses.showDisabled();

        /*ENABLING ITEMS*/
        courses.Enable(test.get(3));
        courses.Enable(test.get(1));
        courses.Enable(test.get(4));
        courses.Enable(test.getFirst());

        System.out.println("***********************************************************************");
        System.out.println("**LIST OF COURSES AFTER ENABLING**");
        courses.print();


        System.out.println("***********************************************************************");
        System.out.println("************DISABLE COURSES********");
        /*SHOWING DISABLE ITEMS*/
        courses.showDisabled();


    }

}
