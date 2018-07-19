package com.alex.structures.stack;

public class Main {

    public static void main(String[] args) {
//        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
//
//        linkedListStack.push(3);
//        linkedListStack.push(2);
//        linkedListStack.push(1);
//
//        Integer peek = linkedListStack.peek();
//        System.out.println(peek);
//
//        linkedListStack.printStack();

        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.pop();

        arrayStack.printStack();
    }

}
