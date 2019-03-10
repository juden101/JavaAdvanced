import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02_BombField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfSquare = Integer.parseInt(scanner.nextLine());

        List<List<Character>> bombMap = new ArrayList<>();
        int bombCounter = 0;
        int rowStart = 0;
        int rowEnd = 0;
        int colStart = 0;
        int colEnd = 0;

        String[] data = scanner.nextLine().split(",");

        for (int i = 0; i < sizeOfSquare; i++) {
            String line = scanner.nextLine();
            bombMap.add(new ArrayList<>());

            for (int j = 0; j < sizeOfSquare; j++) {
                String[] symbols = line.split("\\s+");
                char toFill = symbols[j].charAt(0);
                bombMap.get(i).add(toFill);

                if (toFill == 'B') {
                    bombCounter++;
                } else if (toFill == 'e') {
                    rowEnd = i;
                    colEnd = j;
                } else if (toFill == 's') {
                    rowStart = i;
                    colStart = j;
                }
            }
        }

        for (int i = 0; i < data.length; i++) {
            switch (data[i]) {
                case "up":
                    if (rowStart > 0) {
                        rowStart--;
                    }
                    break;
                case "down":
                    if (rowStart < sizeOfSquare - 1) {
                        rowStart++;
                    }
                    break;
                case "left":
                    if (colStart > 0) {
                        colStart--;
                    }
                    break;
                case "right":
                    if (colStart < sizeOfSquare - 1) {
                        colStart++;
                    }
                    break;
            }

            if (bombCounter == 0) {
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
            if (hasFindBomb(rowStart, colStart, bombMap)) {
                bombCounter--;
                System.out.println("You found a bomb!");
            } else if (isAtEndPosition(rowStart, colStart, rowEnd, colEnd)) {
                System.out.printf("END! %d bombs left on the field", bombCounter);
                return;
            }


        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCounter, rowStart, colStart);
    }


    public static boolean isAtEndPosition(int rowS, int colS, int rowE, int colE) {
        return rowS == rowE && colE == colS;
    }

    public static boolean hasFindBomb(int rowS, int colS, List<List<Character>> bomb) {
        boolean bomba = false;
        if (bomb.get(rowS).get(colS).equals('B')) {
            bomba = true;
            bomb.get(rowS).set(colS, '+');
        }
        return bomba;
    }

}

