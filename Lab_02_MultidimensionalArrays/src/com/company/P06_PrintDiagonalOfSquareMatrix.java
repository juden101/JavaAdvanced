package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class P06_PrintDiagonalOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        int col = 0;
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(matrix[i][col++] + " ");
        }
        System.out.println();
    }
}
