package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class P11_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeSet<String>> usersIP = new TreeMap<>();
        LinkedHashMap<String, Integer> userTime = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");

            usersIP.putIfAbsent(line[1], new TreeSet<>() {{
                add(line[0]);
            }});
            usersIP.get(line[1]).add(line[0]);

            userTime.putIfAbsent(line[1], 0);
            userTime.put(line[1], userTime.get(line[1]) + Integer.parseInt(line[2]));
        }

        usersIP.keySet().stream()
                .forEach(user ->
                        System.out.printf("%s: %d %s\n"
                                , user
                                , userTime.get(user)
                                , usersIP.get(user)));
    }
}
