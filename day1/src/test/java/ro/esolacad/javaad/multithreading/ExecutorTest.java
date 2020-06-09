package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ExecutorTest {

    @Test
    public void testExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new PrimeRunnable(100));
        executorService.execute(new PrimeRunnable(500));
        executorService.execute(new PrimeRunnable(700));
        executorService.execute(new PrimeRunnable(900));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCallable() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Long> longFuture = executorService.submit(new PrimeCallable(400));

        while(!longFuture.isDone()) {}

        try {
            assert longFuture.get() == 401;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    @Test
    public void testCancelFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Long> longFuture = executorService.submit(new PrimeCallable(400));

        longFuture.cancel(true);

        assert longFuture.isCancelled() == true;
    }

    @Test
    public void scheduledExecutor() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        scheduledExecutorService.schedule(new PrimeCallable(100), 3, TimeUnit.SECONDS);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThreadLocal() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                NumberHolder.getNextAtomicInt();

                System.out.println("Current id for thread " + NumberHolder.ID_HOLDER.get() +
                        " thread: " + Thread.currentThread().getName());
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
