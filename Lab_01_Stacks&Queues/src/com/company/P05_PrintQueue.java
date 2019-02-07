package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_PrintQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printList = new ArrayDeque<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("print")) {
                break;
            }

            if (input.equals("cancel")) {

                if (printList.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printList.pollFirst());
                }

            } else {
                printList.offer(input);
            }
        }

        while (!printList.isEmpty()) {
            String toPrint = printList.poll();
            System.out.println(toPrint);
        }

    }
}
