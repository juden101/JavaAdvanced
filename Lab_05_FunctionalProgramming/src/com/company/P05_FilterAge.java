package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05_FilterAge {
    public static void main(String[] args) {

        BiPredicate<Map.Entry<String, Integer>, Integer> youngerThan =
                (personAge, ageLimit) -> personAge.getValue() < ageLimit;
        BiPredicate<Map.Entry<String, Integer>, Integer> olderThan =
                (personAge, ageLimit) -> personAge.getValue() >= ageLimit;

        Consumer<Map.Entry<String, Integer>> printName =
                person -> System.out.println(person.getKey());
        Consumer<Map.Entry<String, Integer>> printAge =
                person -> System.out.println(person.getValue());
        Consumer<Map.Entry<String, Integer>> printNameAge =
                person -> System.out.println(person.getKey() + " - " + person.getValue());

        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < peopleCount; i++) {
            String[] personData = scanner.nextLine().split(", ");
            people.put(personData[0], Integer.parseInt(personData[1]));
        }

        String comparision = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine();


        people.entrySet().stream()
                .filter(person -> comparision.equals("younger") ?
                        youngerThan.test(person, ageLimit) :
                        olderThan.test(person, ageLimit))
                .forEach(person -> {
            if (printType.equals("age")) {
                printAge.accept(person);
            } else if (printType.equals("name")) {
                printName.accept(person);
            } else {
                printNameAge.accept(person);
            }
        });
    }
}
