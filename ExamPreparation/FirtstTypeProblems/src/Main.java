import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> line = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        ArrayDeque<Integer> stack = new ArrayDeque<>(line);
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        Integer[] array = stack.toArray(Integer[]::new);
        for (int i = 0; i < line.size(); i++) {
            stack2.push(line.get(i));
        }
        for (Integer integer : stack) {
            System.out.println(stack.pop());
        }



    }
}
