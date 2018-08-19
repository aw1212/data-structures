package com.alex.algorithms.search;

public class SearchUtil {

    public static int binarySearch(int[] sortedArray, int val) {
        if (sortedArray == null || sortedArray.length == 0) {
            return -1;
        }

        return search(sortedArray, 0, sortedArray.length - 1, val);
    }

    private static int search(int[] sortedArray, int startIndex, int endIndex, int val) {
        if (endIndex <= startIndex) {
            return -1;
        }

        int middleIndex = (startIndex + endIndex) / 2;

        if (sortedArray[middleIndex] == val) {
            return middleIndex;
        }

        if (val < sortedArray[middleIndex]) {
            return search(sortedArray, startIndex, middleIndex - 1, val);
        }

        return search(sortedArray, middleIndex + 1, endIndex, val);
    }

}
