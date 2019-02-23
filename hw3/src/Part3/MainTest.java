package Part3;

import Part1.GTUCoursesList;

public class MainTest {

    public static void main(String[] args) {
        GTUCoursesList list= new GTUCoursesList();
        GTULinkList try_linkedlist=new GTULinkList ();

        /*******************************************************/
        /*******Adding new data into the try_linkedlist*********/
        /*******************************************************/

        try_linkedlist.add(list.get(0));
        try_linkedlist.add(list.get(9));
        try_linkedlist.add(list.get(8));
        try_linkedlist.add(list.get(15));
        try_linkedlist.add(0,list.get(6));
        try_linkedlist.add(2,list.get(10));
        try_linkedlist.add(list.get(18));
        try_linkedlist.add(list.get(2));
        try_linkedlist.add(list.get(25));
        try_linkedlist.add(list.get(1));
        try_linkedlist.add(list.get(12));

        System.out.println("\nData of try_linkedlist:\n");
        System.out.println(try_linkedlist.get(0));
        for (int i=0;i<try_linkedlist.size()-1;++i)
            System.out.println(try_linkedlist.Next(i).getData());
        System.out.println("**********************************");


        System.out.println("\nThe next course of in same semester for given course index:\n");
        for(int i=0;i<try_linkedlist.size();++i)
            System.out.println("Semester"+try_linkedlist.get(i).getSemester()+" Next in semester of "+
                    try_linkedlist.get(i).getCourseCode()+"  is  "+try_linkedlist.nextInSemester(i).getData().getCourseCode());


        System.out.println("**********************************");

        /******Removing data *********/
        try_linkedlist.remove(0);
        try_linkedlist.remove(3);
        try_linkedlist.remove(8);


        System.out.println("\nData of try_linkedlist after removing:\n");
        System.out.println(try_linkedlist.get(0));
        for (int i=0;i<try_linkedlist.size()-1;++i)
            System.out.println(try_linkedlist.Next(i).getData());
        System.out.println("**********************************");


        System.out.println("\nThe next course of in same semester for given course index:\n");
        for(int i=0;i<try_linkedlist.size();++i)
            System.out.println("Semester"+try_linkedlist.get(i).getSemester()+" Next in semester of "+
                    try_linkedlist.get(i).getCourseCode()+"  is  "+try_linkedlist.nextInSemester(i).getData().getCourseCode());

        /******END*********/
    }

}
