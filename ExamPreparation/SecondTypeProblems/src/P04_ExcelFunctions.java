import java.util.*;
import java.util.stream.Collectors;

public class P04_ExcelFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> table = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        String[] header = scanner.nextLine().split(", ");

        for (int i = 0; i < n - 1; i++) {
            List<String> field = Arrays
                    .stream(scanner.nextLine().split(",\\s+"))
                    .collect(Collectors.toList());
            table.add(field);
        }

        int index = 0;

        String[] cmd = scanner.nextLine().split("\\s+");

        for (int i = 0; i < header.length; i++) {
            if (cmd[1].equals(header[i])) {
                index = i;
                break;
            }
        }

        final int indexPosition = index;

        switch (cmd[0]) {
            case "hide":
                String[] newHeader = Arrays.stream(header).filter(h -> !h.equals(cmd[1]))
                        .toArray(String[]::new);
                System.out.println(String.join(" | ", newHeader));
                StringBuilder output = new StringBuilder();
                for (int i = 0; i < table.size(); i++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int j = 0; j < table.get(i).size(); j++) {
                        if (j == indexPosition) {
                            continue;
                        }
                        stringBuilder.append(table.get(i).get(j)).append(" | ");
                    }
                    output.append(stringBuilder.substring(0, stringBuilder.length() - 2)).append("\n");
                }

                System.out.println(output.toString());

                break;
            case "sort":
                System.out.println(String.join(" | ", header));
                List<List<String>> data = table.stream()
                        .sorted(Comparator.comparing(o -> o.get(indexPosition)))
                        .collect(Collectors.toList());
                printMethod(data);
                break;
            case "filter":
                System.out.println(String.join(" | ", header));
                List<List<String>> filterData = table.stream()
                        .filter(strings -> strings.get(indexPosition).equals(cmd[2]))
                        .collect(Collectors.toList());
                printMethod(filterData);
                break;
        }

    }


    private static void printMethod(List<List<String>> data) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < data.get(i).size(); j++) {
                stringBuilder.append(data.get(i).get(j)).append(" | ");
            }
            output.append(stringBuilder.substring(0, stringBuilder.length() - 2)).append("\n");
        }

        System.out.println(output.toString());
    }
}

