package com.company;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        for (int i = 1; i <= n; i++) {
            getDivisibleNumbers(i, numbers)
                    .stream()
                    .forEach(e -> System.out.print(e + " "));
        }
    }

    private static List<Integer> getDivisibleNumbers(int n, ArrayList<Integer> dividers) {
        List<Integer> numbersToPrint = new LinkedList<>();
        boolean isDivisible = true;

        for (Integer num : dividers) {

            Predicate<Integer> predicate = x -> x % num != 0;

            if (predicate.test(n)) {
                isDivisible = false;
                break;
            }
        }

        if (isDivisible == true) {
            numbersToPrint.add(n);
        }

        return numbersToPrint;
    }


}

