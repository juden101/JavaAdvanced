package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class P05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(numbers);
        int n = Integer.parseInt(scanner.nextLine());

        numbers.stream().filter(e -> e % n != 0).forEach(e -> System.out.print(e + " "));
    }
}
