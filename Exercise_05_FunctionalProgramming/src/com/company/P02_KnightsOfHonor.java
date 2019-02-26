package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printKnights = knight -> System.out.printf("Sir %s\n",knight);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(printKnights);
    }
}
