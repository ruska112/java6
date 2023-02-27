package com.ruska112;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

import static com.ruska112.ListDemo.getArrayListNamesakes;

public class ListDemoTest {

    ArrayList<Human> humans;
    ArrayList<Human> namesakes0;
    ArrayList<Human> namesakes1;
    Human namesake0;
    Human namesake1;

    @Before
    public void setUp() throws Exception {
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
    }

    @Test
    public void getArrayListNamesakesTest0() {
        assertArrayEquals(namesakes0.toArray(), getArrayListNamesakes(humans, namesake0).toArray());
    }

    @Test
    public void getArrayListNamesakesTest1() {
        assertArrayEquals(namesakes1.toArray(), getArrayListNamesakes(humans, namesake1).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getArrayListNamesakesTest2() {
        ArrayList<Human> emptyHumans = null;
        getArrayListNamesakes(null, new Human("1", "1", "1", 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getArrayListNamesakesTest3() {
        Human emptyHuman = null;
        getArrayListNamesakes(humans, emptyHuman);
    }
}