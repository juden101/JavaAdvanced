package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class P04_AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringDouble = scanner.nextLine().split(", ");

        UnaryOperator<Double> addVat = d -> d * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(stringDouble)
                .map(Double::parseDouble)
                .map(addVat).forEach(d -> System.out.printf("%.2f\n", d));

    }
}
