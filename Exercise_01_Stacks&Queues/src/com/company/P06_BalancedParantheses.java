package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06_BalancedParantheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> paranthes = new ArrayDeque<>();

        String line = scanner.nextLine();

        boolean isBalanced = true;

        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if (current == '{' || current == '[' || current == '(') {
                paranthes.push(current);
            } else {
                if (paranthes.isEmpty()){
                    isBalanced = false;
                    break;
                }
                char opening = paranthes.pop();
                if (current == '}' && opening != '{') {
                    isBalanced = false;
                    break;
                } else if (current == ']' && opening != '[') {
                    isBalanced = false;
                    break;
                } else if (current == ')' && opening != '(') {
                    isBalanced = false;
                    break;
                }
            }

        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
