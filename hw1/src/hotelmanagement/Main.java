
package hotelmanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 * The main method asks hotel managment user`s information according to operations which they want
 * to do and  and makes this opeations happen.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        if(args.length>=1)
        {
            FileInputStream is =new FileInputStream(new File(args[0]));
            System.setIn(is);
        }

        while (true)
        {
            Scanner input= new Scanner(System.in);
            System.out.print("Guest or Receptionist Entry (G/R):");
            String choice=input.next();
            System.out.println(choice);
            String choice2 = null;
            if (choice.toLowerCase().equals("g") || choice.toLowerCase().equals("r"))
            {
                while(true)
                {
                    if(choice.toLowerCase().equals("g"))
                    {
                        System.out.print("What do you want to do.Book or cancel(B/C):");
                        choice2=input.next();
                        System.out.println(choice2);
                        while(!(choice2.toLowerCase().equals("b")||choice2.toLowerCase().equals("c")))
                        {
                            System.out.println("Wrong entry,Please enter book or cancel(B/C)");
                            choice2=input.next();
                            System.out.println(choice2);
                        }
                    }
                    else if (choice.toLowerCase().equals("r"))
                    {
                        //RECEPTİONİST PASSWORD:5646
                        System.out.print("Please enter receptionist password:");
                        String password=input.next();
                        System.out.println(password);
                        Receptionist test=new Receptionist();
                        int count=0;
                        while(!(password.equals(test.getReceptionist_password())))
                        {
                            count++;
                            if(count==3)
                            {
                                System.out.println("The password entered incorrectly three times!");
                                System.exit(0);
                            }
                            System.out.println("Wrong password,Enter again:");
                            password=input.next();
                            System.out.println(password);
                        }
                        System.out.print("What do you want to do.Book , cancel ,check in,check out (B/C/İ/O):");
                        choice2=input.next();
                        System.out.println(choice2);
                        while(!(choice2.toLowerCase().equals("b")||choice2.toLowerCase().equals("c")
                                ||choice2.toLowerCase().equals("o")||choice2.toLowerCase().equals("i")))
                        {
                            System.out.println("Wrong entry,Please enter book cancel ,check in,check out (B/C/I/O):");
                            choice2=input.next();
                            System.out.println(choice2);
                        }
                    }
                    Receptionist rec=null;
                    System.out.print("Please enter an identification number:");
                    String id=input.next();
                    System.out.println(id);
                    while(!(id.length()==11))
                    {
                        System.out.println("Wrong identification number.Identification number should be 11 digit");
                        System.out.println("Enter a right indentification number");
                        id=input.next();
                        System.out.println(id);
                    }
                    System.out.print("Please enter a name:");
                    String name=input.next();
                    System.out.println(name);
                    System.out.print("Please enter a phone number without leading zero:");
                    String phone=input.next();
                    System.out.println(phone);
                    while(!(phone.length()==10))
                    {
                        System.out.println("Wrong phone number.Phone number should be 10 digit.Enter a right phone number:");
                        phone=input.next();
                        System.out.println(phone);
                    }

                    rec=new Receptionist(id,name,phone);
                    int room_no = 0;
                    if(choice2.toLowerCase().equals("c") || choice2.toLowerCase().equals("o") || choice2.toLowerCase().equals("i"))
                    {
                        System.out.print("Please enter room`s number:");
                        room_no=Integer.parseInt(input.next());
                        System.out.println(room_no);
                    }
                    if (choice.toLowerCase().equals("r") && (choice2.toLowerCase().equals("c") || (choice2.toLowerCase().equals("o"))))
                    {
                        if(choice2.toLowerCase().equals("c"))
                            rec.cancel(room_no);
                        else
                            rec.check_out(room_no);
                    }
                    else if(choice.toLowerCase().equals("g") && (choice2.toLowerCase().equals("c")))
                    {
                        Guest guest = new Guest(id,name,phone);
                        guest.cancel(room_no);
                    }
                    else if(choice2.toLowerCase().equals("b") || !(rec.check_in(room_no)))
                    {
                        if (choice2.toLowerCase().equals("i"))
                        {
                            System.out.print("No records found!Do you want to create new record?Yes or no(Y/N):");
                            String cont = input.next();
                            System.out.println(cont);
                            while (!(cont.toLowerCase().equals("y") || cont.toLowerCase().equals("n"))) {
                                System.out.println("Wrong entry,Please enter yes or no(y/n)");
                                cont = input.next();
                                System.out.println();
                            }if (cont.toLowerCase().equals("n"))
                                System.exit(1);
                        }
                        System.out.print("Please enter an age:");
                        int age;
                        do
                        {
                            try
                            {
                                age=Integer.parseInt(input.next());
                                System.out.println(age);
                                if(age>=18)
                                    break;
                                else{
                                    System.out.println("Age is under 18 so you cannot booked a room! ");
                                    System.exit(0);
                                }
                            }
                            catch (Exception e){
                                System.out.print("Couldn't parse input, please enter age again:");
                                System.out.println(id);
                            }
                        }while (true);
                        System.out.print("Please enter a check in date.(Example :2018/10/25):");
                        String datein;
                        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                        while (true){
                            datein=input.next();
                            System.out.println(datein);
                            if(isValidDate(datein)){
                                if(date.compareTo(datein) <= 0)
                                    break;
                                else
                                    System.out.print("Pass day cannot be reserved.Plese enter a check in date:");
                            }
                        }
                        System.out.print("Please enter a check out date.(Example :2018/10/25):");
                        String dateout;
                        while (true){
                            dateout=input.next();
                            System.out.println(dateout);
                            if(isValidDate(dateout)){
                                if(date.compareTo(dateout) <= 0 && datein.compareTo(dateout)<=0)
                                    break;
                                else
                                    System.out.print("Pass day cannot be reserved and check out date must be bigger than check in date." +
                                            "Plese enter a check in date:");
                            }
                        }
                        System.out.print("Please enter a room type(single/double/suite):");
                        String type=input.next();
                        System.out.println(type);
                        while(!(type.toLowerCase().equals("single") || type.toLowerCase().equals("double")
                                ||type.toLowerCase().equals("suite")))
                        {
                            System.out.println("Wrong entry.Enter a right type of room.Enter an available choice:");
                            type=input.next();
                            System.out.println(type);
                        }
                        if(choice.toLowerCase().equals("r"))
                        {

                            rec=new Receptionist(id,name,age,phone,datein,dateout);
                            if(choice2.toLowerCase().equals("b"))
                                rec.book(type);
                            else
                                rec.check_in(type);
                        }
                        else
                        {
                            Guest guest=new Guest(id,name,age,phone,datein,dateout);
                            if(choice2.toLowerCase().equals("b"))
                                guest.book(type);
                        }
                    }
                    System.out.print("Do you want to continue processing, yes or no (Y/N):");
                    String _continue = input.next();
                    System.out.println(_continue);
                    while (!(_continue.toLowerCase().equals("y") || _continue.toLowerCase().equals("n")))
                    {
                        System.out.println("Wrong entry,Please enter yes or no(y/n)");
                        _continue = input.next();
                        System.out.println(_continue);
                    }
                    if (_continue.toLowerCase().equals("n"))
                        System.exit(1);
                }
            }
            else
                System.out.println("Wrong entry, please enter again (G/R):");
        }


    }

    /**
     * THe function checks  whether date is valid.
     * @param date Takes  string parameter
     * @return Returns boolean.
     */
    private static boolean isValidDate(String date) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
        myFormat.setLenient(false);
        try {
            myFormat.parse(date.trim());
            return true;
        }
        catch (ParseException e)
        {
            System.out.print("Date input format is wrong or date is invalid, please try again:");
            return false;
        }
    }
}