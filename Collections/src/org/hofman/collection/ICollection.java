package org.hofman.collection;

import org.hofman.base.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 3-9-12
 * Time: 11:14
 */
public interface ICollection<T> {
    public boolean add(T Object);
    public boolean remove(T Object);
    public boolean contains(T object);
    public int size();
    public String toString(Predicate<T> predicate);
    public boolean isEmpty();
}
