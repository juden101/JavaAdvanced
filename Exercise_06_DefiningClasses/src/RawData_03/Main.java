package RawData_03;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Car>> cargoTypes = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] lines = scanner.nextLine().split("\\s+");

            String model = lines[0];

            int engineSpeed = Integer.parseInt(lines[1]);
            int enginePower = Integer.parseInt(lines[2]);

            int cargoWeight = Integer.parseInt(lines[3]);
            String cargoType = lines[4];

            double tirePressure1 = Double.parseDouble(lines[5]);
            int tireAge1 = Integer.parseInt(lines[6]);

            double tirePressure2 = Double.parseDouble(lines[7]);
            int tireAge2 = Integer.parseInt(lines[8]);

            double tirePressure3 = Double.parseDouble(lines[9]);
            int tireAge3 = Integer.parseInt(lines[10]);

            double tirePressure4 = Double.parseDouble(lines[11]);
            int tireAge4 = Integer.parseInt(lines[12]);

            Tire[] tires = new Tire[4];
            tires[0] = new Tire(tireAge1, tirePressure1);
            tires[1] = new Tire(tireAge2, tirePressure2);
            tires[2] = new Tire(tireAge3, tirePressure3);
            tires[3] = new Tire(tireAge4, tirePressure4);

            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Engine engine = new Engine(engineSpeed, enginePower);

            Car car = new Car(model, engine, cargo, tires);

            if (!cargoTypes.containsKey(cargoType)) {
                List<Car> cars = new ArrayList<>();
                cars.add(car);
                cargoTypes.put(cargoType, cars);
            } else {
                List<Car> cars = cargoTypes.get(cargoType);
                cars.add(car);
                cargoTypes.put(cargoType, cars);
            }
        }

        String cargoType = scanner.nextLine();

        if (cargoType.equals("fragile")) {
            cargoTypes.get(cargoType).stream().filter(car -> {
                for (int i = 0; i < car.getTires().length; i++) {
                    if (car.getTires()[i].getPressure() <= 1) {
                        return true;
                    }
                }
                return false;
            }).forEach(car -> System.out.printf("%s%n", car.getModel()));
        } else {
            cargoTypes.get(cargoType).stream()
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }
}
