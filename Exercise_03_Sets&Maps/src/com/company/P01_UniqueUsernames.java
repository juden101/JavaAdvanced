package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01_UniqueUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String user = scanner.nextLine();
            usernames.add(user);
        }

        for (String username : usernames) {
            System.out.println(username);
        }

    }
}
