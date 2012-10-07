package org.hofman.collection;

import org.hofman.base.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 6-9-12
 */

/**
 * Implementation of an SortedList using an AVL tree.
 * @param <T>
 */
public class SortedList<T extends Comparable> implements IList<T> {

    private AVLNode<T> root;
    private int size;

    private class AVLNode<T>
    {
        private T data;
        private AVLNode<T> left;
        private AVLNode<T> right;
        private AVLNode<T> parent;

        public AVLNode()
        {
            setData(null);
            setLeft(null);
            setRight(null);
            setParent(null);
        }

        public AVLNode(T object)
        {
            this();
            setData(object);
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public AVLNode<T> getLeft() {
            return left;
        }

        public void setLeft(AVLNode<T> left) {
            this.left = left;
        }

        public AVLNode<T> getRight() {
            return right;
        }

        public void setRight(AVLNode<T> right) {
            this.right = right;
        }

        public AVLNode<T> getParent() {
            return parent;
        }

        public void setParent(AVLNode<T> parent) {
            this.parent = parent;
        }

        /**
         * Calculates the balance of the tree
         * @return Int balance of the tree
         */
        public int balance()
        {
            return (getRightTreeHeight() - getLeftTreeHeight());
        }

        public int getLeftTreeHeight() {
            return (left == null) ? 0 : 1 + left.getLeftTreeHeight();
        }

        public int getRightTreeHeight() {
            return (right == null) ? 0 : 1 + right.getRightTreeHeight();
        }
    }

    public SortedList()
    {
        root = null;
        size = 0;
    }

    @Override
    public T head() {
        if(root != null)
        {
            return head(root).getData();
        }

        return null;
    }

    private AVLNode<T> head(AVLNode<T> node)
    {
        while (node.getLeft() != null)
        {
            node = node.getLeft();
        }

        return node;
    }

    @Override
    public T tail() {
        if(root != null)
        {
            return tail(root).getData();
        }

        return null;
    }

    private AVLNode<T> tail(AVLNode<T> node)
    {
        while (node.getRight() != null)
        {
            node = node.getRight();
        }

        return node;
    }

    @Override
    public T get(int Position) throws IndexOutOfBoundsException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean add(T Object) {

        boolean returnVal;

        if(root == null)
        {
            root = new AVLNode<T>(Object);
            returnVal = true;
        }
        else
        {
            returnVal = add(Object, root);
        }

        size++;

        return returnVal;
    }

    private boolean add(T Object, AVLNode<T> node)
    {
        if(Object.compareTo(node.getData()) < 0)
        {
            if(node.getLeft() == null) {
                node.setLeft(new AVLNode<T>(Object));
                node.getLeft().setParent(node);

                reBalance(root);
                return true;
            }
            else {
                return add(Object, node.getLeft());
            }
        }
        else
        {
            if(node.getRight() == null)
            {
                node.setRight(new AVLNode<T>(Object));
                node.getRight().setParent(node);

                reBalance(root);
                return true;
            }
            else
            {
                return add(Object, node.getRight());
            }
        }


    }

    /**
     * Checks if the tree is still in balance, if not performs operations to rebalance
     */
    private void reBalance(AVLNode<T> node)
    {
        // Tree is right heavy
        if(node.balance() > 1)
        {
            if(node.getRight().balance() < -1)
            {
                rightLeftRotation(node);
            }
            else
            {
                singleLeftRotation(node);
            }
        }
        else if(node.balance() < -1 )
        {
            if(node.getLeft().balance() > 1)
            {
                leftRightRotation(node);
            }
            else
            {
                singleRightRotation(node);
            }
        }
    }

    private AVLNode<T> singleLeftRotation(AVLNode<T> rotationBase)
    {
        // Set pivot point
        AVLNode<T> pivot = rotationBase.getRight();

        // Detach right subtree and add left subtree of pivot
        rotationBase.setRight(rotationBase.getLeft());
        rotationBase.getRight().setParent(rotationBase);
        pivot.setParent(rotationBase.getParent());

        // Set new root
        pivot.setLeft(rotationBase);
        pivot.getLeft().setParent(pivot);

        return pivot;
    }

    private AVLNode<T> singleRightRotation(AVLNode<T> rotationBase)
    {
        // Set pivot point
        AVLNode<T> pivot = rotationBase.getLeft();

        // Detach right subtree and add left subtree of pivot
        rotationBase.setLeft(rotationBase.getRight());
        rotationBase.getLeft().setParent(rotationBase);
        pivot.setParent(rotationBase.getParent());

        // Set new root
        pivot.setRight(rotationBase);
        pivot.getRight().setParent(pivot);

        return pivot;
    }

    private AVLNode<T> leftRightRotation(AVLNode<T> rotationBase)
    {
        return singleRightRotation( singleLeftRotation(rotationBase.getLeft()));
    }

    private AVLNode<T> rightLeftRotation(AVLNode<T> rotationBase)
    {
        return singleLeftRotation(singleLeftRotation(rotationBase.getRight()));
    }

    @Override
    public boolean remove(T Object) {

        AVLNode<T> nodeToRemove = find(Object);

        if(nodeToRemove != null)
        {
            remove(nodeToRemove);
            size--;
            return true;
        }

        return false;
    }

    /**
     * Removes node from the three
     * @param node node to remove
     */
    private void remove(AVLNode<T> node)
    {
        // Leaf node so deletion is simple
        if(node.getLeft() == null && node.getRight() == null)
        {
            if(node.getParent().getData().compareTo(node.getData()) < 0)
            {
                node.getParent().setRight(null);
            }
            else
            {
                node.getParent().setLeft(null);
            }
        }
        // Node with two childeren
        else if(node.getLeft() != null && node.getRight() != null)
        {
            // Find minimum in right tree
            AVLNode<T> minNode = head(node.getRight());
            node.setData(minNode.getData());
            remove(minNode);
        }
        else
        {
            // Only one child node
            if(node.getLeft() != null)
            {
                node.getLeft().setParent(null);
                node.setData(node.getLeft().getData());
                node.setLeft(null);
            }
            else
            {
                node.getRight().setParent(null);
                node.setData(node.getRight().getData());
                node.setRight(null);
            }
        }

        reBalance(root);
    }

    /**
     * Searches for an element in the collection
     * @param object object to find
     * @return True if object is found, otherwise return false
     */
    @Override
    public boolean contains(T object) {
        return find(object) != null;
    }

    private AVLNode<T> find(T object)
    {
        AVLNode<T> temp = root;

        while(temp != null)
        {
            if(temp.getData().equals(object))
            {
                return temp;
            }

            int compare = object.compareTo(temp.getData());

            temp = (compare < 0) ? temp.getLeft() : temp.getRight();
        }

        return null;
    }

    @Override
    public int size() {
        return size;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String toString()
    {
        return toString(new Predicate<T>() {
            @Override
            public boolean apply(T object) {
                return true;
            }
        });
    }

    @Override
    public String toString(Predicate<T> predicate) {
        if(root == null)
        {
            return null;
        }
        else
        {
            return inOrderTraversalPrint(root, predicate);
        }
    }

    /**
     * Print the all the elements were the applied predicate is true in order.
     * @param node Node to start
     * @param predicate Predicate to apply
     * @return String representation of binarytree
     */
    private String inOrderTraversalPrint(AVLNode<T> node, Predicate<T> predicate)
    {
        // TODO: Simple additions of an string are slow find something faster
        String temp = "";
        if(node.getLeft() != null)
        {
            temp += inOrderTraversalPrint(node.getLeft(), predicate);
        }

        if(predicate.apply(node.getData()))
        {
            temp += node.getData().toString() + "\n";
        }

        if(node.getRight() != null)
        {
            temp += inOrderTraversalPrint(node.getRight(), predicate);
        }

        return temp;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
}
