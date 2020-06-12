package ro.esolacad.javaad.multithreading;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import ro.esolacad.javaad.util.ThreadUtil;

class AtomicExample {

    private static final AtomicInteger nextAtomicInt = new AtomicInteger(0);
    private static int nextInt = 0;

    public static Integer getAtomicInt() {
        return nextAtomicInt.get();
    }

    public static Integer getInt() {
        return nextInt;
    }

    public Integer getNextAtomicInt() {
        ThreadUtil.sleep(new Random().nextInt(1000));

        return nextAtomicInt.incrementAndGet();
    }

    public Integer getNextInt() {
        ThreadUtil.sleep(new Random().nextInt(1000));

        return ++nextInt;
    }
}
