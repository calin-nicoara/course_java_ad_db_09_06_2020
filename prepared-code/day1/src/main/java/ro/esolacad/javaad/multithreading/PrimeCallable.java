package ro.esolacad.javaad.multithreading;

import java.util.concurrent.Callable;

class PrimeCallable implements Callable<Long> {
    PrimeCalculator primeCalculator;

    PrimeCallable(long minLimit, long maxLimit) {
        this.primeCalculator = new PrimeCalculator(minLimit, maxLimit);
    }

    public long getMinPrime() {
        return primeCalculator.getPrime();
    }

    @Override
    public Long call() throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println("Started: " + threadName);
        this.primeCalculator.computeBiggerPrime();
        System.out.println("Stopped " + threadName);

        return this.primeCalculator.getPrime();
    }
}
