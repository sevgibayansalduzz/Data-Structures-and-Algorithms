package Q2;

import java.util.Collection;
import java.util.Iterator;

public interface Set<E> {

    public int size();
    public boolean isEmpty();
    public boolean contains(E o);
    public boolean containsAll(Collection<E> collection);
    public boolean add(E e);
    public boolean remove(E o) throws Throwable;
    public Iterator<E> iterator();
}
