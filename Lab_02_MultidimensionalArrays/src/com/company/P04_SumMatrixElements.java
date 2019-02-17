package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizes = scanner.nextLine().split(",\\s+");

        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);
        int[][] matrix = new int[rows][];

        fillingMatrix(scanner, rows, matrix);
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }

        }

        System.out.printf("%d\n%d\n%d", rows, cols, sum);
    }

    private static void fillingMatrix(Scanner scanner, int row, int[][] matrix) {
        for (int i = 0; i < row; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }
    }
}
