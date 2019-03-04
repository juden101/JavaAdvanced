package P10_Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Tuple> tuples = new ArrayList<>();
        String[] personInfo = scanner.nextLine().split("\\s+");
        tuples.add(new Tuple(personInfo[0] + " " + personInfo[1], personInfo[2]));
        String[] line = scanner.nextLine().split("\\s+");
        tuples.add(new Tuple(line[0], Integer.parseInt(line[1])));
        line = scanner.nextLine().split("\\s+");
        tuples.add(new Tuple(Integer.parseInt(line[0]), Double.parseDouble(line[1])));

        tuples.forEach(System.out::println);

    }
}
