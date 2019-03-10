import java.util.LinkedHashMap;
import java.util.Scanner;

public class P08_SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, Long>> venueMap = new LinkedHashMap<>();

        while (!line.equals("End")) {
            if (!isValidLine(line)) {
                line = scanner.nextLine();
                continue;
            }
            String[] tokens = line.split(" @");
            String singer = tokens[0];
            String town = tokens[1].substring(0, index(tokens[1]) - 1);
            String[] numbers = tokens[1].split("\\s+");
            int price = Integer.parseInt(numbers[numbers.length - 2]);
            int count = Integer.parseInt(numbers[numbers.length - 1]);
            long money = price * count;

            if (!venueMap.containsKey(town)) {
                venueMap.put(town, new LinkedHashMap<>());
            }

            if (!venueMap.get(town).containsKey(singer)) {
                venueMap.get(town).put(singer, money);
            } else {
                venueMap.get(town).put(singer, venueMap.get(town).get(singer) + money);
            }

            line = scanner.nextLine();
        }


        for (String town : venueMap.keySet()) {
            System.out.println(town);
            venueMap.get(town).entrySet().stream().sorted((e1, e2) ->
                    e2.getValue().compareTo(e1.getValue())).forEach(e -> {
                System.out.printf("#  %s -> %d\n", e.getKey(), e.getValue());
            });
        }
    }


    public static boolean isValidLine(String line) {
        return line.matches("[a-zA-Z ]+ @[A-Za-z ]+ [0-9]+ [0-9]+");
    }

    public static int index(String secondPart) {
        int index = 0;
        for (int i = 0; i < secondPart.length(); i++) {
            if (Character.isDigit(secondPart.charAt(i))) {
                index = i;
                break;
            }
        }
        return index;
    }

}