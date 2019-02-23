package Q3;


import java.util.*;

/**
 * Class Part3 implements merge sort with double linked list
 *
 **************** I take the implementation of double linked list from our Textbook ***************
 */
public class Part3 <T extends Comparable<T>>{

    private Node < T > head = null;
    private Node < T > tail = null;
    private int size = 0;

    /////////////////////////Merge Sort Implementation/////////////////////////


    /**Constructor for collections*/
    public  Part3 (Collection<T> array)
    {
        create( array);
    }

    public Part3() {

    }
    /**Constructor for array*/
    public Part3(T[] array){ create(array);}

     /**Translates the given collection into a linkedList.*/
    private void create(Collection<T> array)
    {
        Iterator<T> iter=array.iterator();
        for (int i=array.size()-1;i>=0;--i)
             addFirst(iter.next());
    }

    /**
     * Translates the given array into a linkedList.
     * @param array
     */
    private void create(T[] array) {
        for (int i=0,j=0;i<array.length;++i)
            if(array[i]!=null)
            {
                add(j,array[i]);
                j++;
            }
    }

    /**
     * Splits LinkedList into two
     * @param leftNode
     * @return
     */
    private  Node<T> divide( Node<T> leftNode)
    {
        if(leftNode==null)
            return null;
        Node temp=leftNode.next;
        while (temp!=null)
        {
            temp=temp.next;
            if (temp==null)
                break;
            temp=temp.next;
            leftNode=leftNode.next;
        }
        Node rigthNode=leftNode.next;
        leftNode.next=null;
        return rigthNode;
    }
    public void mergeSort()
    {
        Part3 sorted=mergeSort(head);
         head=sorted.head;
         tail=sorted.tail;
    }

    /** Sort the array using the merge sort algorithm.
     pre: LinkedList contains Comparable objects.
     post: LinkedList is sorted.
     @param left The LinkedList to be sorted
     */
    private Part3<T> mergeSort( Node<T> left)
    {
        if(left==null || left.next==null)
            return merge(left,null);
        //divide the linkedList
        Node<T> right=divide(left);

        // Sort the halves.
        left=mergeSort(left).head;
        right=mergeSort(right).head;
        return merge(left,right);
    }

    /**Merge two sequences.
     * pre: left  and right  are sorted.
     * post: return the merged result and is sorted.
     * @return the merged result and is sorted.
     */
    private Part3<T> merge(Node<T> left, Node<T> right) {
        Part3<T> newArray=new Part3<>();
        int i=0;
        while (left!=null && right!=null)
        {
            // Find the smaller and
            // insert it into the newArray .
            if (left.data.compareTo(right.data)<0)
            {
                newArray.add(i++,left.data);
                left=left.next;
            }else{
                newArray.add(i++,right.data);
                right=right.next;
            }
        }while (left!=null)
        {// assert: one of the sequences has more items to add.
            // add remaining input from left  into the newArray.
            newArray.add(i++,left.data);
            left=left.next;
        }
        while (right!=null)
        {
            //// add remaining input from left  into the newArray.
            newArray.add(i++,right.data);
            right=right.next;
        }
        return newArray ;
    }
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        Iterator<T> iter=this.iterator();
        while (iter.hasNext())
            sb.append(iter.next()+" ");
        return sb.toString();
    }
    public String reversetoString() {
        StringBuilder sb=new StringBuilder();
        ListIterator<T> iter=this.listIterator(this.size);
        while (iter.hasPrevious())
            sb.append(iter.previous()+" ");
        return sb.toString();
    }
    /////////////Double Linked Lİst Implementation/////////////////////////////////
    /** A Node is the building block for a double-linked list. */
    public void addFirst(T item) {
        add(0, item);
    }
    public void addLast(T item) {
        add(size, item);
    }
    public T getFirst() {
        return head.data;
    }
    public T getLast() {
        return tail.data;
    }
    public Iterator < T > iterator() {
        return new KWListIter(0);
    }
    public ListIterator < T > listIterator() {
        return new KWListIter(0);
    }
    private ListIterator < T > listIterator(int index) {
        return new KWListIter(index);
    }
    public void add(int index, T obj) {
        listIterator(index).add(obj);
    }

    protected static class Node < T > {
        /** The data value. */
        protected T data;

        /** The link to the next node. */
        protected Node < T > next = null;

        /** The link to the previous node. */
        protected Node < T > prev = null;

        /** Construct a node with the given data value.
         @param dataItem The data value
         */
        protected Node(T dataItem) {
            data = dataItem;
        }
    }

    /** Inner class to implement the ListIterator interface. */
    private class KWListIter implements ListIterator < T > {
        /*** A reference to the next item.*/
        private Node<T> nextItem;
        /*** A reference to the last item returned.*/
        private Node<T> lastItemReturned;
        /*** The index of the current item.*/
        private int index = 0;
        /**
         * Construct a KWListIter that will reference the ith item.
         * @param i The index of the item to be referenced
         */
        public KWListIter(int i) {
            // Validate i parameter.
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException(
                        "Invalid index " + i);
            }
            lastItemReturned = null; // No item returned yet.
            // Special case of last item.
            if (i == size) {
                index = size;
                nextItem = null;
            } else { // Start at the beginning
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }

        /** Indicate whether movement forward is defined.
         @return true if call to next will not throw an exception
         */
        public boolean hasNext() {
            return nextItem != null;
        }

        /** Move the iterator forward and return the next item.
         @return The next item in the list
         @throws NoSuchElementException if there is no such object
         */
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        /** Indicate whether movement backward is defined.
         @return true if call to previous will not throw an exception
         */
        public boolean hasPrevious() {
            return (nextItem == null && size != 0)
                    || nextItem.prev != null;
        }

        /** Return the index of the next item to be returned by next
         @return the index of the next item to be returned by next
         */
        public int nextIndex() {
            return index;
        }

        /** Return the index of the next item to be returned by previous
         @return the index of the next item to be returned by previous
         */
        public int previousIndex() {
            return index - 1;
        }

        /** Move the iterator backward and return the previous item.
         @return The previous item in the list
         @throws NoSuchElementException if there is no such object
         */
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) { // Iterator past the last element
                nextItem = tail;
            }
            else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        public void add(T obj) {
            if (head == null) { // Add to an empty list.
                head = new Node < T > (obj);
                tail = head;
            }
            else if (nextItem == head) { // Insert at head.
                // Create a new node.
                Node < T > newNode = new Node < T > (obj);
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 1
                // Link nextItem to the new node.
                nextItem.prev = newNode; // Step 2
                // The new node is now the head.
                head = newNode; // Step 3
            }
            else if (nextItem == null) { // Insert at tail.
                // Create a new node.
                Node < T > newNode = new Node < T > (obj);
                // Link the tail to the new node.
                tail.next = newNode; // Step 1
                // Link the new node to the tail.
                newNode.prev = tail; // Step 2
                // The new node is the new tail.
                tail = newNode; // Step 3
            }
            else { // Insert into the middle.
                // Create a new node.
                Node <T> newNode = new Node <T> (obj);
                // Link it to nextItem.prev.
                newNode.prev = nextItem.prev; // Step 1
                nextItem.prev.next = newNode; // Step 2
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 3
                nextItem.prev = newNode; // Step 4
            }
            // Increase size and index and set lastItemReturned.
            size++;
            index++;
            lastItemReturned = null;
        } // End of method add.

        /** Remove the last item returned. This can only be
         *  done once per call to next or previous.
         *  @throws IllegalStateException if next or previous
         *  was not called prior to calling this method
         */
        /**** BEGIN EXERCISE ****/
        public void remove() {
            if (lastItemReturned == null) {
                throw new IllegalStateException();
            }
            // Unlink this item from its next neighbor
            if (lastItemReturned.next != null) {
                lastItemReturned.next.prev = lastItemReturned.prev;
            }
            else { // Item is the tail
                tail = lastItemReturned.prev;
                if (tail != null) {
                    tail.next = null;
                }
                else { // list is now empty
                    head = null;
                }
            }
            // Unlink this item from its prev neighbor
            if (lastItemReturned.prev != null) {
                lastItemReturned.prev.next = lastItemReturned.next;
            }
            else { // Item is the head
                head = lastItemReturned.next;
                if (head != null) {
                    head.prev = null;
                }
                else {
                    tail = null;
                }
            }
            // Invalidate lastItemReturned
            lastItemReturned = null;
            // decrement both size and index
            size--;
            index--;
        }

        @Override
        public void set(T item) {
            if (lastItemReturned == null) {
                throw new IllegalStateException();
            }
            lastItemReturned.data = item;
        }
    } //end class KWListIter

}
