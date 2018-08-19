package com.alex.algorithms.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchUtilTest {

    @Test
    public void testBinarySearchEvenNumOfElements() {
        int[] sortedArray = { 5, 7, 11, 52, 78, 99, 112, 502, 707, 1001 };

        int i = SearchUtil.binarySearch(sortedArray, 78);

        assertEquals(4, i);
    }

    @Test
    public void testBinarySearchOddNumOfElements() {
        int[] sortedArray = { 5, 7, 11, 52, 78, 99, 112, 502, 707 };

        int i = SearchUtil.binarySearch(sortedArray, 502);

        assertEquals(7, i);
    }

    @Test
    public void testBinarySearchNotInArray() {
        int[] sortedArray = { 5, 7, 11, 52, 78, 99, 112, 502, 707, 1001 };

        int i = SearchUtil.binarySearch(sortedArray, 111);

        assertEquals(-1, i);
    }

}