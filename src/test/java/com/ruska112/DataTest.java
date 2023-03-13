package com.ruska112;

import org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertArrayEquals;

public class DataTest {

    @Test
    public void groupIteratorTest0() {
        var group = new Group(0, 1, 2, 3, 4);
        int i = 0;
        int[] groupArr = new int[4];
        int[] result = new int[]{1, 2, 3, 4};
        for (Integer num : group) {
            groupArr[i] = num;
            i++;
        }
        assertArrayEquals(result, groupArr);
    }

    @Test
    public void dataIteratorTest0() {
        var data = new Data("data", new Group(0, 1, 2, 3), new Group(1), new Group(2),
                new Group(3, 4, 5, 6, 7, 8),
                new Group(4, 9, 10, 11, 12, 13, 14),
                new Group(5, 15, 16));
        int i = 0;
        int[] groupArr = new int[16];
        int[] result = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        for (Integer datum : data) {
            groupArr[i] = datum;
            i++;
        }
        assertArrayEquals(result, groupArr);
    }
}
