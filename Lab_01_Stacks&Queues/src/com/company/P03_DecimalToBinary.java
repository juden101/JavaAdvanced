package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int decimal = Integer.parseInt(scanner.nextLine());

        if (decimal == 0) {
            System.out.println("0");
        }

        while (decimal > 0) {
            int number = decimal % 2;
            decimal /= 2;
            stack.push(number);
        }

        String binary = "";

        for (int i = stack.size(); i > 0; i--) {
            binary += String.valueOf(stack.pop());

        }

        System.out.println(binary);
    }
}
