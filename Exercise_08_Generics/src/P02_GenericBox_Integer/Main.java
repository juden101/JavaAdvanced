package P02_GenericBox_Integer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            int numberToPrint = Integer.parseInt(scanner.nextLine());
            System.out.print(new Box<>(numberToPrint));
        }
    }
}
