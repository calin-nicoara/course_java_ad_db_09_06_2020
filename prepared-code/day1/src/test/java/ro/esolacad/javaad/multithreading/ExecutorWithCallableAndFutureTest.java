package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ro.esolacad.javaad.util.ThreadUtil;

public class ExecutorWithCallableAndFutureTest {

    @Test
    public void testCallableAndFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<Long> future = executorService.submit(new PrimeCallable(400, 2000));

        while(!future.isDone()) {}

        try {
            assert future.get() == 1999;
        } catch (InterruptedException | ExecutionException e) {
            assert false;
        }
    }

    @Test
    public void testCancellingFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<Long> future = executorService.submit(new PrimeCallable(400, 2000));

        future.cancel(true);

        while(!future.isDone()) {}

        try {
            future.get();
            assert false;
        } catch (Exception e) {
            e.printStackTrace();
            assert true;
        }
    }

    @Test
    public void testTwoFuturesWithSingleThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Long> future1 = executorService.submit(new PrimeCallable(400, 2000));
        Future<Long> future2 = executorService.submit(new PrimeCallable(100, 300));

        while(!future1.isDone() || !future2.isDone()) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );

            ThreadUtil.sleep(300);
        }

        try {
            assert future1.get() == 1999L;
            assert future2.get() == 293L;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
