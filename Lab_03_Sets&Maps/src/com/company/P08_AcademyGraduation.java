package com.company;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class P08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Double[]> studentByNote = new TreeMap<>();

        while (n-- > 0) {
            String studentName = scanner.nextLine();
            String[] scoresString = scanner.nextLine().split(" ");
            Double[] scores = new Double[scoresString.length];

            for (int i = 0; i < scores.length; i++) {
                scores[i] = (Double.parseDouble(scoresString[i]));
            }
            studentByNote.put(studentName, scores);
        }

        for (String studentName : studentByNote.keySet()) {

            double avg = Arrays.stream(studentByNote.get(studentName)).mapToDouble(Double::doubleValue).average().getAsDouble();
            System.out.println(studentName + " is graduated with " + avg);
        }


    }
}
