package com.alex.algorithms.sorting;

public class QuickSorter implements DivideAndConquerSorting {

//    private static int originalPivot = -1;
//    private static boolean originalPivotUsed = false;

    @Override
    public int[] sort(int[] input) {
        if (input.length < 2) {
            return input;
        }

        return sortPivot(input, input.length, 0);
    }

    private int[] sortPivot(int[] array, int endLeft, int startRight) {
        if (endLeft == 0 && startRight == array.length) {
            return array;
        }

        if (endLeft > 0) {
            int pivotIndex = swap(array, 0, endLeft);
//            if (originalPivot == -1) {
//                originalPivot = pivotIndex;
//            }
            return sortPivot(array, pivotIndex, startRight);
        }

        //TODO start right remains at 0 even though we already found the first pivot and should set that to start right
//        int pivotIndex;
//        if (!originalPivotUsed) {
//            pivotIndex = swap(array, originalPivot + 1, array.length);
//            originalPivotUsed = true;
//        } else {
//            pivotIndex = swap(array, startRight, array.length);
//        }
        int pivotIndex = swap(array, startRight, array.length);
        return sortPivot(array, endLeft, pivotIndex + 1);
    }

    private int swap(int[] array, int start, int end) {
        int pivotIndex = end - 1;
        int pivot = array[pivotIndex];

        boolean swapsNeeded;
        do {
            swapsNeeded = false;
            for (int i = start; i < end; i++) {
                if (array[i] < pivot && i > pivotIndex || array[i] > pivot && i < pivotIndex) {
                    array[pivotIndex] = array[i];
                    array[i] = pivot;
                    pivotIndex = i;
                    swapsNeeded = true;
                }
            }
        } while (swapsNeeded);

        return pivotIndex;
    }

}
