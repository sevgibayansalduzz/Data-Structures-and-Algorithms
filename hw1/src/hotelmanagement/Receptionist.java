package hotelmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author sevgi
 * @see hotelmanagement.User
 * @see hotelmanagement.Guest
 * @see hotelmanagement.CsvAct
 */
public class Receptionist extends Guest {
    /**
     * This member variable keeps the password of the receptionist.
     */
    private String receptionist_password="5646";

    /**
     * Getter for the password of the receptionist.
     * @return Returns String.
     */
    public String getReceptionist_password(){ return receptionist_password;}

    /**
     * Default constructor.
     */
    public Receptionist() {
    }

    /*** This constructor, respectively takes these parameters: the id,name and phone of the guest.
     * Then initialize them to the member variable.
     * <p>This constructor -is in the process of book,check in or check out - to verify the identity of the guest was created.</p>
     * @param id The identification number of the guest.
     * @param name  the name of the guest.
     * @param phone the phone number of the guest.
     */
    public Receptionist(String id, String name, String phone) {
        super(id, name,phone);
    }

    /**
     * This constructor, respectivey takes these parameters: the id,name ,age, phone number, check in date
     * and check out date of the guest.
     * <p>Then initialize them to the member variable.</p>
     * @param guestId The id of the guest.
     * @param guestName The name of the guest.
     * @param age   The age of the guest.
     * @param phone The phone of the guest.
     * @param in    The check in date of the guest.
     * @param out   The check out date of the guest.
     */
    public Receptionist(String guestId, String guestName, int age, String phone,String in,String out) {
        super(guestId, guestName, age, phone, in,out);
    }

    /**
     *This function makes check-in to the hotel.
     * Firstly, it inquires whether there is a record according to the input received from the user.
     * This record`s variable of the room statu must be equal to "book".İf conditions are met ,check in will be happen.
     * @return Returns boolean.If check in will be successfully returns true else return false.
     */
    public boolean check_in(int room_no)
    {
        int index;
        if((index=searchCheck(getGuestid(),getPhone(),getGuestname(),room_no))>=0 && roomlist.get(index).getStatu().equals("book"))
        {
            int roomNo=roomlist.get(index).getRoomid();
            Guest guest=new Guest(getGuestid(),roomlist.get(index).guest.getGuestname(),roomlist.get(index).guest.getAge(),
        roomlist.get(index).guest.getPhone(),roomlist.get(index).guest.getDatein(),roomlist.get(index).guest.getDateout());
        /*New object is created and this object`s availability wiil be "not available,statu will be "check in"*/
            Room room = new Room(roomlist.get(index).getRoomtype(),roomlist.get(index).getRoomid(),"not available","check in",guest,roomlist.get(index).getRoomcharge());
            changeList(room);
            System.out.println(toString());
            System.out.println("Checked in of the room "+roomNo+".");
            return true;
        }
        return  false;
    }

    /**
     * This function makes check-in to the hotel,if the first check_in() function returns false.
     * The function takes the type of the room as a parameter.
     * Then sends this parameter as a parameter to function searchRoom.
     *The search function returns the number of rows in the csv file of this room if there is a room
     * in the hotel which type is equals to this parameter type.
     * Then this method creates a new room object- which holds room availability as not available-
     * and sends it to the changeList method to print the new record in to the csv file.
     * @param type The type of the room.
     */
    public void check_in(String type) {
        int index=searchRoom(type);
        if (index<=0)
        {
            System.out.println("There is no available "+type+" room!");
        }else
        {
            int roomNo=roomlist.get(index).getRoomid();
            /*New object is created and this object`s availability wiil be "not available,statu will be "check in"*/
            Room room = new Room(type,roomNo,"not available","check in",this,roomlist.get(index).getRoomcharge());
            changeList(room);
            System.out.println(toString());
            System.out.println("Checked in of the room "+roomNo+" .");
        }
    }

    /**
     * This function makes check-out to the hotel.
     * Firstly, it inquires whether there is a record according to the input received from the user.
     * This records`s variable of the room statu must be equal to "check in".İf conditions are met ,
     * check in will be happen.
     * <p>The number of days between the input and output dates will be found by the auxiliary functions.
     * Then the day is multiplied by the cost of the room and bill will be printed on the screen.
     * </p>
     */
    public void  check_out(int room_no)
    {
        int index;
        if((index=searchCheck(getGuestid(),getPhone(),getGuestname(),room_no))>=0 && roomlist.get(index).getStatu().equals("check in"))
        {
            Guest guest=new Guest("","",0,"","","");
            int roomNo=roomlist.get(index).getRoomid();

            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
            String indate=roomlist.get(index).guest.getDatein();
            String outdate=roomlist.get(index).guest.getDateout();

            int day = 0;
            try {
                day = (int) ((myFormat.parse(outdate).getTime() - myFormat.parse(indate).getTime()) / (1000*60*60*24));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            int charge=day *roomlist.get(index).getRoomcharge();

            Room room = new Room(roomlist.get(index).getRoomtype(),roomNo,"available","",guest,roomlist.get(index).getRoomcharge());
            changeList(room);
            System.out.println(toString());
            System.out.println("Checked out of the room "+roomNo+". Dear customer, your bill is "+charge+" dollars.");
        }
    }
    @Override
    public String toString()
    {
        return "Receptionist made operation for person with information below\n" +
                " Guest Id:"+getGuestid()+" Guest Name:"+getGuestname()+" Guest Phone:"+getPhone();
    }
}
