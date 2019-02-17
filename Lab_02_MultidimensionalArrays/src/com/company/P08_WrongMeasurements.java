package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class P08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] data = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = data;
        }

        String[] indexes = scanner.nextLine().split(" ");
        int x = Integer.parseInt(indexes[0]);
        int y = Integer.parseInt(indexes[1]);
        int wrongNumber = matrix[x][y];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongNumber) {
                    System.out.print(getSum(i, j, matrix, wrongNumber) + " ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int getSum(int row, int col, int[][] matrix, int wrongNumber) {
        int sum = 0;

        if (row - 1 >= 0 && row - 1 < matrix.length && matrix[row - 1][col] != wrongNumber) {
            sum += matrix[row - 1][col];
        }
        if (row + 1 >= 0 && row + 1 < matrix.length && matrix[row + 1][col] != wrongNumber) {
            sum += matrix[row + 1][col];
        }
        if (col - 1 >= 0 && col - 1 < matrix[row].length && matrix[row][col - 1] != wrongNumber) {
            sum += matrix[row][col - 1];
        }
        if (col + 1 >= 0 && col + 1 < matrix[row].length && matrix[row][col + 1] != wrongNumber) {
            sum += matrix[row][col + 1];
        }

        return sum;
    }


}
