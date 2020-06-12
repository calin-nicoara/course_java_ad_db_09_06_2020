package ro.esolacad.javaad.java8andabove;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UtilFunctionsTest {

    @Test
    public void testSupplier() {
        Supplier<LottoWinnings> supplier = new Supplier<>() {
            @Override
            public LottoWinnings get() {
                return new LottoWinnings(BigDecimal.valueOf(2000000), BigDecimal.valueOf(1000000));
            }
        };

        LottoWinnings lottoWinnings1 = supplier.get();
        LottoWinnings lottoWinnings2 = supplier.get();

        assert lottoWinnings1.getFirstPrize().compareTo(BigDecimal.valueOf(2000000)) == 0;
        assert lottoWinnings2.getFirstPrize().compareTo(BigDecimal.valueOf(2000000)) == 0;

        assert lottoWinnings1 != lottoWinnings2;
    }

    @Test
    public void testConsumer() {
        Consumer<LottoWinnings> showBigPrizeMoney = new Consumer<LottoWinnings>() {
            @Override
            public void accept(final LottoWinnings lottoWinnings) {
                System.out.println("BIG PRIZE IS " + lottoWinnings.getFirstPrize());
            }
        };

        LottoWinnings lottoWinnings = new LottoWinnings(BigDecimal.TEN, BigDecimal.ONE);
        showBigPrizeMoney.accept(lottoWinnings);
    }

    @Test
    public void testPredicate() {
        Predicate<LottoWinnings> moreThanAMillion = new Predicate<LottoWinnings>() {
            @Override
            public boolean test(final LottoWinnings lottoWinnings) {
                return lottoWinnings.getFirstPrize().compareTo(BigDecimal.valueOf(1_000_000)) >= 0;
            }
        };

        LottoWinnings smallLottoWinnings = new LottoWinnings(BigDecimal.TEN, BigDecimal.ONE);

        assert !moreThanAMillion.test(smallLottoWinnings);

        LottoWinnings bigLottoWinnings = new LottoWinnings(BigDecimal.valueOf(2_000_000),
                BigDecimal.ONE);

        assert moreThanAMillion.test(bigLottoWinnings);
    }

    @Test
    public void testFunction() {
        Function<Integer, Integer> doubleFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(final Integer integer) {
                return integer * 2;
            }
        };

        assert doubleFunction.apply(4) == 8;
        assert doubleFunction.apply(20) == 40;
    }
}
