package ro.esolacad.javaad.java8andabove;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGroupCollectorTest {

    @Test
    public void testFirstCollect() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 10, 20, 50, 33, 75);

        List<Integer> finalNumbers = integers.stream()
                .filter(s -> s % 2 == 0)
                .map(s -> s * 2)
                .collect(Collectors.toUnmodifiableList());

        List<Integer> expectedResult = Arrays.asList(4, 20, 40, 100);

        assert expectedResult.size() == finalNumbers.size();
        assert expectedResult.containsAll(finalNumbers);
    }

    @Test
    public void testLazy() {
        AtomicInteger atomicInteger = new AtomicInteger();

        List<Integer> integers = Arrays.asList(1, 2, 3, 10, 20, 50, 33, 75);

        integers.stream()
                .filter(number -> number > 20)
                .peek(numberBiggerThanTwenty -> {
                    System.out.println("Current: " + numberBiggerThanTwenty);
                    atomicInteger.incrementAndGet();
                })
                .map(numberBiggerThanTwenty -> numberBiggerThanTwenty / 2);

        assert atomicInteger.get() == 0;
    }


    @Test
    public void testCollectorToSet() {
        Set<Integer> resultedSet = Stream.of(0, 1, 2, 3, 2)
                .map(x -> x * 2)
                .collect(Collectors.toSet());

        Set<Integer> expectedSet = new HashSet<>(Arrays.asList(0, 2, 4, 6));

        assert expectedSet.equals(resultedSet);
    }

    @Test
    public void testCollectorToMap() {
        Map<Integer, Integer> integerMap = Stream.of(0, 1, 2)
                .collect(Collectors.toMap(x -> x, x -> x * 2));

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, 2);
        expected.put(2, 4);

        assert integerMap.equals(expected);
    }

    @Test
    public void testGroupingBy() {
        Map<Integer, List<Integer>> mappedByDivisibleWith3 = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8)
                .collect(Collectors.groupingBy(x -> x % 3));

        assert mappedByDivisibleWith3.get(1).equals(Arrays.asList(1, 4, 7));

        Map<Integer, Set<Integer>> mappedByDisivibleBy2 = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8)
                .collect(Collectors.groupingBy(x -> x % 2, Collectors.toSet()));

        assert mappedByDisivibleBy2.get(1).equals(Set.of(1, 3, 5, 7));
    }

    @Test
    public void testPartitionBy() {
        Map<Boolean, List<Integer>> partitionedBy = Stream.of(0, 2, 4, 6, 8)
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));

        assert partitionedBy.get(false).equals(Collections.emptyList());

        Map<Boolean, List<Integer>> groupedBy = Stream.of(0, 2, 4, 6, 8)
                .collect(Collectors.groupingBy(x -> x % 2 == 0));

        assert groupedBy.get(false) == null;
    }


}
