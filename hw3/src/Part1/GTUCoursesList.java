
package Part1;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class includes 3 methods for accessed  courses and the courses contain all data.
 */
public class GTUCoursesList {

    /**
     *  The list hold courses and the courses contain all data on the csv file.
     */
    private LinkedList <GTUCourse> courseslist;

    /**
     *This constructor calls the read() method;The read() method reads the data in the csv file
     *  and assigns them to the list,then returns thi list.
     *  This constructor takes this return takes this returned and assigns it into courseslist.
     */
    public GTUCoursesList()
    {
        try {
            ReadCsv readfile=new ReadCsv();
            courseslist=readfile.read();
        } catch (IOException e) {
            System.out.println("File could not loaded.");
        }
    }

    /**
     * This method returns the data in the given index.
     * @param index Gets index.
     * @return Return type is GTUCourse and returns data of the course.
     */
    public GTUCourse get(int index)
    {
        return courseslist.get(index);
    }

    /**
     * This method takes the code of the course as a parameter then return all course which have given course code.
     * <p></p>
     * <p>This method searches the given code of course on the courseslist data field .If method founds matches,
     *  it assigns the matches to the coursesOfCode data field which is type LinkedList<GTUCourse> and returns the list.</p>
     * @param code  the code of the course
     * @throws NoSuchElementException If given code is not in the list ,throws excepiton.
     * @return   Returns all courses which have given course code.
     */
    public LinkedList<GTUCourse> getByeCode(String code)
    {
        LinkedList <GTUCourse> coursesOfCode=new LinkedList<>();
        for(GTUCourse course: courseslist)
            if (course.getCourseCode().equals(code))
                coursesOfCode.add(course);
        if (coursesOfCode==null)
            throw new NoSuchElementException();
        else
            return coursesOfCode;
    }

    /**
     *When the following conditions are met, the courses found are
     *assigned to the list, and the loop is returned after exiting the loop.
     *  GTUCourse course: courseslist
     *  course.getSemester()==semester
     * @param semester Takes semester as a parameter.
     *@throws NoSuchElementException If semester does not exist ,throws exception.
     * @return  Returns all courses on given semester. 
     */
    public LinkedList<GTUCourse> listSemesterCourses (int semester)
    {
        if(semester>=1 && semester<=8)
        {
            LinkedList<GTUCourse> coursesOfSemester=new LinkedList<>();
            for(GTUCourse course: courseslist)
                if (course.getSemester()==semester)
                    coursesOfSemester.add(course);
            return coursesOfSemester;
        }else
             throw new NoSuchElementException("No records found!");
    }

    /**
     *When the following conditions are met, the courses found are
     *assigned to the list, and the loop is returned after exiting the loop.
     *@for courses:coursesList
     * @if index>=start_index && index<=last_index
     * @param start_index Gets start index for courses.
     * @param last_index Gets last index for courses.
     * @throws IndexOutOfBoundsException When given indexes are out of bound throws exception.
     * @return LinkedList<GTUCourse> Returns all courses for given indexes.
     */
    public LinkedList<GTUCourse> getByRange(int start_index, int last_index)
    {
        int index=0;
        if(!(start_index>=0 && start_index<courseslist.size() &&last_index>=start_index && last_index<courseslist.size()))
            throw new IndexOutOfBoundsException("Given indexes are incorrect.");
        LinkedList<GTUCourse> courses=new LinkedList<>();
        for (GTUCourse course:courseslist)
        {
            if(index>=start_index && index<=last_index)
                courses.add(course);
            index++;
        }
        return courses;
    }
}
