package com.company;

import java.util.Scanner;

public class P02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rows][cols];   //matrix with palindromes

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String element = "" + (char) ('a' + row) + (char) ('a' + row + col) + (char) ('a' + row);
                matrix[row][col] = element;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
