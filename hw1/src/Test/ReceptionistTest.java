package Test;

import hotelmanagement.Receptionist;
import org.junit.Test;


public class ReceptionistTest {

    /**
     * This function is created to test for the function check_in().
     * The function creates new receptionist object and calls the function check_in for the test.
     */
    @Test
    public void check_in() {
        Receptionist rec=new Receptionist("15104447899","Alexander","5311234567");
        rec.check_in(103);
    }

    /**
     * This function is created to test for the function check_in(String type).
     * The function creates new receptionist object and calls the function check_in for the test.
     */
    @Test
    public void check_in1() {
        Receptionist rec=new Receptionist("15555511111","YENI",30,
                "5663335555","10/06/2018","15/06/2018");
        rec.check_in("single");
    }

    /**
     * This function is created to test for the function check_out.
     * The function creates new receptionist object and calls the function check_out for the test.
     */
    @Test
    public void check_out() {
        Receptionist rec=new Receptionist("11223344556","Lincoln","5558889966");
        rec.check_out(304);
    }

}