package com.softserve.educ;

import org.junit.Assert;
import org.junit.Test;

import com.softserve.edu.TheSmallestNumber;

/**
 * FirstClassTest.java.
 *
 * @version 1.0 29 January 2017
 * @author Yulian Shutiak
 */
public class FirstClassTest {

    /**
     * Test method.
     */
    @Test
    public void testMain() {
        TheSmallestNumber tsn = new TheSmallestNumber();
        int actual = tsn.count(200);
        int expected = 8;

        Assert.assertEquals(actual, expected);
    }

}
