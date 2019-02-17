package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class P04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(dimension[0]);
        int m = Integer.parseInt(dimension[1]);

        int[][] matrix = new int[n][m];

        for (int row = 0; row < n; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int maxRow = n - 2;
        int maxCol = m - 2;
        int rowToStart = 0;
        int colToStart = 0;
        int bestSum = Integer.MIN_VALUE;
        int rowNum = 0;


        while (maxRow-- > 0) {
            int colNum = 0;

            while (colNum != maxCol) {
                int sum = 0;

                for (int i = 0 + rowNum; i <= 2 + rowNum; i++) {
                    for (int j = 0 + colNum; j < 3 + colNum; j++) {
                        sum += matrix[i][j];
                    }
                }

                if (sum > bestSum) {
                    bestSum = sum;
                    rowToStart = rowNum;
                    colToStart = colNum;
                }

                colNum++;
            }
            rowNum++;
        }

        System.out.println("Sum = " + bestSum);  //Print the maximal Sum of the 3X3 Matrix

        //Print the 3x3 Matrix
        for (int i = rowToStart; i < rowToStart + 3; i++) {
            for (int j = colToStart; j < colToStart + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
