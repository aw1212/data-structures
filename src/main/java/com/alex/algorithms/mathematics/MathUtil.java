package com.alex.algorithms.mathematics;

public class MathUtil {

    public static void printFibonacci() {
        for (int i = 0; i <= 10; i++) {
            System.out.print(recursiveFibonacci(i)+" ");
        }
    }

    public static int recursiveFibonacci(int n) {
        if (n < 2) {
            return 1;
        }

        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static int iterativeFibonacci(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int i = 0, j = 1, sum = 0;
        while ((n - 2) != 0) {
            sum = i + j;
            i = j;
            j = sum;
            n--;
        }
        return sum;
    }

}
