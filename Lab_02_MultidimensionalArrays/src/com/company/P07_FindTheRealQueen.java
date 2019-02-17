package com.company;

import java.util.Scanner;

public class P07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] queenMatrix = new int[8][8];

        for (int row = 0; row < 8; row++) {
            String[] chars = scanner.nextLine().split(" ");
            for (int col = 0; col < 8; col++) {
                queenMatrix[row][col] = chars[col].charAt(0);
            }
        }

        int countQ = 0;
        int n = 0;
        int m = 0;
        int colIndex = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (queenMatrix[i][j] == 'q') {
                    countQ++;
                    m = j;
                }
                if (countQ > 1) {
                    break;
                }
            }
            if (countQ == 1) {
                n = i;
                colIndex = m;
            }
            countQ = 0;
        }
        System.out.println(n + " " + colIndex);

    }
}
