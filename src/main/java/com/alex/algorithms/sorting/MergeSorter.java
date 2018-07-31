package com.alex.algorithms.sorting;

public class MergeSorter implements DivideAndConquerSorting {

    @Override
    public int[] sort(int[] input) {
        if (input.length == 0) {
            return new int[]{};
        }

        return divideAndConquer(input);
    }

    private int[] divideAndConquer(int[] array) {
        if (array.length == 1) {
            return array;
        }

        Pair split = split(array);
        return merge(divideAndConquer(split.left), divideAndConquer(split.right));
    }

    private Pair split(int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;

        int[] left  = new int[leftSize];
        int[] right = new int[rightSize];

        int arrayIndex = 0;
        for (int i = 0; i < left.length; i++) {
            left[i] = array[arrayIndex];
            arrayIndex++;
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = array[arrayIndex];
            arrayIndex++;
        }

        return new Pair(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] combined = new int[left.length + right.length];
        int combinedIndex = 0;

        int leftIndex = 0;
        int rightIndex = 0;
        while (combinedIndex < combined.length) {
            if (leftIndex >= left.length) {
                while (rightIndex < right.length) {
                    combined[combinedIndex] = right[rightIndex];
                    rightIndex++;
                    combinedIndex++;
                }
            } else if (rightIndex >= right.length) {
                while (leftIndex < left.length) {
                    combined[combinedIndex] = left[leftIndex];
                    leftIndex++;
                    combinedIndex++;
                }
            } else if (left[leftIndex] < right[rightIndex]) {
                combined[combinedIndex] = left[leftIndex];
                leftIndex++;
                combinedIndex++;
            } else {
                combined[combinedIndex] = right[rightIndex];
                rightIndex++;
                combinedIndex++;
            }
        }

        return combined;
    }

    private class Pair {
        private int[] left;
        private int[] right;

        Pair(int[] left, int[] right) {
            this.left = left;
            this.right = right;
        }
    }

}
