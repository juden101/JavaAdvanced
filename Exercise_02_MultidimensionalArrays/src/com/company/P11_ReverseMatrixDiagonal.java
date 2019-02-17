package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class P11_ReverseMatrixDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int k = rows + cols - 2; k >= 0; k--) {
            for (int j = 0; j <= k; j++) {
                int i = k - j;
                if (i < rows && j < cols) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }


    }
}
