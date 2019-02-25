package com.company;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06_FindEvensOrOdds {
    public static void main(String[] args) {
        Predicate<Integer> evenNumber = integer -> integer % 2 == 0;
        Predicate<Integer> oddNumber = integer -> integer % 2 != 0;
        Scanner scanner = new Scanner(System.in);

        String[] numberBorder = scanner.nextLine().split("\\s+");
        int lowerBorder = Integer.parseInt(numberBorder[0]);
        int upperBorder = Integer.parseInt(numberBorder[1]);

        String type = scanner.nextLine().toLowerCase();

        Predicate<Integer> byType = evenNumber;

        if (type.equals("odd")) {
            byType = oddNumber;
        }

        IntStream
                .rangeClosed(lowerBorder, upperBorder)
                .boxed()
                .filter(byType)
                .forEach(element -> System.out.printf("%d ", element));

    }
}
