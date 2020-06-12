package ro.esolacad.javaad.java8andabove;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UtilFunctionsWithLambdas {
    @Test
    public void testSupplier() {
        Supplier<LottoWinnings> supplier = () -> new LottoWinnings(BigDecimal.valueOf(2000000),
                BigDecimal.valueOf(1000000));

        LottoWinnings lottoWinnings1 = supplier.get();
        LottoWinnings lottoWinnings2 = supplier.get();

        assert lottoWinnings1.getFirstPrize().compareTo(BigDecimal.valueOf(2000000)) == 0;
        assert lottoWinnings2.getFirstPrize().compareTo(BigDecimal.valueOf(2000000)) == 0;

        assert lottoWinnings1 != lottoWinnings2;
    }

    @Test
    public void testConsumer() {
        Consumer<LottoWinnings> showBigPrizeMoney = lottoWinnings ->
                System.out.println("BIG PRIZE IS " + lottoWinnings.getFirstPrize());

        Consumer<LottoWinnings> showSmallPrizeMoney = lottoWinnings -> System.out.println("SMALL PRIZE IS " +
                lottoWinnings.getSecondPrize());

        LottoWinnings lottoWinnings = new LottoWinnings(BigDecimal.TEN, BigDecimal.ONE);
//        showBigPrizeMoney.accept(lottoWinnings);

        showBigPrizeMoney.andThen(showSmallPrizeMoney).accept(lottoWinnings);
    }

    @Test
    public void testPredicate() {
        Predicate<LottoWinnings> moreThanAMillion = lottoWinnings ->
                lottoWinnings.getFirstPrize().compareTo(BigDecimal.valueOf(1_000_000)) >= 0;

        Predicate<LottoWinnings> bigPrizeMoreThanDoubleTheSmall = lottoWinnings -> {
            BigDecimal doubleSmallWinnings = lottoWinnings.getSecondPrize().multiply(BigDecimal.valueOf(2));
            return lottoWinnings.getFirstPrize().compareTo(doubleSmallWinnings) >= 0;
        };

        LottoWinnings bothBigPrizes = new LottoWinnings(
                BigDecimal.valueOf(1_999_999), BigDecimal.valueOf(1_000_000));

        assert !moreThanAMillion.and(bigPrizeMoreThanDoubleTheSmall)
                .test(bothBigPrizes);

        assert moreThanAMillion.or(bigPrizeMoreThanDoubleTheSmall)
                .test(bothBigPrizes);

        assert !moreThanAMillion.negate().test(bothBigPrizes);
    }

    @Test
    public void testFunction() {
        Function<Integer, Integer> doubleFunction = integer -> integer * 2;

        assert doubleFunction.apply(4) == 8;
        assert doubleFunction.apply(20) == 40;

        assert doubleFunction.andThen(result -> result * 3).apply(4) == 24;

        Function<Integer, Integer> ma = result -> result + 2;
        assert doubleFunction.compose(ma).apply(2) == 8;
    }
}
