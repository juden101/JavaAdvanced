package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07_CrossFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<List<Integer>> mainList = new ArrayList<>();
        int rows = dimensions[0];
        int cols = dimensions[1];


        //fill the List
        int n = 1;
        for (int row = 0; row < rows; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                rowList.add(n++);
            }
            mainList.add(rowList);
        }

        String line = scanner.nextLine();

        while (!line.equals("Nuke it from orbit")) {
            String[] tokens = line.split(" ");
            int targetRow = Integer.parseInt(tokens[0]);
            int targetCol = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            //vertical line
            for (int row = Math.max(0, targetRow - radius); row <= Math.min(rows - 1, targetRow + radius); row++) {
                if (isInMatrix(row, targetCol, mainList)) {
                    mainList.get(row).set(targetCol, -1);
                }
            }

            //horizontal line
            for (int col = Math.max(0, targetCol - radius); col <= Math.min(cols - 1, targetCol + radius); col++) {
                if (isInMatrix(targetRow, col, mainList)) {
                    mainList.get(targetRow).set(col, -1);
                }
            }

            //delete the negative elements and the empty rows
            mainList.forEach(row -> row.removeIf(value -> value == -1));
            mainList.removeIf(List::isEmpty);

            line = scanner.nextLine();

        }

        // print the final elements
        for (int i = 0; i < mainList.size(); i++) {
            for (int element : mainList.get(i)) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    //Check if the indexes are valid
    private static boolean isInMatrix(Integer row, Integer col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() &&
                col >= 0 && col < matrix.get(row).size();
    }
}

