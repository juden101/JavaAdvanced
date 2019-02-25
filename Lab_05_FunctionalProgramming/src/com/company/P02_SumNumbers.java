package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringNumber = scanner.nextLine().split(", ");

        int sumNumbers = Arrays.stream(stringNumber).mapToInt(Integer::parseInt).sum();
        //Second method for sum the numbers - reduce(0,(a,b) -> a +b)
        System.out.printf("Count = %d\n", stringNumber.length);
        System.out.printf("Sum = %d", sumNumbers);
    }
}
