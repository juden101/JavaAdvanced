package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String cmd = scanner.nextLine();

        while (!cmd.equals("Party!")) {
            String[] operations = cmd.split(" ");

            switch (operations[1]) {
                case "StartsWith":
                    forEachName(operations[0], names, str -> str.startsWith(operations[2]));
                    break;
                case "EndsWith":
                    forEachName(operations[0], names, str -> str.endsWith(operations[2]));
                    break;
                case "Length":
                    forEachName(operations[0], names, str -> str.length() == Integer.parseInt(operations[2]));
                    break;
            }

            cmd = scanner.nextLine();

        }

        if (names.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            String message = String.join(", ", names);
            System.out.print(message + " are going to the party!");
        }


    }

    private static void forEachName(String command, List<String> comming, Function<String, Boolean> condition) {
        for (int i = comming.size() - 1; i >= 0; i--) {

            if (condition.apply(comming.get(i))) {

                switch (command) {
                    case "Remove":
                        comming.remove(i);
                        break;
                    case "Double":
                        comming.add(comming.get(i));
                        break;
                    default:
                        break;
                }

            }
        }
    }
}

