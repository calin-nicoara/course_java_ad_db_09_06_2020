package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ro.esolacad.javaad.util.ThreadUtil;

public class ExecutorWithRunnableTest {

    @Test
    public void testExecutorWithRunnable() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        runFiveRunnableOnExecutorService(executorService);

        // Next in line
        executorService.execute(new PrimeRunnable(400, 600));

        ThreadUtil.sleep(5000);
    }

    @Test
    public void testExecutorWithCachedPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        runFiveRunnableOnExecutorService(executorService);

        ThreadUtil.sleep(5000);
    }

    private void runFiveRunnableOnExecutorService(final ExecutorService executorService) {
        executorService.execute(new PrimeRunnable(3, 1000));
        executorService.execute(new PrimeRunnable(500, 2000));
        executorService.execute(new PrimeRunnable(50, 140));
        executorService.execute(new PrimeRunnable(45, 700));
        executorService.execute(new PrimeRunnable(400, 600));
    }
}
