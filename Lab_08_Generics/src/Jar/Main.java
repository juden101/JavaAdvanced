package Jar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jar<String> jar = new Jar<String>();

        jar.add("pesho");
        jar.add("second");
        jar.remove();
    }
}
