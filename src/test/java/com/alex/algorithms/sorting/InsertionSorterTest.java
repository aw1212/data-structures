package com.alex.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsertionSorterTest {

    @Test
    public void testInsertionSort() {
        Integer[] numbers = { 4, 5, 1, 4, 3, 8, 2 };

        InsertionSorter<Integer> insertionSorter = new InsertionSorter<>();
        insertionSorter.sort(numbers);

        assertEquals(1, (int) numbers[0]);
        assertEquals(2, (int) numbers[1]);
        assertEquals(3, (int) numbers[2]);
        assertEquals(4, (int) numbers[3]);
        assertEquals(4, (int) numbers[4]);
        assertEquals(5, (int) numbers[5]);
        assertEquals(8, (int) numbers[6]);
    }

    @Test
    public void testInsertionSortEmptyInput() {
        Integer[] numbers = {};

        InsertionSorter<Integer> insertionSorter = new InsertionSorter<>();
        insertionSorter.sort(numbers);

        assertEquals(0, numbers.length);
    }

}
