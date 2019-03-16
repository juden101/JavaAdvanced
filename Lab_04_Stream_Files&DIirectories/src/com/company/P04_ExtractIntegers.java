package com.company;

import java.io.*;
import java.util.Scanner;

public class P04_ExtractIntegers {
    private final static String FILE_PATH = "C:\\Users\\Stefan\\IdeaProjects\\03.JavaFundamentals\\01.JavaAdvanced\\Lab_04_Stream_Files&DIirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private final static String FILE_OUTPUT_PATH = "C:\\Users\\Stefan\\IdeaProjects\\03.JavaFundamentals\\01.JavaAdvanced\\Lab_04_Stream_Files&DIirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputIntegers.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_PATH));

        FileWriter writer = new FileWriter(FILE_OUTPUT_PATH);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int next = scanner.nextInt();
                System.out.println(next);
                writer.write(next + "\n");
            }
            scanner.next();
        }
        writer.flush();
    }
}
