package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P01_ReadFile {

    public static void main(String[] args) {
        String path = "C:\\Users\\Stefan\\IdeaProjects\\03.JavaFundamentals\\01.JavaAdvanced\\Lab_04_Stream_Files&DIirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (FileInputStream inputStream = new FileInputStream(path)) {
            int oneByte = inputStream.read();

            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
