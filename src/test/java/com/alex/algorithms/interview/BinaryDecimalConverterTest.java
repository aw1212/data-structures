package com.alex.algorithms.interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryDecimalConverterTest {

    private BinaryDecimalConverter binaryDecimalConverter;

    @Before
    public void init() {
        binaryDecimalConverter = new BinaryDecimalConverter();
    }

    @Test
    public void testBinaryToDecimalConversion() {
        byte[] binary = {0, 1, 1, 0, 1, 1};

        int result = binaryDecimalConverter.convertBinaryToDecimal(binary);

        assertEquals(27, result);
        System.out.println(87 << 1);
    }

}