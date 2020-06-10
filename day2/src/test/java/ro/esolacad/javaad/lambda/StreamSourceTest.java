package ro.esolacad.javaad.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamSourceTest {

    @Test
    public void testSourceStream() {
        Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);

        Arrays.stream(new int[]{1, 2, 3, 4}).forEach(x -> System.out.println(x));
    }

    @Test
    public void testGenerateStream() {
        Stream.generate(() -> "test")
                .limit(10)
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void testIterateStream() {
        UnaryOperator<Integer> unaryOperator = x -> x+1;

        Stream.iterate(0, n -> n + 1)
                .limit(100)
                .forEach(x -> System.out.println(x));
    }
}
