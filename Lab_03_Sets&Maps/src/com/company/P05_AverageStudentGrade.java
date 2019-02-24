package com.company;

import java.text.DecimalFormat;
import java.util.*;

public class P05_AverageStudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<Double>> record = new TreeMap<>();
        int gradesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < gradesCount; i++) {
            String[] parts = scanner.nextLine().split(" ");
            String name = parts[0];
            double grade = Double.parseDouble(parts[1]);

            if (record.containsKey(name)) {
                List<Double> currentGrades = record.get(name);
                currentGrades.add(grade);
                record.put(name, currentGrades);
            } else {
                record.put(name, new ArrayList<>());
                record.get(name).add(grade);

            }
        }

        DecimalFormat df = new DecimalFormat("#.00");

        for (String studentName : record.keySet()) {
            System.out.print(studentName + " -> ");
            double gradeSum = 0;

            for (Double grade : record.get(studentName)) {
                System.out.print(df.format(grade) + " ");
                gradeSum += grade;
            }

            System.out.printf("(avg: %.2f)\n", gradeSum / record.get(studentName).size());
        }


    }
}
