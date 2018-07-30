package com.alex.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SelectionSorterTest {

    @Test
    public void testSelectionSort() {
        Integer[] numbers = {3, 8, 2, 1, 5};

        SelectionSorter<Integer> selectionSorter = new SelectionSorter<>();
        selectionSorter.sort(numbers);

        assertEquals(1, (int) numbers[0]);
        assertEquals(2, (int) numbers[1]);
        assertEquals(3, (int) numbers[2]);
        assertEquals(5, (int) numbers[3]);
        assertEquals(8, (int) numbers[4]);
    }

}