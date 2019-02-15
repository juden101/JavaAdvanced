package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] operations = scanner.nextLine().split("\\s+");
        int popElements = Integer.parseInt(operations[1]);
        int toCheck = Integer.parseInt(operations[2]);
        int minimum = Integer.MAX_VALUE;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        while (popElements != 0) {
            stack.pop();
            popElements--;
        }

        if (stack.contains(toCheck)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {

            while (!stack.isEmpty()) {
                int number = stack.pop();

                if (number < minimum) {
                    minimum = number;
                }

            }

            System.out.println(minimum);
        }
    }
}
