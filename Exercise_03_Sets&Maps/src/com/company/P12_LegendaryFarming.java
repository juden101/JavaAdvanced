package com.company;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class P12_LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> junk = new TreeMap<>();
        TreeMap<String, Integer> legendaryMaterials = new TreeMap<>();
        legendaryMaterials.put("shards", 0);
        legendaryMaterials.put("fragments", 0);
        legendaryMaterials.put("motes", 0);

        String obtained = "";
        boolean toContinue = true;

        while (toContinue) {
            String[] line = scanner.nextLine().split("\\s+");

            for (int i = 0; i < line.length - 1; i += 2) {
                int quantity = Integer.parseInt(line[i]);
                String item = line[i + 1].toLowerCase();

                if (item.equals("fragments") || item.equals("shards") || item.equals("motes")) {
                    legendaryMaterials.put(item, legendaryMaterials.get(item) + quantity);

                    if (legendaryMaterials.get(item) >= 250) {
                        legendaryMaterials.put(item, legendaryMaterials.get(item) - 250);
                        obtained = item;
                        toContinue = false;
                        break;
                    }

                } else {
                    junk.putIfAbsent(item, 0);
                    junk.put(item, junk.get(item) + quantity);
                }
            }

        }

        printMethod(obtained, legendaryMaterials, junk);

    }

    private static void printMethod(String item, TreeMap<String, Integer> legendary, TreeMap<String, Integer> material) {
        String toPrint = "";
        if (item.equals("shards")) {
            toPrint = "Shadowmourne";
        } else if (item.equals("motes")) {
            toPrint = "Dragonwrath";
        } else {
            toPrint = "Valanyr";
        }

        System.out.printf("%s obtained!\n", toPrint);

        legendary.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.printf("%s: %d\n"
                        , e.getKey(), e.getValue()));
        material.entrySet().stream()
                .forEach(e -> System.out.printf("%s: %d\n"
                        , e.getKey(), e.getValue()));
    }
}
