package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class P09_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> ipAdress = new TreeMap<>();
        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] tokens = line.split("user=");
            String userName = tokens[1];
            String ipPart = tokens[0].split(" message")[0];
            String ip = ipPart.split("IP=")[1];

            if (!ipAdress.containsKey(userName)) {
                ipAdress.put(userName, new LinkedHashMap<>() {{
                    put(ip, 1);
                }});
            } else {

                if (!ipAdress.get(userName).containsKey(ip)) {
                    ipAdress.get(userName).put(ip, 1);
                } else {
                    ipAdress.get(userName).put(ip, ipAdress.get(userName).get(ip) + 1);
                }

            }

            line = scanner.nextLine();
        }

        for (String username : ipAdress.keySet()) {
            System.out.println(username + ":");
            int size = ipAdress.get(username).keySet().size() - 1;

            for (String ip : ipAdress.get(username).keySet()) {
                int count = ipAdress.get(username).get(ip);

                if (size != 0) {
                    System.out.printf("%s => %d, ", ip, count);
                } else {
                    System.out.printf("%s => %d.\n", ip, count);
                }

                size--;
            }
        }
    }
}
