import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        ArrayDeque<StringBuilder> stackUndo = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] line = scanner.nextLine().split("\\s+");
            switch (line[0]) {
                case "1":
                    text.append(line[1]);
                    stackUndo.push(new StringBuilder(text));
                    break;
                case "2":
                    int symbols = Integer.parseInt(line[1]);
                    text.delete(text.length() - symbols, text.length());
                    stackUndo.push(text);
                    break;
                case "3":
                    int index = Integer.parseInt(line[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    if (stackUndo.size() > 1) {
                        stackUndo.pop();
                        text = stackUndo.peek();
                    }else {
                        text = new StringBuilder();
                    }
                    break;
            }
        }
    }
}
