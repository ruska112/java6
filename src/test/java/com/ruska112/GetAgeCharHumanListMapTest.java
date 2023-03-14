package com.ruska112;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static com.ruska112.CollectionsDemo.getAgeCharHumanListMap;
import static org.junit.Assert.*;

public class GetAgeCharHumanListMapTest {
    Set<Human> humanSet = new HashSet<>();

    ArrayList<Human> human0 = new ArrayList<>();
    ArrayList<Human> human1 = new ArrayList<>();
    ArrayList<Human> human2 = new ArrayList<>();

    Map<Character, ArrayList<Human>> humanArrayListMap0 = new HashMap<>();
    Map<Character, ArrayList<Human>> humanArrayListMap1 = new HashMap<>();
    Map<Character, ArrayList<Human>> humanArrayListMap2 = new HashMap<>();

    Map<Integer, Map<Character, ArrayList<Human>>> integerCharacterHumanListMap = new HashMap<>();

    @Before
    public void setUp() {
        humanSet.add(new Human("1", "1", "1", 1));
        humanSet.add(new Student("2", "2", "2", 2, "2"));
        humanSet.add(new Human("3", "3", "3", 3));
        humanSet.add(new Student("1", "1", "1", 1, "1"));
        humanSet.add(new Student("22", "22", "22", 2, "22"));
        humanSet.add(new Human("11", "11", "11", 1));

        human0.add(new Human("1", "1", "1", 1));
        human0.add(new Student("1", "1", "1", 1, "1"));
        human0.add(new Human("11", "11", "11", 1));

        human1.add(new Student("2", "2", "2", 2, "2"));
        human1.add(new Student("22", "22", "22", 2, "22"));

        human2.add(new Human("3", "3", "3", 3));

        humanArrayListMap0.put('1', human0);
        humanArrayListMap1.put('2', human1);
        humanArrayListMap2.put('3', human2);

        integerCharacterHumanListMap.put(3, humanArrayListMap2);
        integerCharacterHumanListMap.put(2, humanArrayListMap1);
        integerCharacterHumanListMap.put(1, humanArrayListMap0);
    }

    @Test
    public void getAgeCharHumanListMapTest() {
        assertEquals(integerCharacterHumanListMap, getAgeCharHumanListMap(humanSet));
    }
}
