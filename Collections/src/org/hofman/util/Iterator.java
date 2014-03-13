package org.hofman.util;

/**
 * Created by Maikel on 13-3-14.
 */
public interface Iterator<T> {

    public boolean hasNext();

    public T next();

    void remove();
}
