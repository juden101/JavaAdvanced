package com.company;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<String> result = new ArrayDeque<>();
        Collections.addAll(result,tokens);

        while (result.size() > 1) {
            int firstNumber = Integer.valueOf(result.pop());
            String operation = result.pop();
            int secondNumber = Integer.valueOf(result.pop());

            if (operation.equals("+")){
                result.push(String.valueOf(firstNumber + secondNumber));
            }else {
                result.push(String.valueOf(firstNumber - secondNumber));
            }
        }

        System.out.println(result.pop());



    }
}
