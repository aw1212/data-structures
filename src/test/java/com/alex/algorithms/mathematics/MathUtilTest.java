package com.alex.algorithms.mathematics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathUtilTest {

    @Test
    public void testFibonacci() {
        int fibonacci = MathUtil.recursiveFibonacci(5);

        assertEquals(8, fibonacci);
    }

}