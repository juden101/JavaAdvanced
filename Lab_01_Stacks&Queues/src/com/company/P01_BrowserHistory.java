package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_BrowserHistory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        while (true) {

            String input = scanner.nextLine();

            if (input.equals("Home")) {
                break;
            }

            if (!input.equals("back")) {
                browserHistory.push(input);
                System.out.println(input);
            } else {

                if (browserHistory.isEmpty() || browserHistory.size() == 1) {
                    System.out.println("no previous URLs");

                    if (!browserHistory.isEmpty()) {
                        browserHistory.pop();
                    }

                } else {
                    browserHistory.pop();
                    String currentUrl = browserHistory.peek();
                    System.out.println(currentUrl);
                }

            }

        }
    }
}
