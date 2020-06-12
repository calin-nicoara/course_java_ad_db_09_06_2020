package ro.esolacad.javaad.java8andabove;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSourceTest {

    @Test
    public void testSourceStream() {
        Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);

        Arrays.stream(new int[]{1, 2, 3, 4}).forEach(System.out::println);
    }

    @Test
    public void testGenerateStream() {
        List<String> collect = Stream.generate(() -> "test").limit(10).collect(Collectors.toList());

        assert collect.equals(Arrays.asList("test", "test", "test", "test", "test", "test", "test",
                "test", "test", "test"));
    }

    @Test
    public void testIterateStream() {
        List<Integer> collect = Stream.iterate(0, n -> n + 1).limit(10).collect(Collectors.toList());

        assert collect.equals(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
}
