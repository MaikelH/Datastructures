package org.hofman.collection;

import org.hofman.base.Function;
import org.hofman.base.Predicate;

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

    double average(Function<T, Double> input);

    /**
     * Filters a sequence of values based on the predicate.
     * @param predicate
     * @return IList<T>
     */
    IList<T> where(Predicate<T> predicate);
}
