package ro.esolacad.javaad.java8andabove;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void testFirstStream() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 10, 20, 50, 33, 75);

        integers.stream()
                .filter(s -> s % 2 == 0)
                .map(s -> s * 2)
                .forEach(System.out::println);
    }

    @Test
    public void testIntermediateOperation() {
        List<Integer> integers = Arrays.asList(2, 1, 1);

        List<String> finalNumbers = integers.stream()
                .filter(s -> s < 1000)
                .sorted()
                .map(s -> "Number " + s)
                .distinct()
                .collect(Collectors.toList());

        assert finalNumbers.equals(Arrays.asList("Number 1", "Number 2"));
    }

    @Test
    public void testFlatMap() {
        List<List<Integer>> listInList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6)
        );

        List<Integer> collect = listInList.stream().flatMap(Collection::stream).collect(Collectors.toList());

        assert collect.equals(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
