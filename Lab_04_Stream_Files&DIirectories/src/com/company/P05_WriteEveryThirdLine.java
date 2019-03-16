package com.company;

import java.io.*;

public class P05_WriteEveryThirdLine {
    private final static String FILE_PATH = "C:\\Users\\Stefan\\IdeaProjects\\03.JavaFundamentals\\01.JavaAdvanced\\Lab_04_Stream_Files&DIirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private final static String FILE_OUTPUT_PATH = "C:\\Users\\Stefan\\IdeaProjects\\03.JavaFundamentals\\01.JavaAdvanced\\Lab_04_Stream_Files&DIirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(FILE_PATH));
        PrintWriter out = new PrintWriter(new FileWriter(FILE_OUTPUT_PATH));
        int count = 1;
        String line = in.readLine();
        while (line != null) {
            if (count % 3 == 0) {
                out.println(line);
            }
            count++;
            line = in.readLine();
        }
        out.flush();

    }
}

