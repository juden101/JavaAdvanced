package BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineArguments = scanner.nextLine().split(" ");
        String command = lineArguments[0];

        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        while (!command.equals("'End")) {
            String result = "";
            switch (command) {
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    result = "Account ID" + account.getId() + " created";
                    break;
                case "Deposit":
                    int accountId = Integer.parseInt(lineArguments[1]);
                    double amount = Double.parseDouble(lineArguments[2]);

                    BankAccount current = accounts.get(accountId);

                    if (current == null) {
                        result = "Account does not exist";
                        break;
                    }

                    current.deposit(amount);
                    accounts.put(accountId, current);
                    result = String.format("Deposited %.0f to Id%d", amount, accountId);
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(lineArguments[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int accountId2 = Integer.parseInt(lineArguments[1]);
                    int years = Integer.parseInt(lineArguments[2]);
                    BankAccount current2 = accounts.get(accountId2);

                    if (current2 == null) {
                        result = "Account does not exist";
                        break;
                    }

                    double currentAccountInterest = current2.getInterestRate(years);
                    result = String.format("%.2f",currentAccountInterest);
                    break;
            }
            if (!result.isEmpty()) {
                System.out.println(result);
            }

            lineArguments = scanner.nextLine().split(" ");
            command = lineArguments[0];
        }

    }

    private static void createAccount() {
    }

}
