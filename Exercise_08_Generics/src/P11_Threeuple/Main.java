package P11_Threeuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Threeuple> threeuples = new ArrayList<>();
        String[] personInfo = scanner.nextLine().split("\\s+");
        threeuples.add(new Threeuple<>(personInfo[0] + " " + personInfo[1], personInfo[2], personInfo[3]));
        String[] line = scanner.nextLine().split("\\s+");
        threeuples.add(new Threeuple(line[0], Integer.parseInt(line[1]), Boolean.parseBoolean(line[2].equals("drunk") ? "true" : "false")));
        line = scanner.nextLine().split("\\s+");
        threeuples.add(new Threeuple(line[0], Double.parseDouble(line[1]), line[2]));

        threeuples.forEach(System.out::println);

    }
}
