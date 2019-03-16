package CarDemo;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carCount = Integer.parseInt(scanner.nextLine());

        IntStream
                .rangeClosed(1, carCount)
                .boxed()
                .map(n -> scanner.nextLine().split("\\s+"))
                .map(data -> {
                    Car current;

                    if (data.length == 3) {
                        current = new Car(data[0], data[1], Integer.parseInt(data[2]));
                    } else {
                        current = new Car(data[0]);
                    }

                    return current;
                })
                .forEach(car -> System.out.print(car.carInfo()));
    }
}
