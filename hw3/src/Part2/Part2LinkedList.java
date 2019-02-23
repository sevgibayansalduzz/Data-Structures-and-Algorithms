package Part2;

import java.util.Collection;
import java.util.LinkedList;

/**
 * This class extends Java LinkedList class ,The class has disable(),
 * enable() and showDisabled() methods.
 * @param <E> This class is generic.
 */
public class Part2LinkedList<E> extends LinkedList <E>{

    /**
     * This data field stores the courses and the information about their status.
     */
    private LinkedList<DISable<E>> disables_list=new LinkedList<>();

    /**
     * Constructor method calls constructor of super class.
     */
    public Part2LinkedList() { super();    }

    /**
     * Constructor method calls constructor of super class.Constructs a list
     * containing the elements of the specified collection.
     * @param c The collection whose elements are to be placed into this list.
     */
    public Part2LinkedList(Collection<? extends E> c) {  super(c);    }


    /**
     * This method overrides from  Java LinkedList class .Appends the specified element to the end of this list and disable_list.
     * @param e Takes e as a parameter,parameter type is generic.
     * @return Returns boolean.
     */
    @Override
    public boolean add(E e)
    {
        super.add(e);
        disables_list.add((new DISable<>(e)));
        return true;
    }

    /**
     * This method overrides from  Java LinkedList class .Inserts the specified element at the specified
     * position into this list and the disable_list.
     * @param index
     * @param e
     */
    @Override
    public void add(int index ,E e)
    {
        super.add(index,e);
        disables_list.add(index,(new DISable<>(e)));
    }
    /**
     *This method removes the unwanted item to be accessed.
     * @param e
     * @return
     */
    public boolean Disable(E e){
        if(contains(e))
        {
            disables_list.get(index(e)).setIs_disable_item(true);
            remove(e);
            return true;
        }
        return false;
    }

    /**
     * This methods enables back specified  disabled list item.
     * @if index(e)==-1 || !disables_list.get(index(e)).getIs_disable_item() If item is not in the this list or
     * item is enable,this method returns false.
     * @if (index(e)!=0) Previous item will be set.If the index() method returns 0,previous item remains as null
     * @if (index(e)<disables_list.size()-1) Next item will be set .If the index() method returns size -1,next item remains as null
     * @if (previous_item==null)  If previous item is null,that mean item previous index is first index or all elements before item is deleted.
     * So item will be located to the first index.
     * @if (next_item==null)  If next item is null,that mean item next index is last index so item will be located to the last index.
     * In other cases, the previous and next items are compared to the previous and next item of the given item.If there is a match,
     * the item is placed in the location where it is found. If not, the method looks at the item before and after the previous location.
     * @param e Takes item as a parameter.
     * @return Returns boolean.
     */
    public boolean Enable(E e)
    {
        if(index(e)==-1 || !disables_list.get(index(e)).getIs_disable_item())
            return false;
        E previous_item=null;
        E next_item=null;
        disables_list.get(index(e)).setIs_disable_item(false);
        if(index(e)!=0)
            previous_item=disables_list.get(index(e)-1).getItem();
        if(index(e)<disables_list.size()-1)
            next_item=disables_list.get(index(e)+1).getItem();
        else
        {
            while (true){
                if(previous_item==null){
                    addFirst(e);
                    return true;
                }else if(next_item==null) {
                    addLast(e);
                    return true;
                }else if(contains(previous_item)) {
                    add(indexOf(previous_item)+1,e);
                    return true;
                }else if(contains(next_item)) {
                    add(indexOf(next_item),e);
                    return true;
                }else {
                    previous_item=(index(previous_item)-1<0) ? null :disables_list.get(index(previous_item)-1).getItem();
                    next_item=(index(previous_item)+1>size()-1) ? null :disables_list.get(index(next_item)+1).getItem();
                }
            }
        }
        return true;
    }

    /**
     * This method lists all disabled items
     */
    public void showDisabled()
    {
        int count =0;
        for (DISable<E> aDisables_list : disables_list)
            if (aDisables_list.getIs_disable_item())
            {
                count++;
                System.out.println("- " + aDisables_list.getItem());
            }
        if(count==0)
            System.out.println("There is no disabled method!");
    }

    /**
     * This function finds the index of the item in the list.
     * Because the item is of class type, this function helps to find index .
     * @param e
     * @return
     */
    private int index(E e)
    {
        for(int i=0;i<disables_list.size();++i)
            if(disables_list.get(i).getItem().equals(e))
                return i;
        return -1;
    }

    /**
     * Prints items which are enable.
     */
    public void print()
    {
        for (DISable<E> aDisables_list : disables_list)
            if (!aDisables_list.getIs_disable_item())
                System.out.println(aDisables_list.getItem());
    }
}
