package P07_CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<>();

        String line = scanner.nextLine();


        while (!line.equals("END")) {

            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Add":
                    customList.add(tokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterNumber(tokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Contains":
                    System.out.println(customList.contains(tokens[1]));
                    break;
                case "Print":
                    System.out.println(customList.toString());
                    break;
                default:
                    break;
            }

            line = scanner.nextLine();

        }


    }
}
