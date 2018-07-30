package com.alex.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BubbleSorterTest {

    @Test
    public void testBubbleSort() {
        Integer[] numbers = { 4, 5, 1, 4, 3, 8, 2 };

        BubbleSorter<Integer> bubbleSorter = new BubbleSorter<>();
        bubbleSorter.sort(numbers);

        assertEquals(1, (int) numbers[0]);
        assertEquals(2, (int) numbers[1]);
        assertEquals(3, (int) numbers[2]);
        assertEquals(4, (int) numbers[3]);
        assertEquals(4, (int) numbers[4]);
        assertEquals(5, (int) numbers[5]);
        assertEquals(8, (int) numbers[6]);
    }

    @Test
    public void testBubbleSortEmptyInput() {
        Integer[] numbers = {};

        BubbleSorter<Integer> bubbleSorter = new BubbleSorter<>();
        bubbleSorter.sort(numbers);

        assertEquals(0, numbers.length);
    }

}
