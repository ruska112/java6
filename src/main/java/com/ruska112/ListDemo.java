package com.ruska112;

import java.util.ArrayList;

public class ListDemo {
    public static ArrayList<Human> getArrayListNamesakes(ArrayList<Human> humans, Human namesake) {
        if (humans == null) {
            throw new IllegalArgumentException();
        }
        if (namesake == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<Human> result = new ArrayList<>(humans.size());
        for (Human human : humans) {
            if (human.getSurname().equals(namesake.getSurname())) {
                result.add(human);
            }
        }
        return result;
    }
}
