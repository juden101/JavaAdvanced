package com.company;

import java.util.Scanner;

public class P01_FillTheMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] info = scanner.nextLine().split(",\\s+");
        int sizeMatrix = Integer.parseInt(info[0]);
        String pattern = info[1];

        int[][] matrix = new int[sizeMatrix][sizeMatrix];

        if (pattern.equals("A")) {
            fillMatrixTypeА(sizeMatrix, matrix);
        } else {
            fillMatrixTypeB(sizeMatrix, matrix);
        }

        printMatrix(matrix);
    }


    private static void fillMatrixTypeА(int sizeMatrix, int[][] matrix) {

        for (int i = 0; i < sizeMatrix; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i + 1) + count;
                count += sizeMatrix;
            }
        }
    }

    private static void fillMatrixTypeB(int sizeMatrix, int[][] matrix) {
        int currentNumber = 1;
        for (int col = 0; col < sizeMatrix; col++) {

            if (col % 2 == 0) {

                for (int row = 0; row < sizeMatrix; row++) {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }

            } else {

                for (int row = sizeMatrix - 1; row >= 0; row--) {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }

            }
        }
    }

    private static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }

    }
}
