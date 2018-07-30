package com.alex.algorithms.sorting;

public class InsertionSorter<E extends Comparable<E>> implements Sorting<E> {

//    @Override
//    public E[] sort(E[] input) {
//        for (int i = 1; i < input.length; i++) {
//            for (int j = 0; j < i; j++) {
//                // if j is bigger than i
//                if (input[j].compareTo(input[i]) > 0) {
//                    E temp = input[j];
//                    input[j] = input[i];
//                    input[i] = temp;
//                }
//            }
//        }
//
//        return input;
//    }

    @Override
    public void sort(E[] input) {
        for (int i = 1; i < input.length; i++) {
            E value = input[i];
            int j = i;
            while (j > 0 && (input[j - 1].compareTo(value) > 0)) {
                input[j] = input[j - 1];
                j--;
            }
            input[j] = value;
        }
    }

}
