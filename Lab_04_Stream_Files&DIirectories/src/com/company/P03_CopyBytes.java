package com.company;

import java.io.*;

public class P03_CopyBytes {
    private final static String FILE_PATH = "C:\\Users\\Stefan\\IdeaProjects\\03.JavaFundamentals\\01.JavaAdvanced\\Lab_04_Stream_Files&DIirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private final static String FILE_OUTPUT_PATH = "C:\\Users\\Stefan\\IdeaProjects\\03.JavaFundamentals\\01.JavaAdvanced\\Lab_04_Stream_Files&DIirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputByte.txt";

    public static void main(String[] args) {

        try (InputStream input = new FileInputStream(FILE_PATH)) {
            OutputStream out = new FileOutputStream(FILE_OUTPUT_PATH);
            int oneByte = input.read();

            while (oneByte >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }

                oneByte = input.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
