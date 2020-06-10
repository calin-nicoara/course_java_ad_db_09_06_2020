package ro.esolacad.javaad.multithreading;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberHolder {

    private static volatile int currentInt = 0;

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static final ThreadLocal<Integer> ID_HOLDER = new ThreadLocal<>();

    public static Integer getNextInt() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return currentInt++;
    }

    public static Integer getCurrentInt() {
        return currentInt;
    }

    public static Integer getNextAtomicInt() {
        ID_HOLDER.remove();
        System.out.println("Previous value: " + ID_HOLDER.get() + " thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ID_HOLDER.set(atomicInteger.get());
        return atomicInteger.getAndIncrement();
    }

    public static Integer getCurrentAtomicInt() {
        return atomicInteger.get();
    }

}
