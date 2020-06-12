package ro.esolacad.javaad.java8andabove;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdasTest {

    @Test
    public void withoutLambdas() {
        Predicate<Integer> isEvenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(final Integer integer) {
                return integer % 2 == 0;
            }
        };

        Function<Integer, Integer> squaredFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(final Integer integer) {
                return integer * integer;
            }
        };

        NumberProcessor numberProcessor = new NumberProcessor(isEvenPredicate, squaredFunction);

        assert numberProcessor.testAndProcessNumber(10) == 100;
        assert numberProcessor.testAndProcessNumber(5) == 0;
    }

    @Test
    public void withLambdas() {
        Predicate<Integer> isEvenPredicate = integer -> integer % 2 == 0;
        Function<Integer, Integer> squaredFunction = integer -> {
            // more code
            return integer * integer;
        };

        NumberProcessor numberProcessor = new NumberProcessor(isEvenPredicate, squaredFunction);

        assert numberProcessor.testAndProcessNumber(10) == 100;
        assert numberProcessor.testAndProcessNumber(5) == 0;
    }

    @Test
    public void twoParamsLambdas() {
        FunctionInterfaceTwoParams<Integer, Integer, String> bifunction =
                (Integer integer1, Integer integer2) -> integer1 + " " + integer2;

        assert bifunction.concatMe(1, 2).equals("1 2");
    }
}
