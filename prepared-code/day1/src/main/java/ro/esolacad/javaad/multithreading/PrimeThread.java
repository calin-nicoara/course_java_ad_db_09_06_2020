package ro.esolacad.javaad.multithreading;

/**
 * Example of using Thread. Most basic way of using multithreading in java
 * We override the run method to add the actual behavior that takes place
 * when a Thread is ran.
 * In order to actually run the code on a different method the start() method
 * needs to be used. Using the run() will run the code, but in the current thread
 * where this method is ran (ex. the main thread)
 */
class PrimeThread extends Thread {
    PrimeCalculator primeCalculator;

    PrimeThread(long minPrime, long maxLimit) {
        this.primeCalculator = new PrimeCalculator(minPrime, maxLimit);
    }

    public long getMinPrime() {
        return primeCalculator.getPrime();
    }

    @Override
    public void run() {
        this.primeCalculator.computeBiggerPrime();
    }

}
