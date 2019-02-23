package Part3;

import Part1.GTUCourse;

import java.util.NoSuchElementException;

public class GTULinkList {


    /** A reference to the head of the list. */
    private NodeCourse<GTUCourse> head_course=null;

    /** This data field stores the size of the list. */
    private int size=0;

    /** Add a new item .
     *@param data The item to be added.
     *@return REturns boolean.
     */
    public boolean add (GTUCourse data)
    {
        add(size,data);
        return true;
    }

    /**
     * Adds an item at the specified index.
     * <p>
     *     İf given index are zero,the method adds the item at head.
     *     <li>If size is zero, The next and previous course ( in the same semester)of the head will be itself.</li>
     *     <li>If size is not zero and semester of the first item is the list equals the given item,next course ( in the same semester)of head will be first item in the list</li>
     *     <li>else the first item in the list is equal to the year of the given item, will find .</li>
     * </p>
     *
     * <p>
     *    If there is no course in the semester of the course given as data,After data adding,The next and previous course( in the same semester) of dataeill be itself.
     * </p>
     *
     * <p>
     *     Else the method finds the previous and next course ( in the same semester) of the data and insert data between the two.
     * </p>
     * @param index The index at which the object is to be inserted
     * @param data The object to be inserted
     */
    public void add(int index,GTUCourse data)
    {
        if(index<0 || index>size)
            throw new IndexOutOfBoundsException("index is not valid");
        else if(index==0)
        {
            if(size==0)//Insert at head.
                addHead(data,null);
            else
            {
                if(head_course.getData().getSemester()==data.getSemester())//Insert at head.
                    addHead(data,head_course);
                else
                {
                    for(int i=0;i<=size();++i)
                        if(data.getSemester()==get(i).getSemester())
                        {
                            addHead(data,getNode(i));//insert at head
                            break;
                        }
                }
            }
        }
        else
        {
            NodeCourse<GTUCourse> node= getNode(index-1);
            if(!hasSemester(data))
            {
                node.next_course=new NodeCourse<>(data,node.next_course);
                node.next_course.next_insemester=node.next_course;
                node.next_course.prev_insemester=node.next_course;
            }else{
                for (int i=index-1;i>=0;--i)
                    if(data.getSemester()==get(i).getSemester() )
                    {
                        node.next_course=new NodeCourse<>(data,node.next_course,getNode(i).next_insemester,getNode(i));
                        getNode(i).next_insemester.prev_insemester=node.next_course;
                        getNode(i).next_insemester=node.next_course;
                        break;
                    }else if(i==0)
                    {
                        int index2=searchFirstCourse(data.getSemester());
                        node.next_course=new NodeCourse<>(data,node.next_course,getNode(index2),getNode(index2).prev_insemester);
                        getNode(index2).prev_insemester.next_insemester=node.next_course;
                        getNode(index2).prev_insemester=node.next_course;
                    }
            }
        }
        ++size;
    }

    /**
     * Helper function.Insert an object at the beginning of the list.
     * @param data
     * @param next_data
     * @return Returns boolean
     */
    private boolean addHead(GTUCourse data,NodeCourse<GTUCourse> next_data)
    {
        if (next_data==null)
        {
            head_course=new NodeCourse<>(data,next_data);
            head_course.next_insemester=head_course;
            head_course.prev_insemester=head_course;
        }else
        {
            head_course=new NodeCourse<>(data,head_course,next_data,next_data.prev_insemester);
            head_course.prev_insemester.next_insemester=head_course;
        }
        return true;

    }

    /**
     * Removes an item at the specified index.The method deletes the element by linking before and after the index
     * @param index
     */
    public void remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }else if(index<0 || index>size)
            throw new IndexOutOfBoundsException("index is not valid");
        else if (index == 0) {
            head_course.prev_insemester.next_insemester=head_course.next_insemester;
            head_course.next_insemester.prev_insemester=head_course.prev_insemester;
            head_course = head_course.next_course;

        } else {
            NodeCourse current = head_course;
            for (int i = 0; i < index - 1; i++) {
                current = current.next_course;
            }
            current.next_course.prev_insemester.next_insemester=current.next_course.next_insemester;
            current.next_course.next_insemester.prev_insemester=current.next_course.prev_insemester;
            current.next_course = current.next_course.next_course;
        }
        size --;
    }

    /**
     * Helper function.Examines whether there is a lecture in the given semester.
     * @param data
     * @return
     */
     private boolean hasSemester(GTUCourse data)
    {
        for (int i=0;i<size;++i)
            if(data.getSemester()==get(i).getSemester())
                return true;
        return false;
    }

    private int searchFirstCourse(int semester) {
        for (int i=0;i<=size;++i)
            if (getNode(i).getData().getSemester()==semester)
                return i;
        return -1;
    }
    /**
     * Returns the node for the given index
     * @param index
     * @return
     */
    private NodeCourse<GTUCourse> getNode(int index)
    {
        NodeCourse<GTUCourse> node=head_course;
        for (int i=0;i<index && node.next_course!=null;++i)
            node=node.next_course;
        return node;
    }

    /**
     * Returns the data for given index
     * @param index
     * @return
     */
    public GTUCourse get(int index)
    {
        if(index<0 || index>size || (index==0 && size==0))
            throw new IndexOutOfBoundsException("index is not valid");
        return getNode(index).data;
    }

    /**
     * Returns size
     * @return
     */
    public int size()
    {
        return size;
    }

    /**
     * REturns next course.
     * @param index
     * @return
     */
    public NodeCourse<GTUCourse> Next(int index)
    {
        return getNode(index).next_course;
    }

    /**
     * Returns next course in the same semester.
     * @param index
     * @return
     */
    public NodeCourse<GTUCourse> nextInSemester(int index)
    {
        return getNode(index).next_insemester;
    }

    public boolean isEmpty() {
        return size == 0 && head_course==null;
    }

    /*Class node starting */

    /**
     * Node class
     * @param <E>
     */
    public class NodeCourse<E> {
        /** The data value. */
        private E data;
        /** The link to the next course. */
        private NodeCourse<E> next_course= null;
        /** The link to the next course of in the same semester. */
        private NodeCourse<E> next_insemester= null;
        /** The link to the previous course of in the same semester. */
        private NodeCourse<E> prev_insemester= null;
        public NodeCourse(E data,NodeCourse<E> next_course,NodeCourse<E>next_insemester,NodeCourse<E> prev_insemester)
        {
            this.data = data;
            this.next_course=next_course;
            this.next_insemester=next_insemester;
            this.prev_insemester=prev_insemester;
        }
        public NodeCourse(E data,NodeCourse<E> next_course) {
            this.data = data;
            this.next_course=next_course;
        }
        public E getData() {
            return data;
        }
    }

}
