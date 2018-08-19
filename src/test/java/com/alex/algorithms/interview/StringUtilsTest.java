package com.alex.algorithms.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    @Test
    public void testHasUniqueCharsWithTwoCharsOfDifferentCasing() {
        boolean unique = StringUtils.hasAllUniqueChars("Unique");

        assertTrue(unique);
    }

    @Test
    public void testHasUniqueCharsWithTwoCharsOfSameCasing() {
        boolean unique = StringUtils.hasAllUniqueChars("unique");

        assertFalse(unique);
    }

    @Test
    public void testRemoveFirstOccurrenceDupes() {
        String deduped = StringUtils.removeFirstOccurrenceDupes("banana");

        assertEquals("bna", deduped);
    }

    @Test
    public void testRemoveLastOccurrenceDupes() {
        String deduped = StringUtils.removeLastOccurrenceDupes("bananaa");

        assertEquals("ban", deduped);
    }

    @Test
    public void testAnagrams() {
        boolean anagrams = StringUtils.areAnagrams("abanan", "banana");

        assertTrue(anagrams);
    }

}