package ro.esolacad.javaad.java8andabove;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamReducerTest {

    @Test
    public void testReduceStream() {
        Integer reduce = Stream.of(1, 2, 3, 4, 5)
                .reduce(0, (accumulator, currentValue) -> {
                    System.out.println("Acc: " + accumulator + " , current value: " + currentValue);
                    return accumulator + currentValue;
                });

        assert reduce == 15;
    }

    @Test
    public void testCount() {
        assert Stream.of(1, 2, 3, 4, 5).count() == 5L;
    }

    @Test
    public void joiningTest() {
        String joinedString = Stream.of("Text1", "Text2", "Text3")
                .collect(Collectors.joining(","));

        assert joinedString.equals("Text1,Text2,Text3");

        String joinedString2 = Stream.of("Text1", "Text2", "Text3")
                .collect(Collectors.joining(",", "[", "]"));

        assert joinedString2.equals("[Text1,Text2,Text3]");
    }

    @Test
    public void maxMinTest() {
        Optional<Integer> max = Stream.of(1, 2, 3, 4).max(Comparator.comparing(x -> x));

        assert max.get() == 4;

        Optional<Integer> min = Stream.of(1, 2, 3, 4).min(Comparator.comparing(x -> x));

        assert min.get() == 1;
    }
}
