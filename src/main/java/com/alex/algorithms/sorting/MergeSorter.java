package com.alex.algorithms.sorting;

public class MergeSorter implements DivideAndConquerSorting {

    @Override
    public int[] sort(int[] input) {
        if (input.length < 2) {
            return input;
        }

        SplitArray splitArray = split(input);
        return merge(sort(splitArray.left), sort(splitArray.right));
    }

    private SplitArray split(int[] array) {
        int[] left  = new int[array.length / 2];
        int[] right = new int[array.length - left.length];

        int arrayIndex = 0;
        for (int i = 0; i < left.length; i++) {
            left[i] = array[arrayIndex++];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = array[arrayIndex++];
        }

        return new SplitArray(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] combined = new int[left.length + right.length];

        int combinedIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (combinedIndex < combined.length) {
            if (leftIndex >= left.length) {
                for (int i = rightIndex; i < right.length; i++) {
                    combined[combinedIndex++] = right[rightIndex++];
                }
            } else if (rightIndex >= right.length) {
                for (int i = leftIndex; i < left.length; i++) {
                    combined[combinedIndex++] = left[leftIndex++];
                }
            } else if (left[leftIndex] < right[rightIndex]) {
                combined[combinedIndex++] = left[leftIndex++];
            } else {
                combined[combinedIndex++] = right[rightIndex++];
            }
        }

        return combined;
    }

    private class SplitArray {
        private int[] left;
        private int[] right;

        SplitArray(int[] left, int[] right) {
            this.left = left;
            this.right = right;
        }
    }

}
