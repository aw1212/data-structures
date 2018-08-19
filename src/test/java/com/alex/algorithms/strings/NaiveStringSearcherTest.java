package com.alex.algorithms.strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NaiveStringSearcherTest {

    private NaiveStringSearcher naiveStringSearcher;

    @Before
    public void init() {
        naiveStringSearcher = new NaiveStringSearcher();
    }

    @Test
    public void testSearchString() {
        int index = naiveStringSearcher.searchString("aaaaaaab", "aab");

        assertEquals(5, index);
    }

    @Test
    public void testSearchString2() {
        int index = naiveStringSearcher.searchString("Giant taco potato meep", "taco");

        assertEquals(6, index);
    }

    @Test
    public void testSearchString3() {
        int index = naiveStringSearcher.searchString("aaaaaaaa", "aab");

        assertEquals(-1, index);
    }

}