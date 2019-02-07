package com.company;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P07_MathPotato {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> players = new ArrayDeque<>();
        Collections.addAll(players, names);

        int cycle = 1;
        while (players.size() != 1) {
            for (int i = 0; i < n - 1; i++) {
                String currentKid = players.poll();
                players.offer(currentKid);
            }

            if (isPrime(cycle) == true && cycle > 1) {
                String kid = players.peek();
                System.out.println("Prime " + kid);
            } else {
                String kid = players.poll();
                System.out.println("Removed " + kid);
            }

            cycle++;
        }

        System.out.println("Last is " + players.pop());
    }

    static boolean isPrime(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
            if (count > 2) {
                break;
            }
        }

        if (count > 2) {
            return false;
        } else {
            return true;
        }
    }
}
