package ro.esolacad.javaad.unittest;

import java.util.HashMap;
import java.util.Map;

public class CarRepository {

    private final Map<String, Car> cars = new HashMap<>();

    public String save(final Car car) {
        System.out.println("Save the car");
        cars.put(car.getSerialNumber(), car);
        return car.getSerialNumber();
    }

    public Car findBySerialNumber(final String serialNumber) {
        System.out.println("Find by the car");
        return cars.get(serialNumber);
    }
}
