package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07_FindTheSmallestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        Function<ArrayList<Integer>, Integer> findIndexOfMin = arr ->
                arr.lastIndexOf(arr.stream().min(Integer::compareTo).get());

        System.out.println(findIndexOfMin.apply(numbers));

    }
}
