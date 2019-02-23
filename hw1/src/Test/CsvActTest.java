package Test;

import hotelmanagement.Guest;
import hotelmanagement.Room;
import org.junit.Test;

import static hotelmanagement.CsvAct.changeList;
import static hotelmanagement.CsvAct.searchCheck;
import static hotelmanagement.CsvAct.searchRoom;

public class CsvActTest {

    /**
     * This function is created to test for the function searchRoom .
     * Gives the type of the room to the function searchRoom and print messages according to searchRoom`s return.
     */
    @Test
    public void searchRoomTest() {
        int  a=searchRoom("single");
        if (a>=0)
            System.out.println("Single room is available in the hotel ");
        else
            System.out.println("Single room is not available in the hotel ");
        a=searchRoom("double");
        if (a>=0)
            System.out.println("Double room is available in the hotel ");
        else
            System.out.println("Double room is not available in the hotel ");
        a=searchRoom("suite");
        if (a>=0)
            System.out.println("Suite room is available in the hotel ");
        else
            System.out.println("Suite room is not available in the hotel ");
    }

    /**
     * This function is created to test for the function searchCheck.
     * Gives the guest`s id,name and phone number to the function searchCheck and
     * prints message according to searcCheck`s return.
     */
    @Test
    public void searchCheckTest() {
        if(searchCheck("12345612345","5567899636","sevgi",101)>=0)
            System.out.println("Records exist for sevgi!");
        if (searchCheck("11666445577","5333889966","Blair",404)>=0)
            System.out.println("Records exist for Blair!" );
    }

    /**
     * This function is created to test for the function changeList.
     * Gives the new room record to the function changeList .ChangeList changes the records
     * csv file according to room`s number.(room_id)
     */
    @Test
    public void changeListTest() {
        Guest guest=new Guest("","",0,"","","");
        Room room = new Room("single",101,"available",
                "",guest,100);
        searchRoom("single");/*ignore it*/
        changeList(room);
    }
}