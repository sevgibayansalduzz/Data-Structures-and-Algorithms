package hotelmanagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sevgi
 * Class CsvAct is created for actions on csv file.
 */
public class CsvAct{

    /**
     *The room information in the csv file is read and kept temporarily in this member variable.
     */
    protected static List<Room> roomlist;

    /**
     * This function reads the Csv file and uploads the information to into the member
     * variable roomlist, which holds the room objects list.
     * @throws IOException
     */
    private static void  read() throws IOException {
        roomlist = new ArrayList<>();
        /* open csv file input stream*/
        BufferedReader reader = new BufferedReader(new FileReader("src//room.csv"));
        /* read csv file line by line*/
        String line = null;
        int index = 0;
        line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            Room room = new Room();
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    room.setRoomtype(data);
                else if (index == 1)
                    room.setRoomid(Integer.parseInt(data));
                else if (index == 2)
                    room.setRoomavailability(data);
                else if (index == 3)
                    room.guest.setGuestid(data);
                else if (index == 4)
                    room.guest.setGuestname(data);
                else if (index == 5)
                    room.guest.setAge(Integer.parseInt(data));
                else if (index == 6)
                    room.guest.setPhone(data);
                else if (index == 7)
                    room.guest.setDatein(data);
                else if (index==8)
                    room.guest.setDateout(data);
                else if (index == 9)
                    room.setStatu(data);
                else if (index == 10)
                    room.setRoomcharge(Integer.parseInt(data));
                else/*If there is extra columns ,the data which in these columns will not upload to the roomlist*/
                    System.out.println("Invalid data:" + data);
                index++;
            }
            index = 0;/*Rows adds to the roomlist line by line*/
            roomlist.add(room);
        }
        //close reader
        reader.close();
    }

    /**
     * @param room_type
     * @return Return type is integer.If hotel has available room ,
     * this function returns roomlist index which holds available room information else returns -1.
     */
    public static int searchRoom(String room_type) {
        try {
            /* read file line by line*/
            read();
        }catch (IOException e) {
            e.printStackTrace();
        }
        int index=0;
        for(Room r:roomlist)
        {
            if(r.getRoomtype().equals(room_type))
              if(r.getRoomavailability().equals("available") )
                  return index;/*If room is available returns index.*/
            index++;
        }
        return -1;/*else return -1*/
    }

    /**The searcCheck function checks whether there is record is related to the object informations.
     * If records found ,this function returns the index of the roomlist which holds record is related to
     * given informations as parameters.
     * @param id The id of the guest.
     * @param phone The phone of the guest.
     * @param name The name of the guest.
     * @param room_no The room`s number.
     * @return Return type is integer.Returns index or -1 according to conditions.
     */
    public static int searchCheck(String id,String phone,String name,int room_no)
    {
        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int index=0;
        for(Room r:roomlist)
        {
            /*if identification numbers does not found,the function prints "No record foun!"*/
            if(r.guest.getGuestid().equals(id))
            {
                /*if phone numbers does not match, the function prints the message below.*/
                if(!(r.guest.getPhone().equals(phone)))
                {
                    System.out.println("Phone number does not match!!");
                    return -1;
                }/*if names does not match, the function prints the message below.*/
                else if(!(r.guest.getGuestname().toLowerCase().equals(name.toLowerCase())))
                {
                    System.out.println("Name does not match!!");
                    return -1;
                }else if(r.getRoomid() != room_no)
                {
                    System.out.println("There is no room at this number or the user information for this room is incorrect.");
                    return -1;
                }
                else
                    return index;
            }
            index++;
        }
        System.out.println("No records found!");
        return -1;
    }

    /**
     * The function takes the argument parameter the object room number given as a parameter for
     * comparison. Then the function makes changes to  the contents of the roomlist according to
     * the function room parameter.
     * @param room The function takes room object as a parameter.
     */
    public static void changeList(Room room)
    {
        int count=0;
        for(Room r:roomlist)
        {
            /*Room ids compares*/
            if(r.getRoomid()==room.getRoomid())
            {
                room.setRoomcharge(r.getRoomcharge());
                roomlist.set(count,room);
                try {
                    System.out.println("Room "+room.getRoomid()+" information were updated.");
                    write();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            count++;
        }
    }

    /**
     * Write variable header and rooms recors into the Csv file.
     * @throws IOException
     */
    private static void write() throws IOException {
        String COMMA_DELIMITER=",";
        String SEPARATOR="\n";
        String HEADER="Room Type,Room Id,Availability,Guest Id,Guest Name,Guest Age,Guest Phone,Datein,Dateout,Statu,Charge";
        FileWriter filewriter= new FileWriter("src//room.csv");
        /*Header will not add in to the roomlist variable*/
        filewriter.append(HEADER);
        for (Room r:roomlist)
        {
            /*Respectively,function will be add information into the csv file.(separator,information,delimiter...*/
            filewriter.append(SEPARATOR);
            filewriter.append(r.getRoomtype());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(String.valueOf(r.getRoomid()));
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(r.getRoomavailability());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(r.guest.getGuestid());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(r.guest.getGuestname());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(String.valueOf(r.guest.getAge()));
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(r.guest.getPhone());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(r.guest.getDatein());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(r.guest.getDateout());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(r.getStatu());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(String.valueOf(r.getRoomcharge()));
            filewriter.append(COMMA_DELIMITER);
        }
        filewriter.flush();
        filewriter.close();
    }
}
