package ro.esolacad.javaad.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;

public class PrimeCallable implements Callable<Long> {

    PrimeCalculator primeCalculator;

    public PrimeCallable(long number) {
        primeCalculator = new PrimeCalculator(number);
    }

    @Override
    public Long call() throws Exception {
        System.out.println("Task started" + Thread.currentThread().getName());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread for prime runnable calculator: " + Thread.currentThread().getName());
        return primeCalculator.getNextPrime();
    }
}
