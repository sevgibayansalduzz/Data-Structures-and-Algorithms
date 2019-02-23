package Q2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Hash table implementation using chaining.
 *   @author Koffman and Wolfgang
 * */

public class HashtableChain < K, V > implements Q1.Map<K,V>{

    /**Structer for chaining  */
    protected static class Chain< K, V >{
        private Entry < K, V > data;
        private HashtableChain<K,V> next=null;

        public Chain(){ }
        public Chain(K key, V value) {   data=new Entry<>(key,value);}
        public Entry<K,V> getData(){return data;}
    }
    /**The table*/
    protected Chain<K, V>[] table;
    /**The number of keys*/
    private  int numKeys;
    /** The capacity*/
    private static final int CAPACITY = 11;
    /** The maximum load factor*/
    private static final double LOAD_THRESHOLD = 3.0;
    /**size for next capacity*/
    private int prime=7;

    public HashtableChain() { table = new Chain[CAPACITY]; }
    public HashtableChain(int capacity)
    {
        table=new Chain[capacity];
        prime=previousPrime(capacity-1);
    }

    /** Method put */
    @Override
    public V put(K key, V value) { return put(key,value,table);}

    /** Method put for class HashtableChain.
     post: This key-value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed.
     @param key The key of item being inserted
     @param value The value for this key
     @return The old value associated with this key if
     found; otherwise, null
     */
    private V put(K key, V value, Chain<K, V>[] table) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index]== null)
        {
            table[index] =new Chain<>(key,value) ;
            numKeys++;
            return null;
        }
        else if(table[index].data.equals(key))
            return table[index].data.setValue(value);
        else if (table[index].next==null)
        {
            table[index].next=new HashtableChain<>(prime);
            prime=previousPrime(prime-1);
            numKeys++;
            return table[index].next.put(key,value);
        }else
            return put(key,value,table[index].next.table);
    }
    /**Method remove*/
    @Override
    public V remove(K key) throws Throwable {
        return remove(key,table);
    }

    /**
     *Method remove
     * @param key
     * @param table
     * @return The value associated with this key if found;
    otherwise, null
     * @throws Throwable
     */
    private V remove(K key, Chain<K, V>[] table) throws Throwable {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index]== null)
            return null;
        if(table[index].data.key.equals(key) && table[index].next==null)//Simply delete it
        {
            V returnValue=table[index].data.value;
            table[index]=null;
            numKeys--;
            return returnValue;
        }else if(table[index].data.key.equals(key) && table[index].next!=null)
        {
            V returnValue=table[index].data.value;
            table[index].data= table[index].next.table[key.hashCode()%table[index].next.table.length].data;
            numKeys--;
            table[index].next.remove(table[index].data.key);
            return returnValue;
        }else
        {
            V returnValue=remove(key,table[index].next.table);
           if(isEmpty(table[index].next.table))
               table[index].next=null;
            return returnValue;
        }
    }

    /** Method get for class HashtableChain.
     @param key The key being sought
     @return The value associated with this key if found;
     otherwise, null
     */
    @Override
    public V get(Object key) {
        return get(key,table);
    }

    private V get(Object key, Chain<K, V>[] table) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index]== null)
            return null;
        else if(table[index].data.key.equals(key))
            return table[index].data.value;
        else if (table[index].next==null)
            return null;
        else
            return get(key,table[index].next.table);
    }

    public Iterator<Entry < K, V > > iterator() {
        List<Entry < K, V > > iter=new ArrayList<>();
        return iterator(iter,0).iterator();
    }
    private List<Entry < K, V > > iterator(List<Entry < K, V >>  iter,int i) {
        if(i==table.length)
            return iter;
        if (table[i]!= null) {
            iter.add(table[i].data);
        }
        if(table[i]!= null && table[i].next!=null)
            table[i].next.iterator(iter,0);
        return iterator(iter,i+1);
    }
    @Override
    public int size()
    {
        return numKeys;
    }
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }
    /**
     *Returns previous prime number according to the given parameter.
     * This method is helper method to find size of the next table.
     * @param num
     * @return
     */
    private int previousPrime(int num)
    {
        if(num<=1)
            return 2;
        if(!isPrime(num))
            num = previousPrime(--num);
        return num;
    }
    private boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++)
            if(num % i == 0) return false;
        return true;
    }
    private boolean isEmpty(Chain<K, V>[] table) {
        for(int i=0;i<table.length;++i)
            if(table[i]!=null)
                return false;
        return true;
    }
    protected static class Entry < K, V > {

        /** The key */
        private K key;

        /** The value */
        private V value;

        /** Creates a new key-value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }

        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }

        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }
}
