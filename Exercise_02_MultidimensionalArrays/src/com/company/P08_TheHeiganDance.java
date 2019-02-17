package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P08_TheHeiganDance {
    private static HashMap<String, Integer> damagePositions;
    private static final int MIN_LIMIT = 0;
    private static final int MAX_LIMIT = 14;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //HP - Hit points
        int playerHP = 18500;
        int[] playerPosition = {7, 7};
        boolean isPlayerDead = false;
        String causedOfDeath = "";

        //Heigan - name of the monster
        double heiganHP = 3000000d;
        boolean isHeiganDead = false;

        //spells
        boolean cloud = false;
        int cloudHP = 3500;
        int eruptionHP = 6000;

        double damage = Double.parseDouble(scanner.nextLine());

        while (true) {
            String[] tokens = scanner.nextLine().split(" ");
            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            heiganHP -= damage;
            isHeiganDead = heiganHP <= 0;

            if (cloud) {
                playerHP -= cloudHP;
                cloud = false;
                causedOfDeath = "Plague Cloud";
                isPlayerDead = playerHP <= 0;
            }

            if (isHeiganDead || isPlayerDead) {
                break;
            }

            damageArea(row, col);
            if (isPlayerInDamageZone(playerPosition)) {
                if (playerPosition[0] > MIN_LIMIT && playerPosition[0] == damagePositions.get("minRow")) {
                    playerPosition[0]--;
                } else if (playerPosition[0] < MAX_LIMIT && playerPosition[0] == damagePositions.get("maxRow")) {
                    playerPosition[0]++;
                } else if (playerPosition[1] > MIN_LIMIT && playerPosition[1] == damagePositions.get("minCol")) {
                    playerPosition[1]--;
                } else if (playerPosition[1] < MAX_LIMIT && playerPosition[1] == damagePositions.get("maxCol")) {
                    playerPosition[1]++;
                }
            }

            if (isPlayerInDamageZone(playerPosition)) {
                if (spell.equals("Cloud")) {
                    cloud = true;
                    playerHP -= cloudHP;
                    causedOfDeath = "Plague Cloud";
                } else {
                    playerHP -= eruptionHP;
                    causedOfDeath = "Eruption";
                }
            }

            isPlayerDead = playerHP <= 0;
            if (isPlayerDead) {
                break;
            }
        }


        if (isHeiganDead) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganHP);
        }

        if (isPlayerDead) {
            System.out.println("Player: Killed by " + causedOfDeath);
        } else {
            System.out.println("Player: " + playerHP);
        }

        System.out.println("Final position: " + playerPosition[0] + ", " + playerPosition[1]);

    }

    private static boolean isPlayerInDamageZone(int[] playerPosition) {
        boolean isDamageRow = playerPosition[0] >= damagePositions.get("minRow") &&
                playerPosition[0] <= damagePositions.get("maxRow");
        boolean isDamageCol = playerPosition[1] >= damagePositions.get("minCol") &&
                playerPosition[1] <= damagePositions.get("maxCol");

        return isDamageRow && isDamageCol;
    }

    private static void damageArea(int row, int col) {
        damagePositions = new HashMap<>();
        damagePositions.put("minRow", row - 1);
        damagePositions.put("maxRow", row + 1);
        damagePositions.put("minCol", col - 1);
        damagePositions.put("maxCol", col + 1);
    }
}
