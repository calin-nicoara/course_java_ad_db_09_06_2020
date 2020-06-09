package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import java.lang.management.ThreadInfo;

import static org.junit.jupiter.api.Assertions.*;

class PrimeCalculatorTest {

    @Test
    public void testPrime() {
        PrimeCalculator primeCalculator = new PrimeCalculator(20);

        assert primeCalculator.getNextPrime() == 23;

        PrimeCalculator secondPrimeCalculator = new PrimeCalculator(40);

        assert secondPrimeCalculator.getNextPrime() == 41;
    }

    @Test
    public void testFirstThread() {
        Thread firstThread = new PrimeThreadCalculator(40);
        Thread thread2 = new PrimeThreadCalculator(70);
        Thread thread3 = new PrimeThreadCalculator(200);

        firstThread.start();
        thread2.start();
        thread3.start();

        System.out.println("This is on main thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRunnable() {
        Runnable runnable = new PrimeRunnable(400);

        Thread thread = new Thread(runnable);

        thread.start();

//        while(thread.isAlive()) {}

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All done!");
    }

    @Test
    public void testNotThreadSafe() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Integer nextNumber = NumberHolder.getNextInt();
                System.out.println("Number " + nextNumber + " from thread:" + Thread.currentThread().getName());
            }
        };

        for(int i = 0; i < 10000; i++) {
            new Thread(runnable).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(NumberHolder.getCurrentInt());
    }

    @Test
    public void testAtomicThreadSafe() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Integer nextNumber = NumberHolder.getNextAtomicInt();
                System.out.println("Number " + nextNumber + " from thread:" + Thread.currentThread().getName());
            }
        };

        for(int i = 0; i < 10000; i++) {
            new Thread(runnable).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(NumberHolder.getCurrentAtomicInt());
    }

    @Test
    public void testWaitAndNotify() {
        Runnable firstRunnable = new Runnable() {
            @Override
            public synchronized void run() {
                System.out.println("The first runnable is going");

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("I'm done waiting");
            }
        };

        Runnable secondRunnable = new Runnable() {
            @Override
            public synchronized void run() {
                System.out.println("This is the second runnable!");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                notifyAll();

                System.out.println("Second runnable done!");
            }
        };

        new Thread(firstRunnable).start();
        new Thread(secondRunnable).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThreadIntrerupt() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Thread was intrerupted");
                }
            }
        });

        thread.start();
        thread.interrupt();
    }
}
