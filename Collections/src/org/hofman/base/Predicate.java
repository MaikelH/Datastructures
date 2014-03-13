package org.hofman.base;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 8-9-12
 * Time: 13:39
 */

/**
 * Determines a true or false output given the input
 *
 * @param <T> Any java object
 */
public interface Predicate<T> extends Function<T, Boolean>  {

    /**
     * Returns the result of the computation performed on object.
     * @param object
     * @return boolean
     */
    public Boolean apply(T object);
}

