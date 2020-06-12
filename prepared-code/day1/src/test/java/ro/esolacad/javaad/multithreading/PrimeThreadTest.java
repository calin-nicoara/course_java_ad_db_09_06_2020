package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import ro.esolacad.javaad.util.ThreadUtil;

class PrimeThreadTest {

    @Test
    public void testPrimeThread() {
        int maxLimit = 1000;
        PrimeThread primeThread = new PrimeThread(7, maxLimit);
        primeThread.start();

        System.out.println("This is on the main thread");

        ThreadUtil.sleep(100);
        System.out.println("Current prime: " + primeThread.getMinPrime());

        while (primeThread.isAlive()) {

        }

        assert primeThread.getMinPrime() == 997L;
    }

}
