package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class P08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));


        Comparator<Integer> compareFirstEvenThenOdd = (e1, e2) -> {

            if (e1 % 2 == 0 && e2 % 2 != 0) {
                return -1;
            } else if (e1 % 2 != 0 && e2 % 2 == 0) {
                return 1;
            }

            return Integer.compare(e1, e2);
        };

        numbers.stream().sorted(compareFirstEvenThenOdd)
                .forEach(e -> System.out.print(e + " "));


//       SecondWay
//       filter the even numbers and print them
//        numbers.stream().filter(e -> e % 2 == 0)
//                .sorted()
//                .forEachOrdered(e -> System.out.print(e + " "));
//       filter the odd numbers and print them
//        numbers.stream().filter(e -> e % 2 != 0)
//                .sorted()
//                .forEachOrdered(e -> System.out.print(e + " "));

    }


}
