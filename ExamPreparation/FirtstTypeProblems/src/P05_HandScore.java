import java.util.Scanner;

public class P05_HandScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        int rounds = line.length;
        char previousSuit = line[0].length() > 2 ? line[0].charAt(2) : line[0].charAt(1);
        char suit;

        int counter = 0;
        int sum = 0;
        int counterSum = 0;
        int i = 0;
        while (rounds-- > 0) {
            char face = line[i].charAt(0);

            suit = line[i].length() > 2 ? line[i].charAt(2) : line[i].charAt(1);

            if (suit == previousSuit) {
                counterSum += cardFace(face);
                counter++;
            } else {
                sum += counterSum * counter;
                counter = 0;
                counterSum = 0;

                if (i + 1 < line.length && suit == line[i + 1].charAt(1)) {
                    counter++;
                    counterSum += cardFace(face);
                } else {
                    sum += cardFace(face);
                }
            }

            previousSuit = suit;
            i++;
        }

        if (counter > 0) {
            sum += counterSum * counter;
        }

        System.out.println(sum);
    }

    public static int cardFace(char symbol) {
        int size = 0;
        if (symbol == '1') {
            size = 10;
        } else if (symbol == '2') {
            size = 2;
        } else if (symbol == '3') {
            size = 3;
        } else if (symbol == '4') {
            size = 4;
        } else if (symbol == '5') {
            size = 5;
        } else if (symbol == '6') {
            size = 6;
        } else if (symbol == '7') {
            size = 7;
        } else if (symbol == '8') {
            size = 8;
        } else if (symbol == '9') {
            size = 9;
        } else if (symbol == 'J') {
            size = 12;
        } else if (symbol == 'Q') {
            size = 13;
        } else if (symbol == 'K') {
            size = 14;
        } else if (symbol == 'A') {
            size = 15;
        }

        return size;
    }
}
