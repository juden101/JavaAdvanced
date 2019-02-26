package com.company;

import java.util.Scanner;
import java.util.function.Predicate;

public class P06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split(" ");

        Predicate<String> nameCheck = name -> name.length() <= number;

        for (String name : names) {
            if (nameCheck.test(name)) {
                System.out.println(name);
            }
        }

    }
}
