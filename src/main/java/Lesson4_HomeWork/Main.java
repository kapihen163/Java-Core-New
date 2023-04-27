package Lesson4_HomeWork;

import java.util.*;

//        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список
//        уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое
//        слово.
//        2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
//        В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать
//        номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
//        (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

public class Main {
    public static void main(String[] args) {
        String[] uniqueWords = {"dog", "cat", "pet", "lock", "mock", "lock", "fork", "mock", "golf", "lock", "Ivanov"};

        //  1.a.
        Set<String> uniqe = new HashSet<>(Arrays.asList(uniqueWords));
        System.out.println(uniqe);
        System.out.println(" ");

        //  1.b.
        Map<String, Integer> map = new HashMap<>();
        for (String word : uniqueWords) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
        System.out.println(" ");



        //  2
        Phonebook pb = new Phonebook();

        pb.add("Ivanov", "123");
        pb.add("Petrov", "456");
        pb.add("Sidorov", "789");

        System.out.println(pb.get("Petrov"));
        System.out.println(pb.get("Sidorov"));
    }
}
