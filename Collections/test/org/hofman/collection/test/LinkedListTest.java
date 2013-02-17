package org.hofman.collection.test;

import org.hofman.collection.LinkedList;

import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 16-2-13
 * Time: 18:18
 * To change this template use File | Settings | File Templates
 */
public class LinkedListTest {
    @org.junit.Test
    public void testAdd() throws Exception {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.size() == 3);
        assertTrue(list.get(0) == 1);
        assertTrue(list.get(1) == 2);
        assertTrue(list.get(2) == 3);
    }


}
