package com.ruska112;

import java.util.Iterator;

public class GroupIterator implements Iterator<Integer> {
    private int currentIndex = 0;
    private int[] data;

    public GroupIterator(Group group) {
        if (group == null) {
            throw new IllegalArgumentException();
        }
        this.data = group.getData();
    }

    @Override
    public boolean hasNext() {
        return currentIndex < data.length;
    }

    @Override
    public Integer next() {
        return data[currentIndex++];
    }
}
