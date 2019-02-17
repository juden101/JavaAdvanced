package com.company;

import java.util.Arrays;
import java.util.Scanner;
@SuppressWarnings("Duplicates")

public class P01_CompareMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstMatrixRows = dimensions[0];
        int firstMatrixCols = dimensions[1];
        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixCols];

        fillingMatrix(scanner, firstMatrixRows, firstMatrix);

        dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int secondMatrixRows = dimensions[0];
        int secondMatrixCols = dimensions[1];
        int[][] secondMatrix = new int[secondMatrixRows][secondMatrixCols];

        fillingMatrix(scanner, secondMatrixRows, secondMatrix);

        if (comparingMatrices(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static void fillingMatrix(Scanner scanner, int secondMatrixRow, int[][] secondMatrix) {
        for (int i = 0; i < secondMatrixRow; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            secondMatrix[i] = arr;
        }
    }

    private static boolean comparingMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
