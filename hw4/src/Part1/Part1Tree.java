package Part1;

import java.util.LinkedList;
import java.util.Queue;

public class Part1Tree<E> extends BinaryTree {

    /**
     * Default constructor.
     */
    public Part1Tree() { super(); }

    /**
     * This data field stores the return of the add method.
     */
    private boolean addReturn;

    /**
     /** Constructs a new binary tree with data in its root,leftTree
     as its left subtree and rightTree as its right subtree.
     * @param data
     * @param leftTree
     * @param rightTree
     */
    public Part1Tree(final E data, BinaryTree< E > leftTree, BinaryTree< E > rightTree)
    {
        super(data,leftTree,rightTree);
    }

    /**
     * This add method adds the first item into the tree.
     * @param firstItem Takes generic type parameter.
     * @return Returns boolean.
     */
    public boolean add(final E firstItem)
    {
        if (root!=null)
            return false;
        else{
            root=new Node<E>(firstItem);
            return true;
        }
    }

    /**
     *  This method takes a parentItem and a childItem and inserts the childItem as the last child
     *  of the parentItem if the parentItem is already in suach a tree structure.
     * @param parentItem Takes a parentItem.
     * @param childrenItem Takes a childItem.
     * @return Returns boolean.
     */
    public boolean add(final E parentItem,final E childrenItem)
    {
        root=add(root,parentItem,childrenItem);
        return addReturn;
    }

    /**
     *This recursive method is called by two parameter add method.Takes ParentItem, childItem and root.
     * <p>
     *     <li>if localRoot equals the null
     *      <li>That means ParentITem is not in the tree.So the method returns null and the data field addReturn is set false.</li>
     *      If parentItem  equals the  localRoot
     *      <li>The ChildItem is added to tre <\n>if the childItem is the first child of the parentItem,the childItem is added to left of the parentItem</\n> </li>
     *      <\n>İf is not , the traverseSibling finds the youngest child and the add method adds the ChildItem to right of the youngest child.</\n>
     *      </li>
     *      OtherWise this method calls itself .
     * </p>
     * @param localRoot
     * @param parentItem
     * @param childItem
     * @return
     */
    private Node<E> add(Node<E>localRoot,final E parentItem,final E childItem)
    {
        if (localRoot==null)
        {
            addReturn=false;
            return null;
        }
        else if (parentItem.equals(localRoot.data))
        {
            if(localRoot.left==null)
                localRoot.left=new Node<>(childItem);
            else
                traverseSibling(localRoot.left).right=new Node<E>(childItem);
            addReturn=true;
            return localRoot;
        }else
        {
            localRoot.right=add(localRoot.right,parentItem,childItem);
            localRoot.left=add(localRoot.left,parentItem,childItem);
            return localRoot;
        }
    }

    private Node<E> traverseSibling(Node<E> FirstChild) {
        if (FirstChild.right==null)
            return FirstChild;
        return  traverseSibling(FirstChild.right);
    }

    /**
     * This Method calls the 3 parameter levelOrderSearch method.
     * @param target Takes generic parameter.
     * @return Returns the Node reference.
     */
    public Node<E> levelOrderSearch(final E target)
    {
        Queue<Node<E>> queue=new LinkedList<>();
        Node<E> ret = levelOrderSearch(root,target,queue);
        if (ret==null)
          return null;
        else return ret;
    }

    /**
     * Traverses the tree in level order.Return the Node reference if the item is in the tree and null if it is not in the tree
     *<p>
     *     <li>if localRoot  equals the null
     *      <li>That means target is not in the tree.The method returns null</li>
     *      If target equals the data of the localRoot
     *      <li>That means target is  in the tree.The method returns localRoot</li>
     *      OtherWise this method calls itself .
     *      <li>this method adds the elements of the tree into the queue in level order.At the same time
     *      when making the insert, the method search the target and deletes the element ,that made the comparison ,
     *      from the tail.</li>
     * </p>
     * @param localRoot
     * @param target
     * @param queue
     * @return Retruns the Node reference.
     */
    protected Node<E> levelOrderSearch(Node localRoot,E target,Queue<Node<E>> queue) {
        if (localRoot==null)
            return null;
        System.out.print(localRoot+" , ");
        if (localRoot.data.equals(target))
            return localRoot;
        else
        {
            //the root is added into the queue
           if (localRoot==root)
               queue.add(root);
           //the child of the root is added in to the queue
           if (localRoot.left!=null)
            {
                //the first child of the localRoot is added into the queue
                queue.add(localRoot.left);
                Queue<Node<E>> que=new LinkedList<>();
                //the other child of the localRoot is added into the queue with the help of the addSibling method.
                addSibling(localRoot.left,que);
                queue.addAll(que);
            }
            //the head of queue is deleted
           queue.poll();
           //
           return levelOrderSearch(queue.element(),target,queue);
        }
    }

    /**
     * Adds siblings into the queue and returns this queue.
     * @param FirstChild
     * @param queue
     * @return
     */
    private Queue<Node<E>> addSibling(Node<E> FirstChild,Queue<Node<E>> queue) {

        if (FirstChild.right!=null)
        {
            queue.add(FirstChild.right);
            addSibling(FirstChild.right,queue);
        }
        return  queue;
    }


    /**
     * This method calls the helper function and traverses the left, right and root nodes respectively.
     * @param target
     * @return
     */
    public  Node<E> postOrderSearch(final E target)
    {
        Node<E> ret = postOrderSearch(root,target);
        if (ret==null)
            throw new  NullPointerException();
        else return ret;
    }

    /**
     *If localRoot is null, returns null. If not, the method searchs the target
     *  at the left node, then at the right node, and finally at the root node.
     * @param localRoot
     * @param target
     * @return
     */
    private Node<E> postOrderSearch(Node localRoot, E target) {
        if (localRoot == null)
            return null;
        Node<E> res1=postOrderSearch(localRoot.left,target);
        System.out.print(localRoot+" , ");
        if (localRoot.data.equals(target))
            return localRoot;
        Node<E> res2=postOrderSearch(localRoot.right,target);
        if(res1==null&&res2==null)
            return null;
        else if(res1!=null)
            return res1;
        else
            return res2;
    }

    /**
     * This traversal method visits the root first, then the left subtree and finally the right subtree.
     * @param node The local root
     * @param sb The string buffer to save the output
     * @param depth The depth
     */
    @Override
    protected void preOrderTraverse(Node node, StringBuilder sb, int depth) {
        if (node != null)
        {
            sb.append(node.data.toString()+" , ");
            preOrderTraverse(node.left,sb,depth);
            preOrderTraverse(node.right,sb, depth);
        }
    }
}
