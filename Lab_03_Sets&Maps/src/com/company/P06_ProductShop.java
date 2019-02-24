package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class P06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();
        String line = scanner.nextLine();

        while (!line.equals("Revision")) {
            String[] shopInformation = line.split(",\\s+");
            String name = shopInformation[0];
            String productName = shopInformation[1];
            double price = Double.parseDouble(shopInformation[2]);

            shops.putIfAbsent(name, new LinkedHashMap<>());
            shops.get(name).put(productName, price);

            line = scanner.nextLine();
        }

        for (String name : shops.keySet()) {
            System.out.println(name + "->");
            LinkedHashMap<String, Double> products = shops.get(name);

            for (String productInformation : products.keySet()) {
                System.out.printf("Product: %s, Price: %.1f\n", productInformation, products.get(productInformation));
            }
        }

    }
}
