package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P09_ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<String>> parkingCells = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            parkingCells.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    parkingCells.get(i).add("n");
                } else {
                    parkingCells.get(i).add("free");
                }
            }
        }
        String line = scanner.nextLine();
        while (!line.equals("stop")) {
            String[] tokens = line.split(" ");
            int entryRow = Integer.parseInt(tokens[0]);
            int desireRow = Integer.parseInt(tokens[1]);
            int desireCol = Integer.parseInt(tokens[2]);
            int counterSteps = 0;
            int nearestPlace = Integer.MAX_VALUE;

            if (!parkingCells.get(desireRow).contains("free")) {
                System.out.printf("Row %d full\n", desireRow);
                line = scanner.nextLine();
                continue;
            }


            if (isFree(desireRow, desireCol, parkingCells)) {
                counterSteps = desireCol + 1 + Math.abs(desireRow - entryRow);
                parkingCells.get(desireRow).set(desireCol, "car");
            } else {
                for (int i = desireCol - 1; i > 0; i--) {
                    if (isFree(desireRow, i, parkingCells)) {
                        counterSteps = i + 1;
                        nearestPlace = desireCol - i;
                        break;
                    }
                }

                for (int i = desireCol + 1; i < cols; i++) {
                    if (isFree(desireRow, i, parkingCells)) {
                        if (nearestPlace > i - desireCol) {
                            nearestPlace = i - desireCol;
                            counterSteps = i + 1;
                            break;
                        }
                    }
                }
                parkingCells.get(desireRow).set(counterSteps - 1, " car");
                counterSteps += Math.abs(desireRow - entryRow);

            }
            System.out.println(counterSteps);


            line = scanner.nextLine();

        }

    }


    private static boolean isFree(int row, int col, List<List<String>> list) {
        return list.get(row).get(col).equals("free");
    }

}



