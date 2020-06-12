package ro.esolacad.javaad.java8andabove;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberStreamsTest {

    @Test
    public void testIntStream() {
        int sum = IntStream.range(0, 20).sum();

        assert sum == 190;

        IntSummaryStatistics intSummaryStatistics = IntStream.rangeClosed(0, 10)
                .summaryStatistics();

        assert intSummaryStatistics.getSum() == 55;
        assert intSummaryStatistics.getMax() == 10;
    }

    @Test
    public void testToObj() {
        List<LottoWinnings> lottoWinningsList = IntStream.of(1_000_000, 9_999, 8_000)
                .mapToObj(x -> new LottoWinnings(
                        BigDecimal.valueOf(x), BigDecimal.valueOf(x / 2))
                )
                .collect(Collectors.toList());

        System.out.println(lottoWinningsList);
    }

}
