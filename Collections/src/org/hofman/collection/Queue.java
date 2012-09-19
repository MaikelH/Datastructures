package org.hofman.collection;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 6-9-12
 * Time: 11:04
 */
public class Queue<T> implements ICollection<T> {

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

    public Queue()
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
    public boolean remove(T Object) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public T remove()
    {
        if(size > 0)
        {
            Node<T> tempNode = startNode;

            startNode.getNext().setPrevious(null);
            startNode = startNode.getNext();

            size--;

            return tempNode.getData();
        }

        throw new NoSuchElementException();
    }

    @Override
    public int size() {
        return size;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
