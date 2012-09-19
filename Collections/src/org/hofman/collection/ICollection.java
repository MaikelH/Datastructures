package org.hofman.collection;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 3-9-12
 * Time: 11:14
 */
public interface ICollection<T> {
    public void add(T Object);
    public boolean remove(T Object);
    public int size();
}
