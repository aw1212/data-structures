package com.alex.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeSorterTest {

    @Test
    public void testMergeSort() {
        int[] numbers = {3, 8, 2, 1, 5};

        MergeSorter mergeSorter = new MergeSorter();
        int[] sorted = mergeSorter.sort(numbers);

        assertEquals(1, sorted[0]);
        assertEquals(2, sorted[1]);
        assertEquals(3, sorted[2]);
        assertEquals(5, sorted[3]);
        assertEquals(8, sorted[4]);
    }

    @Test
    public void testMergeSortBlankInput() {
        int[] numbers = {};

        MergeSorter mergeSorter = new MergeSorter();
        int[] sorted = mergeSorter.sort(numbers);

        assertEquals(0, sorted.length);
    }

    @Test
    public void testMergeSortSingleInput() {
        int[] numbers = { 3 };

        MergeSorter mergeSorter = new MergeSorter();
        int[] sorted = mergeSorter.sort(numbers);

        assertEquals(1, sorted.length);
        assertEquals(3, sorted[0]);
    }

}
