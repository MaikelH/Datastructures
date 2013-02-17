package org.hofman.base;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 16-2-13
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
public interface Function<A, B> {
    public B apply(A input);
}
