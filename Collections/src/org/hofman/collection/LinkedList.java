package org.hofman.collection;

import org.hofman.base.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 6-9-12
 * Time: 11:06
 */
public class LinkedList<T> implements IList<T> {
    private Node<T> startNode;
    private Node<T> endNode;
    private int size;

    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> previous;

        public Node(T Data) {
            data = Data;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    /**
     *
     * Creates a new LinkedList
     */
    public void LinkedList()
    {
        startNode = null;
        endNode = null;
        size = 0;
    }

    /**
     * Insert object at the end of list.
     * @param Object Last object in the list
     */
    @Override
    public boolean add(T Object) {
        Node<T> tempNode = new Node<T>(Object);

        // If size == 0, no objects are inserted yet.
        if(startNode == null)
        {
            startNode = tempNode;
            endNode = tempNode;
            tempNode.setNext(null);
            tempNode.setPrevious(null);
        }
        else
        {
            endNode.setNext(tempNode);
            tempNode.setPrevious(endNode);
            endNode = tempNode;
        }

        size++;

        return true;
    }

    /**
     * Insert object at specified index. If index is larger then size, Exception is thrown.
     * @param Object
     * @param Index
     * TODO: change add functions so that only one functions remains
     */
    public void add(T Object, int Index) {
        if(Index > size)
        {
            throw new IndexOutOfBoundsException();
        }

        int indexNumber = 0;
        Node<T> tempNode = startNode;

        while(indexNumber != Index - 1)
        {
            tempNode = tempNode.getNext();
            indexNumber++;
        }

        InsertAfter(tempNode, new Node<T>(Object));
    }

    private void InsertAfter(Node<T> node, Node<T> newNode)
    {
        newNode.setPrevious(node.getPrevious());
        newNode.setNext(node.getNext());

        if(node.getNext() == null)
        {
            endNode = newNode;
        }
        else
        {
            node.getNext().setPrevious(newNode);
        }

        node.next = newNode;

        size++;
    }

    @Override
    public boolean remove(T Object) {

        for(Node<T> tempNode = startNode; tempNode != null; tempNode = tempNode.getNext())
        {
            if(tempNode.getData().equals(Object))
            {
                destroy(tempNode);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contains(T object) {
        for(Node<T> tempElement = startNode; tempElement != null; tempElement = tempElement.getNext())
        {
            if(tempElement.getData().equals(object))
            {
                return true;
            }
        }

        return false;
    }


    /**
     * Removes the object at the specified index
     * @param Index
     * @return
     */
    public boolean remove(int Index) {
        Node<T> tempNode = startNode;

        for(int i = 0; i < size; i++)
        {
            if(i == Index)
            {
                destroy(tempNode);
                return true;
            }

            tempNode = tempNode.getNext();
        }

        return false;
    }

    /**
     * Removes the node
     * @param node node to remove
     */
    private void destroy(Node<T> node)
    {
        // If node is at the beginning set begin to next of the node
        if(node.getPrevious() == null)
        {
            startNode = node.getNext();
            return;
        }
        else
        {
            node.getPrevious().setNext(node.getNext());
        }
        // If node is at the end, set
        if(node.getNext() == null)
        {
            endNode = node.getPrevious();
            return;
        }
        else
        {
            node.getNext().setPrevious(node.getPrevious());
        }

        // Remove node
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());

        size--;
    }

    @Override
    public int size() {
        return size;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @return first element in the list
     */
    @Override
    public T head() {
        return startNode.getData();
    }

    /**
     * Returns the last element in the list
     * @return last element in list
     */
    @Override
    public T tail() {
        return endNode.getData();
    }

    /**
     * Retrieves the element at the specified position.
     * @param Position
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T get(int Position) throws IndexOutOfBoundsException {

        if(Position >= size || Position < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        Node<T> tempElement = startNode;

        for(int i = 0; i != Position; i++)
        {
            tempElement = tempElement.getNext();
        }

        return tempElement.getData();
    }

    /**
     * Returns the string representation of all the objects in the stack.
     * @return String
     */
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

    public String toString(Predicate<T> predicate)
    {
        StringBuilder builder = new StringBuilder();

        for(Node<T> tempElement = startNode; tempElement != null; tempElement = tempElement.getNext())
        {
            if(predicate.apply(tempElement.getData()))
            {
                builder.append(tempElement.getData().toString());
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    @Override
    public boolean isEmpty() {
        if(size() == 0)
        {
            return true;
        }

        return false;
    }
}
