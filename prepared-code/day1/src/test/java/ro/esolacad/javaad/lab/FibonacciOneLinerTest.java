package ro.esolacad.javaad.lab;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FibonacciOneLinerTest {

    @Test
    public void testOneLiner() {
        assert Arrays.asList(0L, 1L, 1L, 2L, 3L)
                .equals(FibonacciOneLiner.getFibonacciList(5));

        assert Arrays.asList(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L)
                .equals(FibonacciOneLiner.getFibonacciList(8));
    }
}
