package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ro.esolacad.javaad.util.ThreadUtil;

public class ThreadLocalTest {

    @Test
    public void testThreadLocal() {
        Runnable threadLocalRunnable = new Runnable() {
            @Override
            public void run() {
                Integer oldId = ThreadLocalExample.getThreadId();
                ThreadLocalExample.setNewThreadId();
                System.out.println("Thread id: " + ThreadLocalExample.getThreadId() + " for thread " +
                        Thread.currentThread().getName() + " old id: " + oldId);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            executorService.execute(threadLocalRunnable);
        }

        ThreadUtil.sleep(2000);

        assert ThreadLocalExample.getLastIdGenerated() == 10;
        assert ThreadLocalExample.getThreadId() == null;
    }

    @Test
    public void testSimpleThreadLocal() {
        ThreadLocal<Long> threadLocal = new ThreadLocal<>();

        threadLocal.set(100L);
        System.out.println(threadLocal.get());
    }
}
