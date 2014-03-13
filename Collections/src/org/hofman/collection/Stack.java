package org.hofman.collection;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel Hofman
 * Date: 3-9-12
 * Time: 9:42
 */

import org.hofman.base.Predicate;

/**
 * Stack class represents an Last in First out collection.
 * @param <T> Java object
 */
public class Stack<T> {

    private StackNode<T> startElement;
    private int size;

    /**
     * This represents a node in singlelinked list
     * @param <T> Object
     */
    private class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T Data) {
            data = Data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public StackNode<T> getNext() {
            return next;
        }

        public void setNext(StackNode<T> next) {
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
        StackNode<T> stackNode = new StackNode<T>(object);
        stackNode.setNext(startElement);

        startElement = stackNode;
        size++;
    }

    /**
     * Removes the topmost element of the stock.
     * @return Topmost element in the stack
     */
    public T pop()
    {
        // Store first node in temp and retrieve new node
        StackNode<T> tempElement = startElement;
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
       for(StackNode<T> tempElement = startElement; tempElement.getNext() != null; tempElement = tempElement.getNext() )
       {
            if(object.equals(tempElement.getData()))
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the string representation of all the elements in the stack.
     * @return String representation of the elements
     */
    public String printStack()
    {
        Predicate<T> predicate = new Predicate<T>() {
            @Override
            public Boolean apply(T object) {
                return true;
            }
        };

        return this.printStack(predicate);
    }

    /**
     * Returns an string representation of the elements in the stack satisfying the given predicate. {@code predicate}
     * @param predicate
     * @return String representation of the elements
     */
    public String printStack(Predicate<T> predicate)
    {
        StringBuilder builder = new StringBuilder();

        for(StackNode<T> tempElement = startElement; tempElement != null; tempElement = tempElement.getNext())
        {
            if(predicate.apply(tempElement.getData()))
            {
                builder.append(tempElement.getData().toString());
                builder.append("\n");
            }
        }

        return builder.toString();
    }
}
