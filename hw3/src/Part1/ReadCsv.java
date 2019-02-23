package Part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class has only one method.This method reads csv file.
 */
public class ReadCsv {
    /**
     * Data field for courses.
     */
    LinkedList<GTUCourse> courseslist;

    /**
     * This method read csv file and assigned course information into the courseslist (data field).
     * @return LinkedList<GTUCourse> Return type is container .
     * @throws IOException when file cant be read.
     */
    public LinkedList<GTUCourse> read() throws IOException {
        courseslist = new LinkedList<>();
        /* open csv file input stream*/
        BufferedReader reader = new BufferedReader(new FileReader("src//Courses(CSV)(Updated).csv"));
        /* read csv file line by line*/
        String line = null;
        int index = 0;
        line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            GTUCourse lecture = new GTUCourse();
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    lecture.setSemester(Integer.parseInt(data));
                else if (index == 1)
                    lecture.setCourseCode(data);
                else if (index == 2)
                    lecture.setCourseName(data);
                else if (index == 3)
                    lecture.setECTScredits(Integer.parseInt(data));
                else if (index == 4)
                    lecture.setGTUcredits(Integer.parseInt(data));
                else if (index == 5)
                    lecture.setHTL(data);
                else/*If there is extra columns ,the data which in these columns will not upload to the courseslist*/
                    System.out.println("Invalid data:" + data);
                index++;
            }
            index = 0;/*Rows adds to the courseslist line by line*/
            courseslist.add( lecture);
        }
        //close reader
        reader.close();
        return courseslist;
    }
}
