package Part1;

/**
 * @author sevgi
 */

/**
 *  GTUCourse structure has data fields that represent course properites.
 */
public class GTUCourse {

    /**
     * This data field stores the semester of the course.
     */
    private int Semester;
    /**
     * This data field stores the code of the course.
     */
    private String CourseCode;
    /**
     * This data field stores the name of the course.
     */
    private String CourseName;
    /**
     * This data field stores the H+T+L of the course.(T: Theory , L: Laboratory)
     */
    private String HTL;
    /**
     * This data field stores the ECTS credits of the course.
     */
    private int ECTScredits;
    /**
     * This data field stores the GTU credits of the course.
     */
    private int GTUcredits;


    /**
     * This constructor, respectively takes these parameters:semester of the course,code of the course,name of the course,
     * H+T+L of the course,ECTS and GTtu credits of the course.
     *
     * @param Semester  The semester of the course
     * @param CourseCode The code of the course
     * @param CourseName  The  name of the course
     * @param HTL     The H+T+L of the course
     * @param ECTScredits The  ECTS credits of the course
     * @param GTUcredits  The  GTU credits of the course
     */
    public GTUCourse(int Semester, String CourseCode, String CourseName, String HTL, int ECTScredits, int GTUcredits) {
        this.Semester = Semester;
        this.CourseCode = CourseCode;
        this.CourseName = CourseName;
        this.HTL = HTL;
        this.ECTScredits = ECTScredits;
        this.GTUcredits = GTUcredits;
    }
    /*DEfault constructor does nothing*/
    public GTUCourse()
    { }

    /**
     * Writes course information.
     * @return  Return type is a string.
     */
    @Override
    public String toString() {
        return "Semester: "+getSemester()+", Course Code: "+getCourseCode()+", Course Name: "+getCourseName()+", ECTS: "+getECTScredits()
                + ", GTU Credits: "+getGTUcredits()+", H+T+L: "+getHTL();
    }

    /**
     * Getter method for semester.
     * @return Return type is a integer.
     */
    public int getSemester() {
        return Semester;
    }

    /**
     * Setter method for semester.
     * @param Semester Semester of the course.
     */
    public void setSemester(int Semester) {
        this.Semester = Semester;
    }

    /**
     * Getter method for the code of course.
     * @return Return type is a String.
     */
    public String getCourseCode() {
        return CourseCode;
    }

    /**
     * Setter method for the code of the course.
     * @param  CourseCode code of the course.
     */
    public void setCourseCode(String CourseCode) {
        this.CourseCode = CourseCode;
    }

    /**
     * Getter method for the name of course.
     * @return Return type is a String.
     */
    public String getCourseName() {
        return CourseName;
    }

    /**
     * Setter method for the name of the course.
     * @param  CourseName name of the course.
     */
    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    /**
     * Getter method for the H+T+L of course.
     * @return Return type is a String.
     */
    public String getHTL() {
        return HTL;
    }

    /**
     * Setter method for the H+T+L of the course.
     * @param  HTL H+T+L of the course.
     */
    public void setHTL(String HTL) {
        this.HTL = HTL;
    }

    /**
     * Getter method for ECTS credits of the course.
     * @return  Return type is a integer.
     */
    public int getECTScredits() {
        return ECTScredits;
    }

    /**
     * Setter method for the ECTS credits of the course.
     * @param  ECTScredits ECTS credits of the course.
     */
    public void setECTScredits(int ECTScredits) {
        this.ECTScredits = ECTScredits;
    }

    /**
     * Getter method for GTU credits of the course.
     * @return  Return type is a integer.
     */
    public int getGTUcredits() {
        return GTUcredits;
    }

    /**
     * Setter method for the GTU credits of the course.
     * @param  GTUcredits H+GTU+L of the course.
     */
    public void setGTUcredits(int GTUcredits) {
        this.GTUcredits = GTUcredits;
    }
}
