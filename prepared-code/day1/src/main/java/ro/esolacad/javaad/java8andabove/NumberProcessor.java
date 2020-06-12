package ro.esolacad.javaad.java8andabove;

import java.util.function.Function;
import java.util.function.Predicate;

public class NumberProcessor {

    private final Predicate<Integer> predicate;
    private final Function<Integer, Integer> function;

    public NumberProcessor(final Predicate<Integer> predicate,
                           final Function<Integer, Integer> function) {
        this.predicate = predicate;
        this.function = function;
    }

    public int testAndProcessNumber(final int numberToTestAndProcess) {
        if (predicate.test(numberToTestAndProcess)) {
            return function.apply(numberToTestAndProcess);
        }

        return 0;
    }
}
