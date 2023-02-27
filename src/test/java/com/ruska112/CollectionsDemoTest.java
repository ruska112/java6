package com.ruska112;

import org.junit.Before;
import org.junit.Test;

import static com.ruska112.CollectionsDemo.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CollectionsDemoTest {

    // exercise 1
    ArrayList<String> strings;

    // exercise 2
    ArrayList<Human> humans;
    ArrayList<Human> namesakes0;
    ArrayList<Human> namesakes1;
    Human namesake0;
    Human namesake1;

    // exercise 3
    Human adolf;
    ArrayList<Human> withoutAdolf;

    ArrayList<Human> humans1;
    Human tmp;
    ArrayList<Human> withoutTmp;

    // exercise 4

    Set<Integer> set;
    Set<Integer> set0;
    Set<Integer> set1;
    Set<Integer> set2;

    ArrayList<Set<Integer>> setArrayList;
    ArrayList<Set<Integer>> setArrayListWithoutSet;

    // exercise 5

    Human human0;
    Student human1;
    Human human2;
    Student human3;

    ArrayList<Human> humans2;

    ArrayList<Human> humans2maxAge;

    @Before
    public void setUp() throws Exception {
        // exercise 1
        strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("bbc");
        strings.add("aba");
        strings.add("bab");

        // exercise 2
        humans = new ArrayList<>();
        humans.add(new Human("Adolf", "Miron", "Vladimirovich", 70));
        humans.add(new Human("Mikyla", "Akyla", "Sharkovich", 5));
        humans.add(new Human("Lazy", "Ded", "Starikovich", 99999));
        humans.add(new Human("Mikyla", "GerHard", "Svyatoslavovich", 19));

        namesakes0 = new ArrayList<>();
        namesakes0.add(new Human("Mikyla", "Akyla", "Sharkovich", 5));
        namesakes0.add(new Human("Mikyla", "GerHard", "Svyatoslavovich", 19));

        namesake0 = new Human("Mikyla", "GerHard", "Svyatoslavovich", 19);

        namesakes1 = new ArrayList<>();
        namesakes1.add(new Human("Lazy", "Ded", "Starikovich", 99999));
        namesake1 = new Human("Lazy", "Bob", "Alice", 32);

        // exercise 3
        adolf = new Human("Adolf", "Miron", "Vladimirovich", 70);
        withoutAdolf = new ArrayList<>();
        withoutAdolf.add(new Human("Mikyla", "Akyla", "Sharkovich", 5));
        withoutAdolf.add(new Human("Lazy", "Ded", "Starikovich", 99999));
        withoutAdolf.add(new Human("Mikyla", "GerHard", "Svyatoslavovich", 19));

        humans1 = new ArrayList<>();
        humans1.add(new Human("1", "1", "1", 1));
        humans1.add(new Human("2", "2", "2", 2));
        humans1.add(new Human("3", "3", "3", 3));
        humans1.add(new Human("1", "1", "1", 1));
        humans1.add(new Human("5", "5", "5", 5));

        tmp = new Human("1", "1", "1", 1);

        withoutTmp = new ArrayList<>();
        withoutTmp.add(new Human("2", "2", "2", 2));
        withoutTmp.add(new Human("3", "3", "3", 3));
        withoutTmp.add(new Human("5", "5", "5", 5));

        // exercise 4

        set = new HashSet<>();
        set.add(0);
        set.add(1);

        set0 = new HashSet<>();
        set0.add(3);
        set0.add(4);
        set0.add(5);

        set1 = new HashSet<>();
        set1.add(-1);
        set1.add(4);
        set1.add(9);

        set2 = new HashSet<>();
        set2.add(0);
        set2.add(999);

        setArrayList = new ArrayList<>();
        setArrayList.add(set);
        setArrayList.add(set0);
        setArrayList.add(set1);
        setArrayList.add(set2);

        setArrayListWithoutSet = new ArrayList<>();
        setArrayListWithoutSet.add(set0);
        setArrayListWithoutSet.add(set1);

        // exercise 5
        human0 = new Human("0", "0", "0", 77);
        human1 = new Student("1", "1", "1", 19, "1");
        human2 = new Human("2", "2", "2", 20);
        human3 = new Student("3", "3", "3", 77, "3");

        humans2 = new ArrayList<>();
        humans2.add(human0);
        humans2.add(human1);
        humans2.add(human2);
        humans2.add(human3);

        humans2maxAge = new ArrayList<>();
        humans2maxAge.add(human0);
        humans2maxAge.add(human3);
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

    @Test
    public void getArrayListNamesakesTest0() {
        assertArrayEquals(namesakes0.toArray(), getNamesakesArrayList(humans, namesake0).toArray());
    }

    @Test
    public void getArrayListNamesakesTest1() {
        assertArrayEquals(namesakes1.toArray(), getNamesakesArrayList(humans, namesake1).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getArrayListNamesakesTest2() {
        ArrayList<Human> emptyHumans = null;
        getNamesakesArrayList(null, new Human("1", "1", "1", 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getArrayListNamesakesTest3() {
        Human emptyHuman = null;
        getNamesakesArrayList(humans, emptyHuman);
    }

    @Test
    public void deleteHumanInArrayListTest0() {
        assertArrayEquals(withoutAdolf.toArray(), deleteHumanInArrayList(humans, adolf).toArray());
    }

    @Test
    public void deleteHumanInArrayListTest1() {
        assertArrayEquals(withoutTmp.toArray(), deleteHumanInArrayList(humans1, tmp).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteHumanInArrayListTest2() {
        deleteHumanInArrayList(null, tmp);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteHumanInArrayListTest3() {
        deleteHumanInArrayList(humans1, null);
    }

    @Test
    public void getSetsNotIntersectWithTest0() {
        assertArrayEquals(setArrayListWithoutSet.toArray(), getSetsNotIntersectWith(setArrayList, set).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSetsNotIntersectWithTest1() {
        getSetsNotIntersectWith(null, set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSetsNotIntersectWithTest2() {
        getSetsNotIntersectWith(setArrayList, null);
    }

    @Test
    public void getMaxAgeHumanArrayListTest0(){
        assertArrayEquals(humans2maxAge.toArray(), getMaxAgeHumanArrayList(humans2).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMaxAgeHumanArrayListTest1(){
        getMaxAgeHumanArrayList(null);
    }
}