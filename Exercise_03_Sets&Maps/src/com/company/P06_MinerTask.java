package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P06_MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();


        while (true) {
            String recource = scanner.nextLine();

            if (recource.equals("stop")) {
                break;
            }

            int quantity = Integer.parseInt(scanner.nextLine());
            resources.putIfAbsent(recource, 0);
            resources.put(recource, resources.get(recource) + quantity);
        }

        for (String element : resources.keySet()) {
            System.out.printf("%s -> %d\n", element, resources.get(element));
        }
    }
}
