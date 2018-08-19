package com.alex.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreHorspoolStringSearcher {

    Map<Character, Integer> distances;

    public BoyerMooreHorspoolStringSearcher() {
        distances = new HashMap<>();
    }

    public void populateBadMatchTable(String pattern) {
        int defaultValue = pattern.length();
        distances.put('?', defaultValue);

        for (int i = 0; i< pattern.length(); i++) {
            distances.put(pattern.charAt(i), pattern.length() - i - 1);
        }
    }

}
