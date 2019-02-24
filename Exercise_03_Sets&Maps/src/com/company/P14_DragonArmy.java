package com.company;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class P14_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, List<Integer>>> dragonArmy = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            int health = 250;
            int damage = 45;
            int armor = 10;
            String[] input = scanner.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            if (input[2] != null) {
                damage = Integer.parseInt(input[2]);
            }
            if (input[3] != null) {
                health = Integer.parseInt(input[3]);
            }
            if (input[4] != null) {
                armor = Integer.parseInt(input[4]);
            }

        }
    }
}
