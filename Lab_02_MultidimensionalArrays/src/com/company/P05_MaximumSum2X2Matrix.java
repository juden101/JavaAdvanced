package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class P05_MaximumSum2X2Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] data = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = data[j];
            }
        }

        int bestSum = Integer.MIN_VALUE;
        int n = 0, m = 0;
        int rowToPrint = 0, colToPrint = 0;

        while (n < rows - 1) {
            int sum = 0;

            for (int row = n; row < 2 + n; row++) {
                for (int col = m; col < 2 + m; col++) {
                    sum += matrix[row][col];
                }
            }

            if (sum > bestSum) {
                bestSum = sum;
                rowToPrint = n;
                colToPrint = m;
            }

            m++;

            if (m == cols - 1) {
                n++;
                m = 0;
            }
        }

        for (int row = rowToPrint; row < rowToPrint + 2; row++) {
            for (int col = colToPrint; col < colToPrint + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(bestSum);
    }
}
