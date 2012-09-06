package org.hofman.collection;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 3-9-12
 * Time: 11:14
 */
public interface IList<T> {
    public void add(T Object);
    public void add(T Object, int Index);
    public boolean remove(T Object);
    public boolean remove(int Index);
    public int Size();
    public T head();
    public T tail();
    public T get(int Position) throws IndexOutOfBoundsException;
}
