package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_SortEvenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringNumber = scanner.nextLine().split(", ");

        List<Integer> evenNumbers = Arrays.stream(stringNumber)
                .map(Integer::parseInt).filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        List<String> numbers = evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        String evenNums = String.join(", ", numbers);
        System.out.println(evenNums);

        evenNumbers.sort(Integer::compare);
        List<String> sorted = evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        String sortedNumbers = String.join(", ", sorted);
        System.out.println(sortedNumbers);
    }
}
