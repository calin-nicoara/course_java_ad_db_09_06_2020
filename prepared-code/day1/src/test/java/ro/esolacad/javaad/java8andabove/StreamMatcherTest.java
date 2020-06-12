package ro.esolacad.javaad.java8andabove;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamMatcherTest {

    @Test
    public void testAnyMatch() {
        boolean anyOddNumbers = Stream.iterate(0, x -> x + 2).limit(20)
                .anyMatch(x -> x % 2 == 1);

        assert !anyOddNumbers;
    }

    @Test
    public void testAllMatch() {
        boolean allEvenNumbers = Stream.iterate(0, x -> x + 2).limit(20)
                .allMatch(x -> x % 2 == 0);

        assert allEvenNumbers;
    }

    @Test
    public void testNoneMatch() {
        boolean noOddNumber = Stream.iterate(0, x -> x + 2).limit(20)
                .noneMatch(x -> x % 2 == 1);

        assert noOddNumber;
    }

    @Test
    public void testFindAny() {
        Optional<Integer> any = Stream.iterate(0, x -> x + 2).limit(20).findAny();

        assert !any.isEmpty();

        assert Stream.empty().findAny().isEmpty();

        assert Stream.empty().findFirst().isEmpty();
    }
}
