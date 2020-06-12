package ro.esolacad.javaad.lab;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciOneLiner {

    public static List<Long> getFibonacciList(Integer maxLimit) {
        return Stream.iterate(new long[]{0, 1}, previous -> new long[]{previous[1], previous[0] + previous[1]})
                .limit(maxLimit)
                .map(x -> x[0])
                .collect(Collectors.toList());
    }
}
