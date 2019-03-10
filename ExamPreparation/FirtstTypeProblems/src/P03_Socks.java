import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_Socks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Integer> leftSocks = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        LinkedList<Integer> rightSocks = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        LinkedList<Integer> pairs = new LinkedList<>();

        listManipulator(leftSocks, rightSocks, pairs);

        int maxPar = Collections.max(pairs);

        System.out.println(maxPar);

        for (Integer par : pairs) {
            System.out.print(par + " ");
        }

    }

    public static void listManipulator(LinkedList<Integer> left, LinkedList<Integer> right, LinkedList<Integer> pairs) {

        while (!right.isEmpty() && !left.isEmpty()) {
            int leftIndex = left.size() - 1;
            //rightIndex always is 0

            if (left.get(leftIndex).compareTo(right.get(0)) > 0) {
                pairs.add(left.get(leftIndex) + right.get(0));
                left.remove(leftIndex);
                right.remove(0);
            } else if (left.get(leftIndex).compareTo(right.get(0)) == 0) {
                right.remove(0);
                left.set(leftIndex, left.get(leftIndex) + 1);
            } else {
                left.remove(leftIndex);
            }
        }
    }

}