package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class P05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];


        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col];
            }
        }

        String tokens = scanner.nextLine();
        while (!tokens.equals("END")) {
            String[] line = tokens.split(" ");

            if (line.length != 5) {
                System.out.println("Invalid input!");
                tokens = scanner.nextLine();
                continue;
            }

            int r1 = Integer.parseInt(line[1]);
            int c1 = Integer.parseInt(line[2]);
            int r2 = Integer.parseInt(line[3]);
            int c2 = Integer.parseInt(line[4]);

            if (!line[0].equals("swap") || r1 >= rows || r2 >= rows || c1 >= cols || c2 >= cols) {
                System.out.println("Invalid input!");
                tokens = scanner.nextLine();
                continue;
            }

            String firstString = matrix[r1][c1];
            String secondString = matrix[r2][c2];
            matrix[r1][c1] = secondString;
            matrix[r2][c2] = firstString;

            printMatrix(matrix);

            tokens = scanner.nextLine();
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
