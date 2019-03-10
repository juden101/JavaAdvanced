import java.util.ArrayDeque;
import java.util.Scanner;

public class P04_Intership {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int problemCount = Integer.parseInt(scanner.nextLine());
        int candidatesNumber = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (problemCount-- > 0) {
            String line = scanner.nextLine();
            stack.push(line);
        }

        ArrayDeque<String> deque = new ArrayDeque<>();

        while (candidatesNumber-- > 0) {
            String line = scanner.nextLine();
            if (isValidName(line)) {
                deque.offer(line);
            }
        }
        int n = 0;
        while (deque.size() != 1 && !stack.isEmpty()) {

            if (isProblemSolved(deque.peekFirst(), stack.peek())) {
                String candidate = deque.pollFirst();
                deque.offerLast(candidate);
                String problem = stack.pop();
                System.out.printf("%s solved %s.\n", candidate, problem);
            } else {
                String candidate = deque.pollFirst();
                String problem = stack.pop();
                stack.offerLast(problem);
                System.out.printf("%s failed %s.\n", candidate, problem);
            }

        }

        if (deque.size() == 1) {
            System.out.printf("%s gets the job!", deque.poll());
        } else {
            int counter = deque.size();
            for (String name : deque) {
                if (counter == 1) {
                    System.out.printf("%s", name);
                } else {
                    System.out.printf("%s, ", name);

                }
                counter--;
            }
        }


    }


    public static boolean isValidName(String names) {
        return names.matches("[A-Z][a-z]+ [A-Z][a-z]+");
    }

    public static boolean isProblemSolved(String name, String problem) {
        boolean isSolved = false;
        int nameNumber = 0;

        for (int i = 0; i < name.length(); i++) {
            nameNumber += name.charAt(i);
        }
        int problemNumber = 0;

        for (int i = 0; i < problem.length(); i++) {
            problemNumber += problem.charAt(i);
        }

        if (nameNumber >= problemNumber) {
            isSolved = true;
        }

        return isSolved;
    }
}
