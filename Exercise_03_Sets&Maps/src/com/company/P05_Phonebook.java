package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class P05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> contacts = new HashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("search")) {
            String[] contactInfo = line.split("-");
            String name = contactInfo[0], number = contactInfo[1];

            contacts.put(name, number);

            line = scanner.nextLine();
        }


        String nameToSearch = scanner.nextLine();
        while (!nameToSearch.equals("stop")) {

            if (contacts.containsKey(nameToSearch)) {
                System.out.printf("%s -> %s\n", nameToSearch, contacts.get(nameToSearch));
            } else {
                System.out.printf("Contact %s does not exist.\n", nameToSearch);
            }

            nameToSearch = scanner.nextLine();
        }
    }
}
