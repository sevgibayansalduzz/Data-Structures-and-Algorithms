package Test;

import hotelmanagement.Guest;
import org.junit.Test;


public class GuestTest {

    /**
     * This function is created to test for the function book.
     * The function creates new guest object and calls and give the type of the to the function book.
     */
    @Test
    public void bookTest() {
        Guest guest=new Guest("11114444441","YENI",30,
                "5553335555","10/05/2018","15/05/2018");
        guest.book("double");
    }

    /**
     * This function is created to test for the function cancel.
     * The function creates new guest object and calls the function cancel.
     */
    @Test
    public void cancelTest() {
        Guest guest=new Guest("11223344776","Micheal","5023456789");
        guest.cancel(203);
    }
}
