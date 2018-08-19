package com.alex.algorithms.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    private StringUtils() {
        // no impl
    }

//    Implement an algorithm to determine if a string has all unique characters. What if you
//    can not use additional data structures?
    public static boolean hasAllUniqueChars(String input) {
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            boolean isUnique = uniqueChars.add(input.charAt(i));
            if (!isUnique) {
                return false;
            }
        }
        return true;
    }

//    Design an algorithm and write code to remove the duplicate characters in a string
//    without using any additional buffer.
    public static String removeFirstOccurrenceDupes(String input) {
        if (input.length() < 2) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            boolean isUnique = true;
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                result.append(input.charAt(i));
            }
        }

        return result.toString();
    }

//    Design an algorithm and write code to remove the duplicate characters in a string
//    without using any additional buffer.
    public static String removeLastOccurrenceDupes(String input) {
        if (input.length() < 2) {
            return input;
        }

        int index = 0;

        while (index < input.length()) {
            for (int i = index + 1; i < input.length(); i++) {
                if (input.charAt(index) == input.charAt(i)) {
                    input = input.substring(0, i) + input.substring(i + 1, input.length());
                    index = 0;
                }
            }
            index++;
        }

        return input;
    }

//    Write a method to decide if two strings are anagrams or not.
    public static boolean areAnagrams(String one, String two) {
        if (one.length() != two.length()) {
            return false;
        }

        char[] arrayOne = one.toCharArray();
        char[] arrayTwo = two.toCharArray();

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        one = new String(arrayOne);
        two = new String(arrayTwo);

        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != two.charAt(i)) {
                return false;
            }
        }

        return true;
    }

}
