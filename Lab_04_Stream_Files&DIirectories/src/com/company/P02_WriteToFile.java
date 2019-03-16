package com.company;

import java.io.*;
import java.util.*;

public class P02_WriteToFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\Stefan\\IdeaProjects\\03.JavaFundamentals\\01.JavaAdvanced\\Lab_04_Stream_Files&DIirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPutPath = "C:\\Users\\Stefan\\IdeaProjects\\03.JavaFundamentals\\01.JavaAdvanced\\Lab_04_Stream_Files&DIirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";
        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols,',','!','.','?');

        try(InputStream in = new FileInputStream(path)) {
            OutputStream out = new FileOutputStream(outPutPath);
            int oneByte = in.read();

            while (oneByte >= 0) {
                if (!symbols.contains((char)oneByte)){
                    out.write((char) oneByte);
                }
                oneByte = in.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
