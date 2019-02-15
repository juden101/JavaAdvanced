package com.company;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P01_ReverseNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> numbers = new ArrayDeque<>();

        String[] num = scanner.nextLine().split("\\s+");
        Collections.addAll(numbers, num);

        while (!numbers.isEmpty()) {
            System.out.print(numbers.pollLast() + " ");
        }
    }
}
