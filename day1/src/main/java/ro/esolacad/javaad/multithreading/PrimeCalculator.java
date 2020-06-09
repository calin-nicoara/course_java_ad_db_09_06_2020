package ro.esolacad.javaad.multithreading;

public class PrimeCalculator {

    private long number;

    public PrimeCalculator(long number) {
        this.number = number;
    }


    public long getNextPrime() {
        if(number == 0 || number == 1) {
            return 2;
        }

        long oddNumber = this.number % 2 == 0 ? this.number+1 : this.number;

        while(!isPrime(oddNumber)) {
            oddNumber+=2;
        }

        return oddNumber;
    }

    private boolean isPrime(final long numberToCheck) {
        if(numberToCheck % 2 == 0) {
            return false;
        }

        for(int divisor = 3; divisor <= Math.sqrt(numberToCheck); divisor += 2) {
            if(numberToCheck % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}
