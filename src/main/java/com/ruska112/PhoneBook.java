package com.ruska112;

import com.sun.jdi.AbsentInformationException;

import java.util.*;

public class PhoneBook {
    private Map<Human, ArrayList<String>> map;

    public PhoneBook() {
        this.map = new HashMap<>();
    }

    public void addPhone(Human K, String V) {
        if (K == null) {
            throw new IllegalArgumentException();
        }
        if (V == null) {
            throw new IllegalArgumentException();
        }
        if (map.containsKey(K)) {
            map.get(K).add(V);
        } else {
            map.put(K, new ArrayList<>(List.of(V)));
        }
    }

    public void removePhone(Human K, String V) {
        if (K == null) {
            throw new IllegalArgumentException();
        }
        if (!map.containsKey(K)) {
            throw new IllegalArgumentException();
        } else {
            map.get(K).remove(V);
        }
    }

    public void removePhone(Human K, int V) {
        if (K == null) {
            throw new IllegalArgumentException();
        }
        if (!map.containsKey(K)) {
            throw new IllegalArgumentException();
        } else {
            map.get(K).remove(V);
        }
    }

    public ArrayList<String> getAllPhone(Human K) {
        if (K == null) {
            throw new IllegalArgumentException();
        }
        if (!map.containsKey(K)) {
            throw new IllegalArgumentException();
        } else {
            return map.get(K);
        }
    }

    public Human getHumanWithPhone(String V) {
        if (V == null) {
            throw new IllegalArgumentException();
        }
        Human result = null;
        for (Map.Entry<Human, ArrayList<String>> entry : map.entrySet()) {
            for (String phone : entry.getValue()) {
                if (V.equals(phone)) {
                    result = entry.getKey();
                    break;
                }
            }
        }
        return result;
    }

    public PhoneBook getPhoneBookStartWith(String start) {
        if (start == null) {
            throw new IllegalArgumentException();
        }
        PhoneBook result = new PhoneBook();
        for (Map.Entry<Human, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getKey().getSurname().startsWith(start)) {
                for (String phone : entry.getValue()) {
                    result.addPhone(entry.getKey(), phone);
                }
            }
        }
        return result;
    }
}
