package com.alex.algorithms.sorting;

public class BubbleSorter<E extends Comparable<E>> implements LinearSorting<E> {

//    public E[] sort(E[] input) {
//        for (int i = 0; i < input.length; i++) {
//            int numSwaps = 0;
//            for (int j = i + 1; j < input.length; j++) {
//                if (input[i].compareTo(input[j]) > 0) {
//                    System.out.println("swapping " + input[i] + " and " + input[j]);
//                    E temp = input[j];
//                    input[j] = input[i];
//                    input[i] = temp;
//                    numSwaps++;
//                }
//            }
//            if (numSwaps == 0) {
//                break;
//            }
//        }
//        return input;
//    }

    @Override
    public void sort(E[] input) {
        for (int i = 0; i < input.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < input.length - 1; j++) {
                if (input[j].compareTo(input[j + 1]) > 0) {
                    E temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

}
