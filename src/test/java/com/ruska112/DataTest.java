package com.ruska112;

import org.junit.Assert.*;
import org.junit.Test;

import java.util.Iterator;

public class DataTest {
    @Test
    public void dataIteratorTest0() {
        var data = new Data("data", new Group(0, 1, 2, 3, 4));
        for (Integer datum : data) {
            System.out.println(datum);
        }
    }
}
