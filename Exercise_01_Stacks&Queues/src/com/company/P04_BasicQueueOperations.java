package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] operations = scanner.nextLine().split("\\s+");
        int popElements = Integer.parseInt(operations[1]);
        int toCheck = Integer.parseInt(operations[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);

        while (popElements-- > 0) {
            queue.pop();
        }

        if (queue.contains(toCheck)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            int min = Collections.min(queue);
            System.out.println(min);
        }
    }
}
