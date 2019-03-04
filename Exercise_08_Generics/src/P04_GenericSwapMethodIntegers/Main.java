package P04_GenericSwapMethodIntegers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> integerBox = new Box<>();

        while (n-- > 0) {
            integerBox.getCollection().add(Integer.parseInt(scanner.nextLine()));
        }
        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Box.swapper(integerBox.getCollection(), indexes[0], indexes[1]);
        System.out.print(integerBox.toString());
    }
}
