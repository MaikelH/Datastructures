package org.hofman.collection;

import org.hofman.base.Function;
import org.hofman.base.Predicate;
import org.hofman.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 23-9-12
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
public interface IList<T> extends ICollection<T>, org.hofman.util.Iterable<T> {

    /**
     * Last element in the collection.
     * @return T
     */
    T head();

    /**
     * First element in the collection
     * @return T
     */
    T tail();

    /**
     * Adds a object to the collection at the specified index.
     * @param object
     * @param index
     */
    void add(T object, int index);

    /**
     * Returns the element at the specified position.
     * @param Position
     * @return
     * @throws IndexOutOfBoundsException
     */
    T get(int Position) throws IndexOutOfBoundsException;

    /**
     * Return the average of this collection using the specified function.
     * @param input Function to calculate the average
     * @return Double
     */
    double average(Function<T, Double> input);

    /**
     * Filters this collection based on the predicate.
     * @param predicate Predicate used for filtering
     * @return IList<T> All values for which the predicate is true.
     */
    IList<T> where(Predicate<T> predicate);

    /**
     * Removes the object at the specified index. The object at index + 1 will then be at index.
     * @param index
     * @return True if object is succesfully removed, false otherwise.
     */
    boolean remove(int index);
}
