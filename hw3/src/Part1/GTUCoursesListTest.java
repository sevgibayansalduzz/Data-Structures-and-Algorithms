package Part1;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.NoSuchElementException;


/**
 * Test class for GTUCOursesList class.
 */
class GTUCoursesListTest {

    /**
     * @Test Test for getByeCode method.
     */
    @Test
    void getByeCodeTest() {
        GTUCoursesList list=new GTUCoursesList();
        LinkedList<GTUCourse> courses=list.getByeCode("XXX XXX");
        if(courses!=null)
            for (GTUCourse c:courses)
                System.out.println(c);
        System.out.println("*****************");
        courses=list.getByeCode("EN 111");
        System.out.println(courses.getFirst());
        System.out.println("*****************");
        try {
            courses=list.getByeCode("AAA");
            for (GTUCourse c:courses)
                System.out.println(c);
        }catch (NoSuchElementException e)
        {
            System.out.println("No records found for given code");
        }
    }


     /**
     * @Test Test for listSemesterCourses method.
     */
    @Test
    void listSemesterCoursesTest() {
        GTUCoursesList list=new GTUCoursesList();
        LinkedList<GTUCourse> courses=list.listSemesterCourses(8);
        try {
            for (GTUCourse c:courses)
                System.out.println(c);
            System.out.println("*****************");
            courses=list.listSemesterCourses(10);
            System.out.println(courses);
        }catch (NoSuchElementException e)
        {
            System.out.println(e);
        }

    }

    /**
     * @Test Test for getByRange method.
     */
    @Test
    void getByRangeTest() {
        GTUCoursesList list=new GTUCoursesList();

        try{
            LinkedList<GTUCourse> courses=list.getByRange(0,10);
            for (GTUCourse c:courses)
                System.out.println(c);
            System.out.println("*****************");
            courses=list.getByRange(30,60);
            System.out.println(courses);
        }catch (IndexOutOfBoundsException e)
        {
            System.out.println(e);
        }

    }

}