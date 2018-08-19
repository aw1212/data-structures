package com.alex.algorithms.interview;

public class BinaryDecimalConverter {

    public int convertBinaryToDecimal(byte[] binary) {
        int result = 0;
        int startingPower = 0;
        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i] == 1) {
                result += Math.pow(2, startingPower);
            }
            startingPower++;
        }

        return result;
    }

}
