package com.company;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, names);

        while (kids.size() != 1) {

            for (int i = 0; i < n - 1; i++) {
                String currentKid = kids.poll();
                kids.offer(currentKid);
            }

            String kid = kids.poll();
            System.out.println("Removed " + kid);
        }

        System.out.println("Last is " + kids.pop());
    }
}
