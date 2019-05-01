package CompanyRoster_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departments = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String departmentName = tokens[3];
            Employee employee = null;

            switch (tokens.length) {
                case 4:
                    employee = new Employee(tokens[0], Double.parseDouble(tokens[1]));
                    break;
                case 5:
                    if (tokens[4].contains("@")) {
                        employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[4]);
                    } else {
                        employee = new Employee(tokens[0], Double.parseDouble(tokens[1]),
                                Integer.parseInt(tokens[4]));
                    }
                    break;
                default:
                    employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[4],
                            Integer.parseInt(tokens[5]));
                    break;
            }

            if (!departments.containsKey(departmentName)) {
                departments.put(departmentName, new Department(departmentName));
            }

            departments.get(departmentName).getEmployees().add(employee);
        }

        departments.entrySet().stream().sorted((f, s) -> s.getValue().getAverageSalary().compareTo(f.getValue().getAverageSalary()))
                .findFirst()
                .stream()
                .forEach(e -> {
                    System.out.println("Highest Average Salary: " + e.getKey());
                    e.getValue().getEmployees().stream()
                            .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                            .forEach(employee -> System.out.println(employee.getInfo()));
                });
    }
}
