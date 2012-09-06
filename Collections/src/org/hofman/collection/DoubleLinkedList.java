package org.hofman.collection;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 6-9-12
 * Time: 11:06
 */
public class DoubleLinkedList<T> implements IList<T> {
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

    public void DoubleLinkedList()
    {
        startNode = null;
        endNode = null;
        size = 0;
    }

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

    private void remove(Node<T> node)
    {

    }

    @Override
    public int Size() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T head() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T tail() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T get(int Position) throws IndexOutOfBoundsException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Returns the string representation of all the objects in the stack.
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        Node<T> tempElement = startNode;

        while(tempElement != null)
        {
            builder.append(tempElement.getData().toString());
            builder.append("\n");
            tempElement = tempElement.getNext();
        }

        return builder.toString();
    }
}
