package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];


        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.println(Math.abs(calculateFirstDiagonal(matrix) - calculateSecondDiagonal(matrix)));

    }

    private static int calculateFirstDiagonal(int[][] matrix) {
        int sum = 0;
        int row = 0, col = 0;

        while (row < matrix.length) {
            sum += matrix[row++][col++];
        }

        return sum;
    }

    private static int calculateSecondDiagonal(int[][] matrix) {
        int sum = 0;
        int row = matrix.length - 1, col = 0;

        while (row >= 0) {
            sum += matrix[row--][col++];
        }

        return sum;
    }

}

