package ro.esolacad.javaad.multithreading;

/**
 * Example of Runnable interface implementation. Offers more flexibility than Threads because
 * of the use of an interface instead of extending a class. It can also be used with
 * other multi threading APIs from java like the ExecutorService interface.
 *
 * Same method to override as the Thread class: void run()
 */
class PrimeRunnable implements Runnable{
    PrimeCalculator primeCalculator;

    PrimeRunnable(long minLimit, long maxLimit) {
        this.primeCalculator = new PrimeCalculator(minLimit, maxLimit);
    }

    public long getMinPrime() {
        return primeCalculator.getPrime();
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Started: " + threadName);
        this.primeCalculator.computeBiggerPrime();
        System.out.println("Stopped " + threadName);
    }
}
