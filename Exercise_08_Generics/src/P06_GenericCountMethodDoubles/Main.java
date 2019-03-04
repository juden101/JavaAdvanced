package P06_GenericCountMethodDoubles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> box = new Box<>();

        while (n-- > 0) {
            double input = Double.parseDouble(scanner.nextLine());
            box.getCollection().add(input);
        }

        double toCompare = Double.parseDouble(scanner.nextLine());
        int counter = Box.counter(box.getCollection(), toCompare);

        System.out.println(counter);
    }
}

