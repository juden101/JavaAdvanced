package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> listEmails = new LinkedHashMap<>();

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("stop")) {
                break;
            }

            String email = scanner.nextLine();
            if (validEmail(email)) {
                listEmails.put(line, email);
            }
        }

        for (String name : listEmails.keySet()) {
            System.out.printf("%s -> %s\n", name, listEmails.get(name));
        }
    }

    private static boolean validEmail(String email) {
        String domain = email.split("\\.")[1];
        if (domain.equals("us") || domain.equals("com") || domain.equals("uk")) {
            return false;
        } else {
            return true;
        }
    }
}
