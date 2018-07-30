package com.alex.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSorterTest {

    @Test
    public void sort() {
        int[] array = { 5, 1, 7, 9, 3, 2, 4, 6};

        QuickSorter quickSorter = new QuickSorter();
        quickSorter.sorty(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}