package hotelmanagement;

/**
 * @author sevgi
 */

public class Room {
    /**
     * This member variable holds the room`s number.
     */
    private int room_id;
    /**
     * This member variable holds the type of the room.
     */
    private String room_type;
    /**
     * This member variable holds the availability of the room.
     */
    private String room_availability;
    /**
     * This member variable holds the information about guest.
     */
    protected Guest guest=new Guest();
    /**
     * This member variable holds the statu of the room.(For example the room is booked,checked in or checked out.)
     */
    private String statu;
    /**
     * This member variable hold the cost of the room.
     */
    private int room_charge;

    /**
     * Default constructor does nothing.
     */
    public Room(){}

    /**
     * This constructor, respectivey takes these parameters: the type of the room, the room`s number ,availability of the room,
     * statu of the room,the information of the guest and the cost of the room.
     * <p>Then initialize them to the member variable.</p>
     * @param room_type The type of the room.
     * @param room_id   The room`s number.
     * @param room_availability Availability of the room.
     * @param statu Statu of the room.
     * @param guest The information about the guest.
     * @param room_charge The cost of the room.
     */
    public Room(String room_type, int room_id, String room_availability, String statu, Guest guest, int room_charge)
    {
        this.room_type=room_type;
        this.room_id=room_id;
        this.room_availability=room_availability;
        this.statu=statu;
        this.guest=guest;
        this.room_charge=room_charge;
    }

    /**
     * Getter for the member variable room_id.
     * @return Return type is integer. Returns the member variable room_id,
     */
    public int getRoomid() {
        return room_id;
    }

    /**
     * Setter for room_id.Takes the room`s number as a parameter.
     * @param room_id   The room`s number.
     */
    public void setRoomid(int room_id) {
        this.room_id=room_id;
    }

    /**
     * Getter for the member variable room_type.
     * @return Return type is string.Returns the member variable room_type;
     */
    public String getRoomtype() {
        return room_type;
    }

    /**
     * Setter for room_type.Takes the type of the room as a parameter.
     * @param room_type The type of the room.
     */
    public void setRoomtype(String room_type) {
        this.room_type=room_type;
    }

    /**
     * Getter for the member variable room_availability.
     * @return Return type is string.Returns the member variable room availability.
     */
    public String getRoomavailability() {
        return room_availability;
    }

    /**
     * Setter for room availability.Takes the availability of the room as a parameter.
     * @param room_availability The availability of the room.
     */
    public void setRoomavailability(String room_availability) {
        this.room_availability=room_availability;
    }

    /**
     * Getter for the member variable statu.
     * @return Return type is string.Returns the member variable statu.
     */
    public String getStatu() { return statu;   }

    /**
     * Setter for statu.Takes the statu of the room as a parameter.
     * @param statu The statu of the room.
     */
    public void setStatu(String statu) { this.statu=statu; }

    /**
     *Getter for the member variable room_charge.
     * @return Return type is integer.Returns the member variable room_charge.
     */
    public int getRoomcharge() { return room_charge; }

    /**
     * Setter for room_charge.Takes the cost of the room as a parameter.
     * @param room_charge The cost of the room.
     */
    public void setRoomcharge(int room_charge) { this.room_charge=room_charge;}

    /**
     * Writes class information.
     * @return  Return type is a string.
     */
    @Override
    public String toString(){
        return "\nRoom Id="+getRoomid()+" Room Type="+getRoomtype()+"Room Availability="
                +getRoomavailability()+" "+guest.toString()+" Room Statu:"+getStatu()+
                " Room charge: "+getRoomcharge();

    }
}
