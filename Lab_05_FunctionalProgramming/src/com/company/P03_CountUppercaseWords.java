package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringWords = scanner.nextLine().split(" ");

        Predicate<String> isUppercaseWord = word -> Character.isUpperCase(word.charAt(0));

        List<String> capitalWords = Arrays.stream(stringWords).filter(isUppercaseWord)
                .collect(Collectors.toList());

        System.out.println(capitalWords.size());
        capitalWords.forEach(System.out::println);


    }
}
