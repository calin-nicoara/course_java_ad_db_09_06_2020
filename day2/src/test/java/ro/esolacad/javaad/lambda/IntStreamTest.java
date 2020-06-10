package ro.esolacad.javaad.lambda;

import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamTest {

    @Test
    public void intSteram() {
        IntSummaryStatistics intSummaryStatistics = IntStream.range(0, 1000)
                .filter(x -> x % 2 == 0)
                .summaryStatistics();

        System.out.println(intSummaryStatistics);

        List<Integer> collect = IntStream.range(0, 1000)
                .boxed()
                .collect(Collectors.toList());
    }
}
