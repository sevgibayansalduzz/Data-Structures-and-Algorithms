package Q2;


import java.util.*;
/**This class implements methos of the set interface*/
public class HashSetChain<E> implements Set<E>
{
    /**
     * this data field’s type is HashatableChain,this class includes this variable for
     *using HashTableChain’s method
     */
    private HashtableChain<E, E> setMap;

    /**Default constructor initialize setMap datafield.*/
    HashSetChain(){ setMap=new HashtableChain<>();}
    /**This constructor initalize setMap according to given parameter*/
    HashSetChain(int i){ setMap=new HashtableChain<>(i);}
    /**add method for setChain class.
     *This method  uses put method of setMap
     *Calls put method with given parameter(Given parmeter is used as a key and value*/
    @Override
    public boolean add(E e) {
        return (setMap.put(e, e) == null);
    }

    /**remove method for setChain class.
     *This method  uses remove method of setMap
     *Calls remove method with given parameter.*/
    @Override
    public boolean remove(E e) throws Throwable {
        return (setMap.remove(e) != null);
    }

    /**size method for setChain class.
     *This method  uses size method of setMap*/
    @Override
    public int size() {
        return setMap.size();
    }

    /**isEmpty method for setChain class.
     *This method  uses isEmpty method of setMap*/
    @Override
    public boolean isEmpty() {
        return setMap.isEmpty();
    }


    /**contains method for setChain class.
     *This method  uses get method of setMap*/
    @Override
    public boolean contains(E e) {
        return (setMap.get(e)!=null);
    }
    /**containsAll method for setChain class*/
    @Override
    public boolean containsAll(Collection<E> collection) {
        return containsAll(collection.iterator());
    }

    /*if elements of this two collection doesn’t match returns false otherwise returns true*/
    private boolean containsAll(Iterator<E> iterator) {
        if (!iterator.hasNext())
            return true;
        else if(!this.contains(iterator.next()))
            return false;
        else
            return containsAll(iterator);
    }

    /**iterator method for setChain class.
     *This method  uses iterator method of setMap*/
    @Override
    public Iterator iterator() {
        return setMap.iterator();
    }
    /**toString method*/
    @Override
    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        Iterator<HashtableChain.Entry<E,E>> iter= this.iterator();
        do {
            sb.append(iter.next().getKey());
        }while (iter.hasNext() && sb.append(",")!=null);
        sb.append("]");
        return sb.toString();
    }
}
