package hotelmanagement;


/**
 * @author sevgi
 * @see hotelmanagement.CsvAct
 * @see hotelmanagement.User
 */
public class Guest extends CsvAct implements User{
    /**
     * This member variable holds guest`s id.
     */
    private String guestId;
    /**
     * This member variable holds the name of the guest.
     */
    private String guestName;
    /**
     * This member variable holds the age of the guest.
     */
    private int age;
    /**
     * This member variable holds the phone number of the guest.
     */
    private String phone;
    /**
     * This member variable holds the check in date for the guest.
     */
    private String datein;
    /**
     * This member variable holds the check out date for the guest.
     */
    private String dateout;

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
    public  Guest(String guestId,String guestName, int age,String phone,String  in,String out){
        this.guestId=guestId;
        this.guestName=guestName;
        this.age=age;
        this.phone=phone;
        this.datein=in;
        this.dateout=out;
    }
    /**
     * Default constructor does nothing.
     */
    public Guest() {  }

    /**
     * This constructor, respectively takes these parameters: the id,name and phone of the guest.
     * Then initialize them to the member variable.
     * <p>This constructor -is in the process of book,check in or check out - to verify the identity of the guest was created.</p>
     * @param guestId The identification number of the guest.
     * @param guestName The name of the guest.
     * @param phone The phone number of the guest.
     */
    public Guest(String guestId, String guestName, String phone) {
        this.guestId=guestId;
        this.guestName=guestName;
        this.phone=phone;
    }

    /**
     * This function takes the type of the room as a parameter.Then then sends this parameter as a parameter to function searchRoom.
     *The search function returns the number of rows in the csv file of this room if there is a room in the hotel which type is equals to this parameter type.
     *
     * <p>Then this method creates a new room object- which holds room availability as not available- and sends it to the changeList method to print the new record in to the csv file.</p>
     * @param room_type The type of the room.
     */
    @Override
    public void book(String room_type)  {
        int index=searchRoom(room_type);
        if (index<0)/*if index is less than zero that means empty room can not find*/
            System.out.println("There is no available "+room_type+" room!");
        else
        {
            int roomNo=roomlist.get(index).getRoomid();
            /*New room object is created.Room will be not available*/
            Room room = new Room(room_type,roomNo,"not available","book",this,roomlist.get(index).getRoomcharge());
            /*The changes are saved to the csv file*/
            changeList(room);
            System.out.println("Room "+roomNo+" is booked.");
        }
    }

    /**
     * When a guest or receiver object invokes this function,firstly sends the informations
     * about the guest which object`s member variables holds,
     * to the searcCheck function to checks whether there is record is related to  the object.
     * If records found, room object will be created -which holds room availability as not available-
     * and new information updated to the csv file with changeList function.
     */
    @Override
    public void cancel(int room_no){
        int index;
        if((index=searchCheck(getGuestid(),getPhone(),getGuestname(),room_no))>=0 && roomlist.get(index).getStatu().equals("book"))
        {
            Guest guest=new Guest("","",0,"","","");

            int roomNo=roomlist.get(index).getRoomid();
            /*New room object is created.Room will be available*/
            Room room = new Room(roomlist.get(index).getRoomtype(),roomNo,"available","",guest,roomlist.get(index).getRoomcharge());
            changeList(room);
            System.out.println("Reservation for room "+roomNo+ " is canceled. ");
        }
    }
    /**
     * Writes class information.
     * @return  Return type is a string.
     */
    @Override
    public String toString()
    {
        return " Guest Id:"+getGuestid()+" Guest Name:"+getGuestname()+" Guest Age:"+getAge()+
                " Get Phone:"+getPhone()+ " In Date:"+getDatein()+" Out Date:"+getDateout();
    }

    /**
     * Getter for guestId.
     * @return Returns String.
     */
    public String getGuestid() { return guestId;  }

    /**
     * Setter for guestId
     * @param guestId The id of the guest.
     */
    public void setGuestid(String guestId) {  this.guestId=guestId; }

    /**
     * Getter for guestName.
     * @return Returns String.
     */
    public String getGuestname() {  return guestName; }

    /**
     * Setter for the guestName.
     * @param guestName The name of the guest.
     */
    public void setGuestname(String guestName) { this.guestName=guestName; }

    /**
     * Getter for the age.
     * @return Returns integer.
     */
    public int getAge() {return age; }

    /**
     * Setter for the age.
     * @param age The age of the guest.
     */
    public void setAge(int age) { this.age=age;}

    /**
     * Getter for the phone.
     * @return Returns String.
     */
    public String getPhone() { return phone; }

    /**
     * Setter for the phone.
     * @param phone The phone number of the guest.
     */
    public void setPhone(String phone) { this.phone=phone; }

    /**
     * Getter for the datein.
     * @return Returns String.
     */
    public String getDatein() {  return datein;  }

    /**
     * Setter for the datein.
     * @param datein The check in date for the guest.
     */
    public void setDatein(String datein) {   this.datein = datein; }

    /**
     * Getter for the dateout.
     * @return Returns String.
     */
    public String getDateout() {   return dateout;    }

    /**
     * Setter for the datein.
     * @param dateout The check in date for the guest.
     */
    public void setDateout(String dateout) { this.dateout = dateout;  }
}
