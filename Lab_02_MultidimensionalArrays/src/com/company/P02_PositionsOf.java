package com.company;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("Duplicates")

public class P02_PositionsOf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int matrixRow = dimension[0];
        int[][] matrix = new int[matrixRow][];


        for (int i = 0; i < matrixRow; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }

        int n = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (n == matrix[row][col]) {
                    System.out.printf("%d %d\n", row, col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}

