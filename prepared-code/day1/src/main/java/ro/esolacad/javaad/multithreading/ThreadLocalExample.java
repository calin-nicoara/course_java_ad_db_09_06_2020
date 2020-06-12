package ro.esolacad.javaad.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

class ThreadLocalExample {

    private static final AtomicInteger idGenerator = new AtomicInteger();
    private static final ThreadLocal<Integer> threadId = new ThreadLocal<>();

    public static void setNewThreadId() {
        threadId.remove();
        threadId.set(idGenerator.incrementAndGet());
    }

    public static Integer getThreadId() {
        return threadId.get();
    }

    public static Integer getLastIdGenerated() {
        return idGenerator.get();
    }
}
