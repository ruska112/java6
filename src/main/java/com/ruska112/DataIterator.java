package com.ruska112;

import java.util.Iterator;

public class DataIterator implements Iterator<Integer> {
    private int currentGroupIndex;
    private Group[] groups;

    private GroupIterator groupIterator;

    public DataIterator(Data data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.groups = data.getGroups();
        this.groupIterator = new GroupIterator(this.groups[0]);
    }

    @Override
    public boolean hasNext() {
        if (!groupIterator.hasNext()) {
            if (currentGroupIndex + 1 < groups.length) {
                groupIterator = new GroupIterator(groups[++currentGroupIndex]);
                while (groups[currentGroupIndex].getSize() <= 0) {
                    groupIterator = new GroupIterator(groups[++currentGroupIndex]);
                }
            } else {
                return false;
            }
        }
        return groupIterator.hasNext();
    }

    @Override
    public Integer next() {
        return groupIterator.next();
    }
}
