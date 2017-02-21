package com.softserve.educ;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.softserve.edu.PythagoreanTriples;

/**
 * ThirdClassTest.java.
 *
 * @version 1.0 29 January 2017
 * @author Yulian Shutiak
 */
public class ThirdClassTest {

    /**
     * Test method.
     */
    @Test
    public final void testThird() {
        PythagoreanTriples pt = new PythagoreanTriples();
        ArrayList<Integer> actual;
        actual = pt.count(200);
        ArrayList<Integer> expected = new ArrayList<Integer>
        (Arrays.asList(9, 16, 25, 25, 144, 169, 36, 64, 100));

        Assert.assertEquals(actual, expected);
    }

    /**
     * Test method.
     */
    /*
    @Test
    public final void testMain() {
    }
*/
}
