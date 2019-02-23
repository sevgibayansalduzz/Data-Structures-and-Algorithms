package Q1;

public interface Map < K, V >  {
    V get(Object key);

    V put(K key, V value);

    V remove(K key) throws Throwable;

    int size();

    boolean isEmpty();

}
