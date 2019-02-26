package com.company;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class P04_AppliedArithmetic {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> add = arr -> Arrays.stream(arr).map(e -> ++e).toArray();
        UnaryOperator<int[]> sub = arr -> Arrays.stream(arr).map(e -> --e).toArray();
        UnaryOperator<int[]> multiply = arr -> Arrays.stream(arr).map(e -> e *= 2).toArray();
        Consumer<int[]> printer =
                arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));


        String cmd = scanner.nextLine();

        while (!cmd.equals("end")) {

            switch (cmd) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "subtract":
                    numbers = sub.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
            }

            cmd = scanner.nextLine();
        }
    }


}

