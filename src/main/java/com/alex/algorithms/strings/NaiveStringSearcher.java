package com.alex.algorithms.strings;

public class NaiveStringSearcher {

    public int searchString(String fullstring, String substringToFind) {
        int matchOffset = -1;
        int mainIndex = 0;

        while (mainIndex < fullstring.length()) {
            int matchCount = 0;
            int substringIndex = 0;
            int mirrorIndex = mainIndex;
            while (mirrorIndex < fullstring.length() && fullstring.charAt(mirrorIndex) == substringToFind.charAt(substringIndex)) {
                mirrorIndex++; substringIndex++; matchCount++;
                if (matchOffset == -1) {
                    matchOffset = mainIndex;
                }
                if (matchCount == substringToFind.length()) {
                    return matchOffset;
                }
            }
            matchOffset = -1;
            mainIndex++;
        }

        return matchOffset;
    }

}
