package ro.esolacad.javaad.multithreading;

import java.util.Random;

public class PrimeRunnable implements Runnable{

    PrimeCalculator primeCalculator;

    public PrimeRunnable(long number) {
        primeCalculator = new PrimeCalculator(number);
    }

    @Override
    public void run() {
        System.out.println("Task started" + Thread.currentThread().getName());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread for prime runnable calculator: " + Thread.currentThread().getName());
        System.out.println(primeCalculator.getNextPrime());
    }
}
