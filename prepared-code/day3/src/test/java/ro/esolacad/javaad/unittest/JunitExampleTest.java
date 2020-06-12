package ro.esolacad.javaad.unittest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class JunitExampleTest {

    @Test
    public void testAssertEquals() {
        List<Integer> firstFourNumbers = IntStream.range(0, 5).boxed().collect(Collectors.toList());

        assertEquals(Arrays.asList(0, 1, 2, 3, 4), firstFourNumbers);
        assertNotEquals(Arrays.asList(0, 1, 2, 3, 5), firstFourNumbers);

        assertSame(firstFourNumbers, firstFourNumbers);
        assertNotSame(Arrays.asList(0, 1, 2, 3, 4), firstFourNumbers);

//        Assertions.assertEquals(Arrays.asList(0, 1, 2, 3, 5), firstFourNumbers, () -> "Lists are not equals");

        Car car1 = new Car("1", "Ford",
                BigDecimal.valueOf(3), "AIRCON", Car.OverallCondition.USED);

        Car car2 = new Car("1", "Ford",
                BigDecimal.valueOf(3), "AIRCON", Car.OverallCondition.USED);

        assertEquals(car1, car2);
    }

    @Test
    public void testNotNull() {
        CarRepairShop carRepairShop = new CarRepairShop();

        Assertions.assertNotNull(carRepairShop);
        Assertions.assertNull(null);
    }

    @Test
    public void testLists() {
        int[] ints = IntStream.range(0, 5).toArray();
        int[] ints2 = IntStream.range(0, 5).toArray();

        // Checks size and then individual differences
        Assertions.assertArrayEquals(ints, ints2);

        List<Integer> expectedNumberList = IntStream.range(0, 5).boxed().collect(Collectors.toList());
        List<Integer> actualNumberList = IntStream.range(0, 5).boxed().collect(Collectors.toList());

        assertIterableEquals(expectedNumberList, actualNumberList);

        List<String> expectedLines = Arrays.asList("Good", "News", "Everyone");
        List<String> actualLines = Arrays.asList("Good", "News", "Everyone");

        assertLinesMatch(expectedLines, actualLines);
    }

    @Test
    public void testAssertAll() {
        Car car = new Car("1", "Ford",
                BigDecimal.valueOf(3), "AIRCON", Car.OverallCondition.USED);
        // TODO
        assertAll("getters",
                () -> assertEquals(car.getBrand(), "Ford"),
                () -> assertEquals(car.getCondition(), Car.OverallCondition.USED)
        );
    }
}
