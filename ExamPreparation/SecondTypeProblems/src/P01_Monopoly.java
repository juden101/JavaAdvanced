import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P01_Monopoly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        List<List<String>> gamePlan = new ArrayList<>();

        for (int i = 0; i < dimensions[0]; i++) {
            String line = scanner.nextLine();
            gamePlan.add(new ArrayList<>() {{
                add(line);
            }});
        }

        int rounds = dimensions[0] * dimensions[1];
        int money = 50;
        int turns = 0;
        int counter = 0;
        int row = 0;
        int col = 0;
        int hotelCounter = 0;

        while (rounds-- > 0) {


            char symbol = gamePlan.get(row).get(0).charAt(col);

            switch (symbol) {
                case 'H':
                    hotelCounter++;
                    System.out.printf("Bought a hotel for %d. Total hotels: %d.\n", money, hotelCounter);
                    money = 0;
                    money += hotelCounter * 10;
                    break;
                case 'S':
                    int toPay = (row + 1) * (col + 1);

                    if (toPay >= money) {
                        System.out.printf("Spent %d money at the shop.\n", money);
                        money = 0;
                    } else {
                        money -= toPay;
                        System.out.printf("Spent %d money at the shop.\n", toPay);
                    }

                    money += hotelCounter * 10;
                    break;
                case 'J':
                    System.out.printf("Gone to jail at turn %d.\n", turns);
                    turns += 2;
                    money += hotelCounter * 10 * 3;
                    break;
                case 'F':
                    money += hotelCounter * 10;
                    break;
            }

            if (counter == dimensions[1] - 1) {
                row++;
                if (row % 2 == 1) {
                    col++;
                } else {
                    col = -1;
                }
                counter = -1;
            }

            if (row % 2 == 0) {
                col++;
            } else {
                col--;
            }

            counter++;
            turns++;
        }

        System.out.println("Turns " + turns);
        System.out.println("Money " + money);
    }

}
