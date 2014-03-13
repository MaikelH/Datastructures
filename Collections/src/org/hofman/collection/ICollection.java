package org.hofman.collection;

import org.hofman.base.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel Hofman
 * Date: 3-9-12
 * Time: 11:14
 */
public interface ICollection<T> {

    /**
     * Adds a new element to the collection.
     * @param Object Element to add
     * @return True if the insertion is successful, false if otherwise,
     */
    public boolean add(T Object);

    /**
     * Remove an object from the collection.
     * @param Object Object to remove
     * @return True if element is removed, false otherwise.
     */
    public boolean remove(T Object);

    /**
     * Checks if the collections contains the specified object.
     * @param object
     * @return True if object is found
     */
    public boolean contains(T object);

    /**
     *
     * @return
     */
    public int size();

    /**
     *
     * @param predicate
     * @return
     */
    public String toString(Predicate<T> predicate);

    /**
     *
     * @return
     */
    public boolean isEmpty();


}
