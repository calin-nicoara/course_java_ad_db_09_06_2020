package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

import ro.esolacad.javaad.util.ThreadUtil;

class AtomicExampleTest {

    @Test
    public void testAtomicInt() {
        Runnable testAtomicRunnable = new Runnable() {
            @Override
            public void run() {
                Integer nextNumber = new AtomicExample().getNextAtomicInt();
                System.out.println("Number " + nextNumber + " from thread: " + Thread.currentThread().getName());
            }
        };

        for(int i = 0; i < 10000; i++) {
            new Thread(testAtomicRunnable).start();
        }

        ThreadUtil.sleep(4000);

        assert AtomicExample.getAtomicInt() == 10000;
    }

    @Test
    public void testNormalInt() {
        Runnable testAtomicRunnable = new Runnable() {
            @Override
            public void run() {
                Integer nextNumber = new AtomicExample().getNextInt();
                System.out.println("Number " + nextNumber + " from thread: " + Thread.currentThread().getName());
            }
        };

        for (int i = 0; i < 10000; i++) {
            new Thread(testAtomicRunnable).start();
        }

        ThreadUtil.sleep(4000);

        assert AtomicExample.getInt() != 10000;
    }

    @Test
    public void simpleAtomicLong() {
        AtomicLong atomicLong = new AtomicLong();

        atomicLong.get();
        atomicLong.addAndGet(15L);
        atomicLong.incrementAndGet();
        atomicLong.incrementAndGet();
        atomicLong.set(100L);
    }
}
