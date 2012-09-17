package org.hofman.collection;

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
     * @param Object
     */
    @Override
    public void add(T Object) {
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
    }

    /**
     * Insert object at specified index. If index is larger then size, Exception is thrown.
     * @param Object
     * @param Index
     */
    @Override
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
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean remove(int Index) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int Size() {
        return size;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T head() {
        return startNode.getData();
    }

    @Override
    public T tail() {
        return endNode.getData();
    }

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
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for(Node<T> tempElement = startNode; tempElement != null; tempElement = tempElement.getNext())
        {
            builder.append(tempElement.getData().toString());
            builder.append("\n");
        }

        return builder.toString();
    }
}
