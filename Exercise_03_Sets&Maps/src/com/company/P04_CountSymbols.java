package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class P04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Character, Integer> countSymbols = new TreeMap<>();

        String line = scanner.nextLine();

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            countSymbols.putIfAbsent(symbol, 0);
            countSymbols.put(symbol, countSymbols.get(symbol) + 1);
        }

        for (Character c : countSymbols.keySet()) {
            System.out.printf("%c: %d time/s\n", c, countSymbols.get(c));
        }
    }
}
