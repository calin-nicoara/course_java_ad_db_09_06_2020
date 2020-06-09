package ro.esolacad.javaad.multithreading;

import java.util.Random;

public class PrimeThreadCalculator extends Thread{

    PrimeCalculator primeCalculator;

    public PrimeThreadCalculator(long number) {
        primeCalculator = new PrimeCalculator(number);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread for prime calculator: " + Thread.currentThread().getName());
        System.out.println(primeCalculator.getNextPrime());
    }
}
