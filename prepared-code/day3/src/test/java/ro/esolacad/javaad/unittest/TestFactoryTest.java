package ro.esolacad.javaad.unittest;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFactoryTest {

    private final List<Car> cars = Arrays.asList(
            new Car("0001", "FORD", BigDecimal.valueOf(12000), "CHROME RIMS", Car.OverallCondition.NEW),
            new Car("0002", "BMW", BigDecimal.valueOf(20000), "CHROME RIMS", Car.OverallCondition.POOR)
    );
    private final List<BigDecimal> prices = Arrays.asList(
            BigDecimal.valueOf(1200),
            BigDecimal.valueOf(4000)
    );

    @TestFactory
    public Stream<DynamicTest> testPrices() {
        CarRepairShop carRepairShop = new CarRepairShop();

        return cars.stream()
                .map(car ->
                        DynamicTest.dynamicTest("Get price of car " + car.getSerialNumber(), () -> {
                            int id = cars.indexOf(car);
                            assertEquals(prices.get(id).toBigInteger(), carRepairShop.getPriceForRepair(car).toBigInteger());
                        })
                );
    }

    @Test
    public void testParameterized() {
        // TODO
    }
}
