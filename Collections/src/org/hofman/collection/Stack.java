package org.hofman.collection;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel Hofman
 * Date: 3-9-12
 * Time: 9:42
 */

/**
 * Stack class represents an Last in First out collection.
 * @param <T> Java object
 */
public class Stack<T> {

    private Node<T> startElement;
    private int size;

    /**
     * This represents a node in singlelinked list
     * @param <T> Object
     */
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

    /**
     * Creates a new stack with zero elements.
     */
    public Stack()
    {
        startElement = null;
        size = 0;
    }

    /**
     * Pushes the object on the stack.
     * @param object
     */
    public void push(T object)
    {
        Node<T> node = new Node<T>(object);
        node.setNext(startElement);

        startElement = node;
        size++;
    }

    /**
     * Pops the topmost element of the stock.
     * @return Topmost element in the stack
     */
    public T pop()
    {
        // Store first node in temp and retrieve new node
        Node<T> tempElement = startElement;
        startElement = tempElement.getNext();

        size--;
        return tempElement.getData();
    }

    /**
     * Searches for an object in the stack. If this object exists return true, otherwise return false.
     * @param object Object of type T to insert in stack
     * @return True if element is found
     */
    public boolean peek(T object)
    {
        Node<T> tempElement = startElement;

        do
        {
            if(object.equals(tempElement.getData()))
            {
                return true;
            }

            tempElement = tempElement.getNext();
        } while(tempElement != null);

        return false;
    }

    /**
     * Returns the string representation of all the objects in the stack.
     * @return
     */
    public String printStack()
    {
        StringBuilder builder = new StringBuilder();

        Node<T> tempElement = startElement;

        while(tempElement != null)
        {
            builder.append(tempElement.getData().toString());
            builder.append("\n");
            tempElement = tempElement.getNext();
        }

        return builder.toString();
    }
}
