package ro.esolacad.javaad.unittest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CarRepairShop {

    private CarRepository carRepository;

    public CarRepairShop() {
    }

    public CarRepairShop(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private final Map<String, Car> carMap = new HashMap<>();

    public BigDecimal getPriceForRepair(Car car) {
        if (car.getCondition().equals(Car.OverallCondition.NEW) &&
                car.getPrice().compareTo(BigDecimal.valueOf(2000)) > 0) {
            return car.getPrice().multiply(BigDecimal.valueOf(0.1));
        } else if (car.getCondition().equals(Car.OverallCondition.POOR) &&
                car.getBrand().equals("BMV")) {
            return car.getPrice().multiply(BigDecimal.valueOf(0.5));
        } else {
            return car.getPrice().multiply(BigDecimal.valueOf(0.2));
        }
    }

    public String getCarInvoiceText(String serialNumber) {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/invoices/" + serialNumber);

        if (resourceAsStream == null) {
            throw new InvoiceNotFoundException("Invoice not found for " + serialNumber);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));

        return bufferedReader.lines().collect(Collectors.joining());
    }

    public String saveCar(Car car) {
//        this.carRepository.findBySerialNumber("0002");
        return this.carRepository.save(car);
    }
}
