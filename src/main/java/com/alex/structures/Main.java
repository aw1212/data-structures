package com.alex.structures;

import com.alex.structures.list.DoubleLinkedList;

public class Main {

    public static void main(String[] args) {

        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.addToBeginning(1);
        doubleLinkedList.addToBeginning(2);
        doubleLinkedList.addToBeginning(3);

        for (Integer integer : doubleLinkedList) {
            System.out.println(integer);
        }

    }

}
