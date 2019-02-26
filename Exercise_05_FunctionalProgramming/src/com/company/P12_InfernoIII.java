package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class P12_InfernoIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Integer> powers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> oldPower = new LinkedList<>(powers);


        String line = scanner.nextLine();
        while (!line.equals("Forge")) {
            String[] cmd = line.split(";");

            if (cmd[0].equals("Exclude")) {
                powers.removeIf(num ->
                        num + validIndex(powers, powers.indexOf(num), cmd[1]) == Integer.parseInt(cmd[2]));
            } else {
                powers.clear();
                powers.addAll(oldPower);
            }

            line = scanner.nextLine();
        }

        for (Integer power : powers) {
            System.out.print(power + " ");
        }

    }


    private static int validIndex(LinkedList<Integer> nums, int n, String cmd) {
        boolean validIndex = true;
        int result = 0;

        if (n - 1 < 0 || n + 1 >= nums.size()) {
            validIndex = false;
        }


        switch (cmd) {
            case "Sum Left":
                if (validIndex) {
                    result = nums.get(n - 1);
                }
                break;
            case "Sum Right":
                if (validIndex) {
                    result = nums.get(n + 1);
                }
                break;
            case "Sum Left Right":

                if (validIndex) {
                    result = nums.get(n - 1) + nums.get(n + 1);
                } else if (n - 1 >= 0 && n + 1 >= nums.size()) {
                    result = nums.get(n - 1);
                } else if (n - 1 < 0 && n + 1 < nums.size()) {
                    result = nums.get(n + 1);
                }
                break;
        }

        return result;
    }
}
