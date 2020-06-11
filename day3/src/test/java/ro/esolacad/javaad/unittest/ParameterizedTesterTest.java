package ro.esolacad.javaad.unittest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import ro.esolacad.javaad.cleancode.immutable.ImmutableCitizen;
import ro.esolacad.javaad.csv.Citizen;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTesterTest {

    @ParameterizedTest
    @CsvSource({"10,4,1", "5,4,2", "5,5,4"})
    public void testCalculator(int firstParam, int secondParam, int expectedResult) {
        Calculator calculator = new Calculator();

        assertEquals(expectedResult, calculator.getRandomNumber(firstParam, secondParam));
    }

    @ParameterizedTest
    @ValueSource(ints = {2 ,4, 6, 8, 10, 12})
    void isOdd(int number) {
        System.out.println(number);
        assertTrue(number % 2 == 0);
    }

    @ParameterizedTest
//    @ValueSource(strings = {"", "    "})
//    @NullSource
//    @EmptySource
    @NullAndEmptySource
    void isStringEmpty(String stringToCheck) {
        assertTrue(stringToCheck == null || stringToCheck.trim().equals(""));
    }

    @ParameterizedTest
    @MethodSource("testCitizenIsForeignSupplier")
    void testCitizenIsForeign(Citizen citizen) {
        assertTrue(citizen.getIsForeigner());
    }

    private static Stream<Arguments> testCitizenIsForeignSupplier() {
        Citizen citizen2 = new Citizen();
        citizen2.setForeigner(true);
        Citizen citizen3 = new Citizen();
        citizen3.setForeigner(true);

        return Stream.of(
                Arguments.of(citizen2),
                Arguments.of(citizen2)
        );
    }
}
