package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> partyList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> removedPersons = new ArrayList<>(partyList);

        String line = scanner.nextLine();

        while (!line.equals("Print")) {
            String[] command = line.split(";");

            switch (command[1]) {
                case "Starts with":
                    forEachName(command[0], partyList, removedPersons, str -> str.startsWith(command[2]));
                    break;
                case "Ends with":
                    forEachName(command[0], partyList, removedPersons, str -> str.endsWith(command[2]));
                    break;
                case "Length":
                    forEachName(command[0], partyList, removedPersons, str -> str.length() == Integer.parseInt(command[2]));
                    break;
                case "Contains":
                    forEachName(command[0], partyList, removedPersons, str -> str.contains(command[2]));
                    break;
                default:
                    break;
            }

            line = scanner.nextLine();
        }

        for (String name : partyList) {
            System.out.print(name + " ");
        }

    }

    private static void forEachName(String command, List<String> comming, List<String> removed, Predicate<String> condition) {

        switch (command) {
            case "Remove filter":
                removed.stream().filter(condition).forEach(e -> comming.add(e));
                break;
            case "Add filter":
                comming.removeIf(condition);
                break;
            default:
                break;
        }
    }
}


