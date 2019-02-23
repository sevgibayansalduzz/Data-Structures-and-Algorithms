package Part2;

import Part1.BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class BInaryTree< E > implements Serializable {


    protected static class Node<E> implements Serializable {
        // Data Fields
        /**
         * The information stored in this collection.
         */
        protected ArrayList<E> data;
        /**
         * Reference to the left child.
         */
        protected Node<E> left;

        /**
         * Reference to the right child.
         */
        protected Node<E> right;

        // Constructors

        /**
         * Construct a node with given data and no children.
         *
         * @param data The data to store in this node
         */
        public Node(ArrayList<E> data) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods

        /**
         * Return a string representation of the node.
         *
         * @return A string representation of the data fields
         */
        public String toString() {
            return data.toString();
        }
    }

    // Data Field
    /**
     * The root of the binary tree
     */
    protected Node<E> root;

    public BInaryTree() {
        root = null;
    }

    protected BInaryTree(Node < E > root) {
        this.root = new Node<E>(root.data);
    }

    /** Constructs a new binary tree with data in its root,leftTree
     as its left subtree and rightTree as its right subtree.
     */
    public BInaryTree(ArrayList<E> data, BInaryTree < E > leftTree, BInaryTree < E > rightTree) {
        root = new Node < E > (data);
        if (leftTree != null) {
            root.left = leftTree.root;
        }
        else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        }
        else {
            root.right = null;
        }
    }

    /**
     * Return the left subtree.
     *
     * @return The left subtree or null if either the root or
     * the left subtree is null
     */
    public BInaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BInaryTree<E>(root.left);
        } else {
            return null;
        }
    }

    /**
     * Return the right sub-tree
     *
     * @return the right sub-tree or
     * null if either the root or the
     * right subtree is null.
     */
    public BInaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BInaryTree<E>(root.right);
        } else {
            return null;
        }
    }


    /**** BEGIN EXERCISE ****/
    /**
     * Return the data field of the root
     * @return the data field of the root
     * or null if the root is null
     */
    public ArrayList<E> getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }
    /**** END EXERCISE ****/

    /**
     * Determine whether this tree is a leaf.
     *
     * @return true if the root has no children
     */
    public boolean isLeaf(Node<E> root) {
        return (root.left == null && root.right == null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, sb,1);
        return sb.toString();
    }

    private void preOrderTraverse(Node<E> node, StringBuilder sb, int depth) {

        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        }
        else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, sb, depth + 1);
            preOrderTraverse(node.right, sb, depth + 1);
        }
    }
}