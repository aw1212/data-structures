package com.alex.algorithms.sorting;

public class SelectionSorter<E extends Comparable<E>> implements LinearSorting<E> {

    @Override
    public void sort(E[] input) {
        int index = 0;
        while (index < input.length) {

            for (int i = 0; i < input.length; i++) {
                System.out.print(input[i]);
            }
            System.out.println();

            int smallestValueIndex = index;
            for (int i = index; i < input.length; i++) {
                if (input[i].compareTo(input[smallestValueIndex]) < 0) {
                    smallestValueIndex = i;
                }
            }
            E temp = input[index];
            input[index] = input[smallestValueIndex];
            input[smallestValueIndex] = temp;
            index++;
        }
    }

}
