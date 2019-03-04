package P03_GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        while (n-- > 0) {
            String line = scanner.nextLine();
            box.getCollection().add(line);
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Box.swapper(box.getCollection(), indexes[0], indexes[1]);
        System.out.print(box.toString());
    }
}
