package com.softserve.educ;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.softserve.edu.ThreeNumbers;

/**
 * SecondClassTest.java.
 *
 * @version 1.0 29 January 2017
 * @author Yulian Shutiak
 */
public class SecondClassTest {

    /**
     * Test method.
     */
    @Test
    public final void testSecond() {
        ThreeNumbers tn = new ThreeNumbers();
        ArrayList<Integer> actual;
        actual = tn.count(300);
        ArrayList<Integer> expected = new ArrayList<Integer>
        (Arrays.asList(2, 10, 14));

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
