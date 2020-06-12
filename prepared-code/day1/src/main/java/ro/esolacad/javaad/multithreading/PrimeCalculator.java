package ro.esolacad.javaad.multithreading;

import ro.esolacad.javaad.util.ThreadUtil;

class PrimeCalculator {

    long minLimit;
    long maxLimit;
    long currentPrime = 3;

    public PrimeCalculator(final long minLimit, final long maxLimit) {
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.currentPrime = minLimit % 2 == 0 ? minLimit+1 : minLimit;
    }

    public long getPrime() {
        return currentPrime;
    }

    public void computeBiggerPrime() {
        ThreadUtil.sleep(5);

        long newPrime = getNextPrime(this.currentPrime);

        if(newPrime > maxLimit) {
            System.out.println("Found max prime: " + this.currentPrime +
                    " from " + Thread.currentThread().getName());
            return;
        }

        this.currentPrime = newPrime;

        computeBiggerPrime();
    }

    private long getNextPrime(final long currentPrime) {
        long newPrime = currentPrime+2;

        while(!isPrime(newPrime)) {
            newPrime += 2;
        }

        return newPrime;
    }

    private boolean isPrime(final long numberToCheck) {
        if(numberToCheck % 2 == 0) {
            return false;
        }

        for(int i = 3; i <= Math.sqrt(numberToCheck); i+=2) {
            if(numberToCheck % i == 0) {
                return false;
            }
        }
        return true;
    }
}
