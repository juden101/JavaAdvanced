package com.company;

import java.util.Scanner;
import java.util.TreeSet;

public class P02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> guestList = new TreeSet<>();
        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {
            guestList.add(input);
            input = scanner.nextLine();
        }

        String guest = scanner.nextLine();

        while (!guest.equals("END")) {
            guestList.remove(guest);
            guest = scanner.nextLine();
        }

        System.out.println(guestList.size());

        for (String guestID : guestList) {
            System.out.println(guestID);
        }
    }
}
