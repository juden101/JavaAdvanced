import java.util.Scanner;

public class P03_Sneaking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[sizeOfMatrix][];
        int rowSam = 0;
        int rowNiko = 0;
        int colSam = 0;
        int colNiko = 0;

        for (int i = 0; i < sizeOfMatrix; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("S")) {
                rowSam = i;
                colSam = line.indexOf("S");
            } else if (line.contains("N")) {
                rowNiko = i;
                colNiko = line.indexOf("N");
            }
        }

        String data = scanner.nextLine();

        for (int i = 0; i < data.length(); i++) {
            char cmd = data.charAt(i);

            moveEnemies(sizeOfMatrix, matrix);

            if (isDead(rowSam, colSam, matrix)) {
                matrix[rowSam][colSam] = 'X';
                System.out.printf("Sam died at %d, %d\n", rowSam, colSam);
                printMatrix(matrix);
                return;
            }

            moveSam(rowSam, colSam, matrix, cmd);

            if (rowSam == rowNiko) {
                matrix[rowNiko][colNiko] = 'X';
                System.out.println("Nikoladze killed!");
                printMatrix(matrix);
                return;
            }
        }
    }

    private static void moveEnemies(int sizeOfMatrix, char[][] matrix) {
        for (int j = 0; j < sizeOfMatrix; j++) {
            for (int k = 0; k < matrix[j].length; k++) {

                if (matrix[j][k] == 'b') {
                    if (k < matrix[j].length - 1) {
                        matrix[j][k] = '.';
                        matrix[j][k + 1] = 'b';
                    } else {
                        matrix[j][k] = 'd';
                    }
                    break;
                } else if (matrix[j][k] == 'd') {
                    if (k > 0) {
                        matrix[j][k] = '.';
                        matrix[j][k - 1] = 'd';
                    } else {
                        matrix[j][k] = 'b';
                    }
                    break;
                }
            }
        }
    }

    private static void moveSam(int rowSam, int colSam, char[][] matrix, char direction) {

        switch (direction) {
            case 'U':
                matrix[rowSam][colSam] = '.';
                matrix[rowSam - 1][colSam] = 'S';
                rowSam--;
                break;
            case 'D':
                matrix[rowSam][colSam] = '.';
                matrix[rowSam + 1][colSam] = 'S';
                rowSam++;
                break;
            case 'L':
                matrix[rowSam][colSam] = '.';
                matrix[rowSam][colSam - 1] = 'S';
                colSam--;
                break;
            case 'R':
                matrix[rowSam][colSam] = '.';
                matrix[rowSam][colSam + 1] = 'S';
                colSam++;
                break;
            case 'W':
                break;
        }
    }

    public static boolean isDead(int rowS, int colS, char[][] matrix) {
        boolean dead = false;
        for (int i = 0; i < colS; i++) {
            if (matrix[rowS][i] == 'b') {
                dead = true;
            }
        }
        for (int i = colS + 1; i < matrix[rowS].length; i++) {
            if (matrix[rowS][i] == 'd') {
                dead = true;
            }
        }
        return dead;
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
