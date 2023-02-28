package com.ruska112;

import java.lang.reflect.Array;
import java.util.*;

public class CollectionsDemo {
    public static int getCountStringsStartingWith(ArrayList<String> strings, char c) {
        if (strings == null) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        for (String str : strings) {
            if (!"".equals(str) && str.startsWith(String.valueOf(c))) {
                result++;
            }
        }
        return result;
    }

    public static ArrayList<Human> getNamesakesArrayList(ArrayList<Human> humans, Human namesake) {
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

    public static ArrayList<Human> deleteHumanInArrayList(ArrayList<Human> humans, Human delete) {
        if (humans == null) {
            throw new IllegalArgumentException();
        }
        if (delete == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<Human> result = new ArrayList<>(humans.size());
        for (Human human : humans) {
            if (!delete.equals(human)) {
                result.add(new Human(human.getSurname(), human.getName(), human.getFatherName(), human.getAge()));
            }
        }
        return result;
    }

    public static ArrayList<Set<Integer>> getSetsNotIntersectWith(ArrayList<Set<Integer>> setArrayList, Set<Integer> integerSet) {
        if (setArrayList == null) {
            throw new IllegalArgumentException();
        }
        if (integerSet == null) {
            throw new IllegalArgumentException();
        }
        boolean flag = true;
        ArrayList<Set<Integer>> result = new ArrayList<>(setArrayList.size());
        for (Set<Integer> set : setArrayList) {
            for (Integer num0 : integerSet) {
                for (Integer num1 : set) {
                    if (num0.equals(num1)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                result.add(set);
            }
            flag = true;
        }
        return result;
    }

    public static ArrayList<Human> getMaxAgeHumanArrayList(ArrayList<Human> humans) {
        if (humans == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<Human> result = new ArrayList<>(humans.size());
        int maxAge = 0;
        for (Human human : humans) {
            if (human.getAge() > maxAge) {
                maxAge = human.getAge();
            }
        }
        for (Human human : humans) {
            if (human.getAge() == maxAge) {
                result.add(human);
            }
        }
        return result;
    }

    public static ArrayList<Human> getSortedArrayList(Human... humans) {
        if (humans == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < humans.length; i++) {
            for (int j = 0; j < humans.length; j++) {
                if (humans[i].getSurname().compareTo(humans[j].getSurname()) < 0) {
                    Human tmp = humans[i];
                    humans[i] = humans[j];
                    humans[j] = tmp;
                }
            }
        }
        return new ArrayList<>(Arrays.stream(humans).toList());
    }

    public static Set<Human> getHumanSet(Map<Integer, Human> humanMap, Set<Integer> integerSet) {
        if (humanMap == null) {
            throw new IllegalArgumentException();
        }
        if (integerSet == null) {
            throw new IllegalArgumentException();
        }
        Set<Human> result = new HashSet<>();
        for (Integer num : integerSet) {
            if (humanMap.containsKey(num)) {
                result.add(humanMap.get(num));
            }
        }
        return result;
    }
}
