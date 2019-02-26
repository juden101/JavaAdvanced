package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;

public class P03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(findMinElement.apply(numbers));
    }

    private static Function<int[], Integer> findMinElement = new Function<int[], Integer>() {
        @Override
        public Integer apply(int[] integers) {
            int minimum = Integer.MAX_VALUE;

            for (Integer integer : integers) {
                if (integer < minimum) {
                    minimum = integer;
                }
            }

            return minimum;

        }
    };
}
