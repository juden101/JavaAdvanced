package com.company;

import java.io.CharArrayReader;
import java.util.Arrays;
import java.util.Scanner;

public class P03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = new char[n][m];
        char[][] secondatrix = new char[n][m];

        fillMatrixChars(scanner, n, m, firstMatrix);
        fillMatrixChars(scanner, n, m, secondatrix);
        printIntersectionMatrix(n, m, firstMatrix, secondatrix);


    }

    private static void fillMatrixChars(Scanner scanner, int n, int m, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < m; col++) {
                matrix[row][col] = line[col].charAt(0);
            }
        }

    }

    private static void printIntersectionMatrix(int n, int m, char[][] fMatrix, char[][] sMatrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (fMatrix[row][col] == sMatrix[row][col]) {
                    System.out.print(fMatrix[row][col] + " ");
                } else {
                    System.out.print('*' + " ");
                }
            }
            System.out.println();
        }
    }
}
