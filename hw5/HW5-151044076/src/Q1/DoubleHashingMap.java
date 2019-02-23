package Q1;


public class DoubleHashingMap<K, V>implements  Map<K, V> {
    /**
     *stores key-value mappings
     */
    private Entry < K, V > [] table;
    /**
     * stores initial capacity
     */
    private static final int INITIAL_CAPACITY = 17;
    /**
     * stores capacity
     */
    private int capacity;
    /**
     * stores maximum load factor
     */
    private double LOAD_FACTOR = 0.75;
    /**
     * stores the number of key-value mappings in this map
     */
    private int numKeys=0;
    /**
     * stores number of deleted items
     */
    private int numDeletes=0;
    /**
     * Deleted item
     */
    private final Entry < K, V > DELETED = new Entry < K, V > (null, null);

    /**
     * Used in second hash function.
     */
    private int primeForHash2;

    /**
     *Constructor
     */
    public DoubleHashingMap() {
        capacity=INITIAL_CAPACITY;
        table = new Entry[INITIAL_CAPACITY];
        primeForHash2=previousPrime(INITIAL_CAPACITY-1);
    }
    /**
     * @return the number of key-value mappings in this map.
     */
    @Override
    public int size() {
        return numKeys;
    }

    /**
     * @return Returns true if this map contains no-key value mappings,otherwise returns false.
     */
    @Override
    public boolean isEmpty() {
        return numKeys == 0 ;
    }

    /**
     * Method get for map.
     * @param key The key being sought.
     * @return the value associated with this key if found;otherwise, null.
     */
    @Override
    public V get(Object key)  {

        int index = find(key);
        if (table[index] != null && table[index]!=DELETED)
            return table[index].value;
        else
            return null;
    }

    /**
     * <p> Method put for map.</p>
     * <p> If the key is already in the table, its value is changed to the argument value and numKeys is not changed.
     * Otherwise this key-value pair is inserted in the table and numKeys is incremented.</p>
     * @param key The key of item being inserted
     * @param value The value for this key
     * @return Old value associated with this key if found;otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = find(key);
        if (table[index] == null)
        {
            table[index] = new Entry < K, V > (key, value);
            numKeys++;
            double loadFactor = (double) (numKeys + numDeletes) / table.length;
            if (loadFactor > LOAD_FACTOR)
                rehash();
            return null;
        }
        V oldVal = table[index].value;
        table[index].value = value;
        return oldVal;
    }

    /**
     * <p>Method remove for map.Removes the mapping for this key from this map if it is present.</p>
     *  <p>If the key is not in the map returns null.</p>
     *  <p>Otherwise;
     *  <li>DELETED is assigned to the element at the index of the table associated with this key.</li>
     *  <li>numKeys is decremented</li>
     *  <li>numDeletes is incremented/li>
     *  <li>old value is returned</li></p>
     * @param key The key to be removed
     * @return Old value associated with this key if found;otherwise, null
     */
    @Override
    public V remove(Object key) {
        int index = find(key);
        if (table[index] == null)
            return null;
        V oldValue = table[index].value;
        table[index] = DELETED;
        numKeys--;
        numDeletes++;
        return oldValue;
    }

    /**
     *  Finds either the target key or the first empty slot in the table using double hashing.
     * @param key target object.
     * @return position of the target or the first empty slot
     */
    private int find(Object key) {
        int index = hash1(key);//The first hash method is called
        if (index < 0)
            index += table.length; // Make it positive.
        for ( int i=0;(table[index] != null && table[index] != DELETED )
                && (!key.equals(table[index].key));++i) {
            index=(hash1(key) + i*hash2(key))%capacity;
        }
        return index;
    }
    /**
     * The method to calculate first hash
     * @param key
     * @return  index
     */
    private int hash1(Object key)
    {
        return key.toString().hashCode()%capacity;
    }

    /**
     * The method to calculate second hash
     * @param key
     * @return
     */
    private int hash2(Object key)
    {
        return primeForHash2-(key.toString().hashCode()%primeForHash2);
    }
    /**
     * Expands table size when loadFactor exceeds LOAD_FACTOR
     * <p>The size of table is doubled and is a PRIME integer.</p>
     * Old table is copied to the new table.
     */
    private void rehash()
    {
        Entry<K, V>[] oldTable = table;
        int new_capacity=nextPrime(2*capacity);
        table = new Entry[new_capacity];
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < capacity; i++) {
            if ((oldTable[i] != null) && (oldTable[i] != DELETED)) {
                put(oldTable[i].key, oldTable[i].value);
            }
        }
        capacity=new_capacity;
        primeForHash2=previousPrime(2*capacity-1);
    }

    /**
     *Returns next prime number according to the given parameter.
     * This method is helper method to find next size of the table.
     * @param M
     * @return
     */
    private int nextPrime(int M) {
        if(!isPrime(M))
            M = nextPrime(++M);
        return M;
    }

    /**
     * Returns previous prime number according to the given parameter.
     * This method is helper method to find prime number less than table size for  hash2 method.
     * @param M
     * @return
     */
    private int previousPrime(int M)
    {
        if(!isPrime(M))
            M = previousPrime(--M);
        return M;
    }

    private boolean isPrime(int M) {
        for(int i = 2; i <= Math.sqrt(M); i++)
            if(M % i == 0) return false;
        return true;
    }

    private static class Entry < K, V > {
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
