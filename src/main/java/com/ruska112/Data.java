package com.ruska112;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Data implements Iterable<Integer> {
    private String name;
    private Group[] groups;

    public Data(String name, Group... groups) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (groups == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.groups = new Group[groups.length];
        System.arraycopy(groups, 0, this.groups, 0, groups.length);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public int getSize() {
        return groups.length;
    }

    public void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        groups = new Group[size];
    }

    public void setElement(int index, Group element) {
        if (index <= 0 || index >= getSize()) {
            throw new IllegalArgumentException();
        }
        groups[index] = element;
    }

    public Group[] getGroups() {
        return groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(name, data.name) && Arrays.equals(groups, data.groups);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(groups);
        return result;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int currentIndex;
            private int currentGroupIndex;

            @Override
            public boolean hasNext() {
                return currentGroupIndex < groups.length && currentIndex <= groups[currentGroupIndex].getData().length;
            }

            @Override
            public Integer next() {
                if (currentIndex == groups[currentGroupIndex].getData().length) {
                    currentGroupIndex++;
                    currentIndex = 0;
                }
                if (groups[currentGroupIndex].getData().length > 0) {
                    return groups[currentGroupIndex].getData()[currentIndex++];
                } else {
                    currentIndex = 0;
                    return groups[currentGroupIndex++].getData()[currentIndex];
                }
            }
        };
    }
}