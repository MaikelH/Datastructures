package org.hofman.collection;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 23-9-12
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
public interface IList<T> extends ICollection<T> {

    T head();

    T tail();

    T get(int Position) throws IndexOutOfBoundsException;
}
