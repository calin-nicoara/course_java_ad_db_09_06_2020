package ro.esolacad.javaad.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamIntermediateTest {

    @Test
    public void testInter() {
        Stream.iterate(0, n -> n + 1)
                .limit(1000)
//                .filter(x -> x % 7 == 0)
                .map(x -> x / 7)
//                .peek(x -> System.out.println("From peek" + x))
                .distinct()
                .skip(10)
                .limit(5)
                .sorted()
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void testFlatMap() {
        List<List<Integer>> listOfList = new ArrayList<>();

        listOfList.add(List.of(1, 2, 3));
        listOfList.add(List.of(4, 5, 6));
        listOfList.add(List.of(7, 8, 9));

        listOfList.stream()
                .flatMap(x -> x.stream())
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void testLazy() {
        Supplier<Stream<Integer>> integerStreamSupplier = () -> List.of(1, 2, 3, 4, 5, 6, 7)
                .stream()
                .filter(x -> {
                    System.out.println("Filter: " + x);
                    return x % 2 == 0;
                })
                .map(x -> {
                    System.out.println("Map: " + x);
                    return x + 2;
                })
                .filter(x -> x % 3 == 0);

        // Must have terminating operation to process
        integerStreamSupplier.get().forEach(x -> System.out.println(x));
        integerStreamSupplier.get().forEach(x -> System.out.println(x));
    }
}
