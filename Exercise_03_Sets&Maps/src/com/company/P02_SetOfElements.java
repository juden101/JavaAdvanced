package com.company;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class P02_SetOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        String[] sizes = scanner.nextLine().split(" ");
        int n = Integer.parseInt(sizes[0]);
        int m = Integer.parseInt(sizes[1]);

        while (n-- > 0) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        while (m-- > 0) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
