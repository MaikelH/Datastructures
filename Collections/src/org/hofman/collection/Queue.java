package org.hofman.collection;

import org.hofman.base.Predicate;

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

    @Override
    public boolean remove(T Object) {
        for(Node<T> tempElement = startNode; tempElement != null; tempElement = tempElement.getNext())
        {
            if(tempElement.getData().equals(Object))
            {
                destroy(tempElement);
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

    public T dequeue()
    {
        if(size > 0)
        {
            Node<T> tempElement = startNode;
            destroy(startNode);

            return startNode.getData();
        }

        throw new NoSuchElementException();
    }

    private void destroy(Node<T> node)
    {
        // If node is at the beginning set begin to next of the node
        if(node.getPrevious() == null)
        {
            startNode = node.getNext();
            size--;
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
            size--;
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

    public String toString()
    {
        return toString(new Predicate<T>() {
            @Override
            public Boolean apply(T object) {
                return true;
            }
        });
    }

    @Override
    public String toString(Predicate<T> predicate) {
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
        return (size() == 0);
    }
}
