package org.hofman.collection;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel Hofman
 * Date: 3-9-12
 * Time: 9:57
 */

public class SingleLinkedList<T> implements IList<T> {
    private Node<T> _firstElement;
    private int _size;

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T Data) {
            data = Data;
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

    public SingleLinkedList() {
        _size = 0;
        _firstElement = null;
    }

    public SingleLinkedList(T Object) {
        this();
        _firstElement = new Node<T>(Object);
        _size++;
    }

    @Override
    public void add(T Object) {
        Node<T> node = new Node<T>(Object);
        _firstElement.setNext(node);
        _size++;
    }

    @Override
    public void add(T Object, int Position) {
        int index = 0;


    }

    @Override
    public boolean remove(T Object) {
        if(_firstElement != null)
        {
            Node<T> checkElement = _firstElement;

        }
        return false;
    }

    @Override
    public int Size() {
        return _size;
    }

    @Override
    public T get(int Position) {
        if(Position > _size)
        {
            throw new IndexOutOfBoundsException();
        }
        return _firstElement.getData();
    }
}
