package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import ro.esolacad.javaad.util.ThreadUtil;

class PrimeRunnableTest {

    @Test
    public void primeRunnableTest() {
        int maxLimit = 1000;
        PrimeRunnable primeRunnable = new PrimeRunnable(7, maxLimit);

        Thread thread = new Thread(primeRunnable);
        thread.start();

        System.out.println("This is on the main thread");
        ThreadUtil.sleep(100);
        System.out.println("Current prime: " + primeRunnable.getMinPrime());

        while (thread.isAlive()) {

        }

        assert primeRunnable.getMinPrime() == 997L;
    }

}
