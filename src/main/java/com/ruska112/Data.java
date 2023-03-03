package com.ruska112;

import java.util.Arrays;
import java.util.Objects;

public class Data {
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
}
