package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import ro.esolacad.javaad.util.ThreadUtil;

public class ScheduledExecutorTest {

    @Test
    public void testScheduledExecutorService() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        ScheduledFuture<Long> schedule = scheduledExecutorService
                .schedule(new PrimeCallable(100, 3000), 1, TimeUnit.SECONDS);

        try {
            assert 2999L == schedule.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPeriodicExecution() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(
                new PrimeRunnable(5, 100),
                1, 2, TimeUnit.SECONDS);

        ThreadUtil.sleep(6000);

        scheduledFuture.cancel(true);
        System.out.println("Intrerupted");

        ThreadUtil.sleep(6000);
    }
}
