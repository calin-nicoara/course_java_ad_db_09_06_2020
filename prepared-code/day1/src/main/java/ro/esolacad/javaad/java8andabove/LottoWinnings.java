package ro.esolacad.javaad.java8andabove;

import java.math.BigDecimal;
import java.util.Objects;

class LottoWinnings {

    private final BigDecimal firstPrize;
    private final BigDecimal secondPrize;

    public LottoWinnings(final BigDecimal firstPrize, final BigDecimal secondPrize) {
        this.firstPrize = firstPrize;
        this.secondPrize = secondPrize;
    }

    public BigDecimal getFirstPrize() {
        return firstPrize;
    }

    public BigDecimal getSecondPrize() {
        return secondPrize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPrize, secondPrize);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoWinnings that = (LottoWinnings) o;
        return firstPrize.equals(that.firstPrize) &&
                secondPrize.equals(that.secondPrize);
    }

    @Override
    public String toString() {
        return "LottoWinnings{" +
                "firstPrize=" + firstPrize +
                ", secondPrize=" + secondPrize +
                '}';
    }
}
