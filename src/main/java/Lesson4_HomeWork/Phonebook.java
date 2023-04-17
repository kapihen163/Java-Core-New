package Lesson4_HomeWork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phonebook {
    private Map<String, HashSet<String>> map;

    @Override
    public String toString() {
        return "Phonebook{" +
                "map=" + map +
                '}';
    }

    Phonebook() {
        this.map = new HashMap<>();
    }

    void add(String lastName, String phone) {
        HashSet<String> numbers;

        if (map.containsKey(lastName)) {
            numbers = map.get(lastName);
        } else {
            numbers = new HashSet<>();
        }
        numbers.add(phone);
        map.put(lastName, numbers);

    }

    Set<String> get(String lastName) {
        return map.get(lastName);
    }
}
