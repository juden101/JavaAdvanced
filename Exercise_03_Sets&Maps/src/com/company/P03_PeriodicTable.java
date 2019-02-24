package com.company;

import java.util.Scanner;
import java.util.TreeSet;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();

        while (n-- > 0) {
            String[] chemicalElements = scanner.nextLine().split(" ");

            for (int i = 0; i < chemicalElements.length; i++) {
                elements.add(chemicalElements[i]);
            }
        }

        elements.forEach(e -> System.out.print(e + " "));
    }
}
