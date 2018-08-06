package com.alex.coursera.week1;

import com.alex.structures.stack.ArrayStack;
import com.alex.structures.stack.Stack;

public class BracketVerifier {

    private Stack<Character> brackets;

    public BracketVerifier() {
        brackets = new ArrayStack<>();
    }

    public String verifyBranckets(String input) {
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (isOpeningBracket(character)) {
                brackets.push(character);
            } else if (isClosingBracket(character)) {
                if (brackets.isEmpty()) {
                    return String.valueOf(i + 1);
                }
                char lastOpenBracket = brackets.pop();
            }
        }

        return "Success";
    }

    private boolean isOpeningBracket(char character) {
        return character == '('
                || character == '['
                || character == '{';
    }

    private boolean isClosingBracket(char character) {
        return character == ')'
                || character == ']'
                || character == '}';
    }

}
