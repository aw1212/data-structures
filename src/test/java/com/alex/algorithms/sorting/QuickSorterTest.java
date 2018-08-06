package com.alex.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickSorterTest {

    @Test
    public void testQuickSort() {
        int[] numbers = {3, 8, 2, 1, 5};

        QuickSorter quickSorter = new QuickSorter();
        int[] sorted = quickSorter.sort(numbers);

        assertEquals(1, sorted[0]);
        assertEquals(2, sorted[1]);
        assertEquals(3, sorted[2]);
        assertEquals(5, sorted[3]);
        assertEquals(8, sorted[4]);
    }

}