package ro.esolacad.javaad.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void testFirstStream() {
        List<Integer> integers = Arrays.asList(1, 5, 100, 200, 50, 80, 13);

        integers.stream()
                .filter(x -> x > 50)
                .map(x -> x * 10)
                .forEach(System.out::println);
    }

    @Test
    public void testParallel() {
        List<Integer> collect = Stream.iterate(0, n -> n + 1)
                .limit(10)
//                .parallel()
                .peek(x -> {
                    System.out.println("peeking" + x);
                })
                .map(x -> {
                    System.out.println("Mapping: " + x);
                    return x * 2;
                })
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
