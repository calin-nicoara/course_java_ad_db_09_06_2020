package ro.esolacad.javaad.lambda;


import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

class NumberCalculatorTest {

    @Test
    public void testNumericCalculator() {
        NumberCalculator numberCalculator = number -> number + 10;

        assert numberCalculator.calculateNumber(10) == 20;
    }

    @Test
    public void testNumericCalculator2() {
        NumberCalculator numberCalculator = number -> {
            System.out.println("Labmda method");
            return number + 10;
        };

        assert numberCalculator.calculateNumber(10) == 20;
    }

    @Test
    public void testShowSomething() {
        ShowMeSomething showMeSomethingUpperCase = (message, upperCase) -> {
            if(upperCase) {
                System.out.println(message.toUpperCase());
            } else {
                System.out.println(message);
            }
        };

        showMeSomethingUpperCase.showSomething("Hello there", true);
    }

    @Test
    public void testNoParam() {
        NoParamInterface noParamInterface = () -> "Hello there!";
    }
}
