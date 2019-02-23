package Part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class MDSTree< E extends Comparable < E >> extends BInaryTree<E> implements SearchTree<E> {

    /** Return value from the public add method. */
    private boolean addReturn ;
    /**Dimension*/
    private int dimension;

    /**
     * Default constructor.
     */
    public MDSTree() { super(); dimension=3; }

    /**
     * Constructor
     * @param root
     */
    public MDSTree(Node < E > root){    super(root); dimension=root.data.size(); }

    /**
     * Constructor
     * @param data
     * @param leftTree
     * @param rightTree
     */
    public MDSTree(ArrayList<E> data, BInaryTree < E > leftTree, BInaryTree < E > rightTree){   super(data,leftTree,rightTree); dimension=root.data.size();}

    /**
     * @param item The object being inserted
     * @return true if the object is inserted, false if the object already exists in the tre
     */
    @Override
    public boolean add(ArrayList<E> item) {
        if(dimension!=item.size() && root!=null)
            return false;
        root= add(root,item,0);
        return addReturn;
    }

    /**
     * Recursive add method.
     * @param localRoot The local root of the subtree
     * @param item The object being inserted
     * @param level The level of the localRoot.
     * @return
     */
    private Node<E> add(Node<E> localRoot, ArrayList<E> item,int level) {
        // item is not in the tree  insert it.
        if(localRoot==null)
        {
            addReturn=true;
            dimension=item.size();
            return new Node<>(item);
        }
        if (localRoot.data.equals(item))
        {
            // item is equal to localRoot.data
            addReturn =false;
            return localRoot;
        }
        else
        {
            //Looks at the left if the element at the current size is smaller or equal than the root element.
            if(item.get(level%dimension).compareTo(localRoot.data.get(level%dimension))<=0)
                localRoot.left=add(localRoot.left,item,level+1);
            else
                localRoot.right=add(localRoot.right,item,level+1);
            return localRoot;
        }
    }

    /**
     * Determine if an item is in the tree
     * @param target Item being sought in tree
     * @return
     */
    @Override
    public boolean contains(ArrayList<E> target) {
        if(find(target,root,0)==null)
            return false;
        return true;
    }

    /**
     *Find method calls the recursive find method.
     * @param target The item being sought
     * @return
     */
    @Override
    public ArrayList<E> find(ArrayList<E> target) {

        Node<E> Return=find(target,root,0);
        if(Return==null)
            return null;
        return Return.data;
    }

    /**
     * Recursive find method.
     * @param target
     * @param localRoot
     * @param level
     * @return
     */
    private Node<E> find(ArrayList<E>target, Node<E> localRoot,int level)
    {
        if(localRoot==null)
            return localRoot;
        // Compare the target with the data field at the root.
        if (localRoot.data.equals(target))
             return localRoot;
        else if (target.get(level % dimension).compareTo(localRoot.data.get(level % dimension)) < 0)
            return  find(target, localRoot.left, level + 1);
        else
            return   find(target, localRoot.right, level + 1);
    }
    /**Return value from the public delete method.*/
    ArrayList<E> deleteReturn=null;

    /**
     *Removes target from tree.
     * @param target Item to be removed
     * @return
     */
    @Override
    public ArrayList<E> delete(ArrayList<E> target) {
        root=delete(root,target,0);
        return deleteReturn ;
    }

    /**
     *Recursive delete method.
     * @param localRoot
     * @param item
     * @param level
     * @return
     */
    private Node<E> delete(Node<E> localRoot,ArrayList<E> item,int level) {

        if (localRoot == null) {
            deleteReturn=null;
            return localRoot;
        }
        int compResult = item.get(level%dimension).compareTo(localRoot.data.get(level%dimension));
        if (compResult < 0 || (compResult==0 && !item.equals(localRoot.data))) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item,level+1);
            return localRoot;
        }
        else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item,level+1);
            return localRoot;
        }
        else {
            deleteReturn=localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            }
            else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            }
            else {
                deleteReturn=localRoot.data;
               if (isLeaf(localRoot.left)) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = null;
                return localRoot;
               } else {
                    // Search for the inorder predecessor  and
                    // replace deleted node’s data with ip.

                    Node<E> max= findLargestChild(localRoot.left, null,level%dimension);
                    localRoot= delete(localRoot, max.data, 0);
                    localRoot.data = max.data;
                   return localRoot;
               }
            }
        }
    }

    /**
     *Finds the largestChild
     * @param StartNode
     * @param Max
     * @param dim
     * @return
     */
    private Node<E> findLargestChild(Node<E> StartNode, Node<E> Max,int dim) {
        if (StartNode==null)
            return null;
        Vector<Node<E>> vec= new Vector<>();
        vec.add(StartNode);

        while(!vec.isEmpty())
        {
            Node<E > temp=vec.remove(0);
            if(Max==null)
                Max=temp;
            else if(Max.data.get(dim).compareTo(temp.data.get(dim))<=0)
                Max=temp;
            if(temp.left!=null)
                vec.add(temp.left);
            if(temp.right!=null)
                vec.add(temp.right);
        }
        System.out.println(Max+"***");
        return Max;
    }

    /**
     *Removes target from tree.
     * @param target Item to be removed
     * @return
     */
    @Override
    public boolean remove(ArrayList<E> target) {
        return (delete(target)!=null);
    }


}
