package softUniParking;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.cars = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public String addCar(Car car) {
        if (cars.containsKey(car.getRegistrationNumber())) {
            return "Car with that registration number, already exists!";
        }

        if (cars.size() >= this.capacity) {
            return "Parking is full!";
        }

        cars.put(car.getRegistrationNumber(), car);
        return "Successfully added new car " + car.getMake() + " " + car.getRegistrationNumber();
    }

    public String removeCar(String registrationNumber) {
        if (this.cars.remove(registrationNumber) != null) {
            return "Successfully removed " + registrationNumber;
        } else {
            return "Car with that registration number, doesn't exists!";
        }
    }

    public Car getCar(String registrationNumber) {
        return this.cars.get(registrationNumber);
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers) {
        for (String number : registrationNumbers) {
            this.removeCar(number);
        }
    }

    public int getCount() {
        return this.cars.size();
    }


}
