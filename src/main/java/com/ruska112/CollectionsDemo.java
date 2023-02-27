package com.ruska112;

import java.util.ArrayList;

public class CollectionsDemo {
    public static int countStringsStartingWith(ArrayList<String> strings, char c) {
        if (strings == null) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        for (String str : strings) {
            if (str.startsWith(String.valueOf(c))) {
                result++;
            }
        }
        return result;
    }
}
