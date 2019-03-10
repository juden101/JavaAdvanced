import java.util.*;
import java.util.stream.Collectors;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> idStack = new ArrayDeque<>();
        ArrayDeque<String> agentQueue = new ArrayDeque<>();


        String[] idLine = scanner.nextLine().split("\\s+");

        for (String id : idLine) {
            idStack.push(id);
        }

        String[] agents = scanner.nextLine().split("\\s+");
        Collections.addAll(agentQueue, agents);

        String line = scanner.nextLine();
        while (!line.equals("stop")) {
            String[] agentData = line.split("\\s+");
            switch (agentData[0]) {
                case "add-ID":
                    idStack.push(agentData[1]);
                    break;
                case "add-agent":
                    agentQueue.offer(agentData[1]);
                    break;
                case "remove-ID":
                    String element = idStack.pollFirst();
                    System.out.println(element + " has been removed.");
                    break;
                case "remove-agent":
                    System.out.println(agentQueue.pollLast() + " has left the queue.");
                    break;
                case "sort-ID":
                    List<String> stack = idStack.stream()
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.toList());
                    idStack.clear();
                    stack.stream()
                            .forEach(e -> idStack.add(e));
            }
            line = scanner.nextLine();
        }

        while (!idStack.isEmpty() && !agentQueue.isEmpty()) {
            System.out.printf("%s takes ID number: %s\n", agentQueue.pollFirst(), idStack.pop());
        }

        if (agentQueue.isEmpty() && !idStack.isEmpty()) {
            System.out.printf("No more agents left.\n");
        }

        while (!idStack.isEmpty()) {
            System.out.printf("ID number: %s\n", idStack.pop());
        }
        while (!agentQueue.isEmpty()) {
            System.out.printf("%s does not have an ID.\n", agentQueue.pollFirst());
        }


    }
}
