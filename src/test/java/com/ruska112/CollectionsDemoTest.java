package com.ruska112;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

import static com.ruska112.CollectionsDemo.getCountStringsStartingWith;

public class CollectionsDemoTest {

    ArrayList<String> strings;

    @Before
    public void setUp() throws Exception {
        strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("bbc");
        strings.add("aba");
        strings.add("bab");
    }

    @Test
    public void testGetCountStringsStartingWith0() {
        assertEquals(2, getCountStringsStartingWith(strings, 'a'));
    }

    @Test
    public void testGetCountStringsStartingWith1() {
        assertEquals(2, getCountStringsStartingWith(strings, 'b'));
    }

    @Test
    public void testGetCountStringsStartingWith2() {
        assertEquals(0, getCountStringsStartingWith(strings, 'c'));
    }
    @Test
    public void testGetCountStringsStartingWith3() {
        ArrayList<String> emptyStrings = new ArrayList<>();
        assertEquals(0, getCountStringsStartingWith(emptyStrings, 'c'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCountStringsStartingWith() {
        ArrayList<String> emptyArr = null;
        getCountStringsStartingWith(emptyArr, 'a');
    }
}