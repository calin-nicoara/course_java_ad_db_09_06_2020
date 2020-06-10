package ro.esolacad.javaad.lambda;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {

    @Test
    public void testCompletableFuture() {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println(Thread.currentThread().getName());
                    return new Random().nextInt(1000);
                })
                .thenApplyAsync(x -> {
                    System.out.println(Thread.currentThread().getName());
                    return x + 100;
                });

        integerCompletableFuture.thenAccept(x -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("After future: " + x);
        });
    }

    @Test
    public void testGetCompletableFuture() {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        Integer join = integerCompletableFuture.join();

        assert join == 10;
    }

    @Test
    public void testComposeFuture() {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> 1)
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + 2));

        integerCompletableFuture.join();

        Integer now = integerCompletableFuture.getNow(0);
        assert now == 3;
    }

    @Test
    public void testAllCOmpleteFuture() {
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(
//                CompletableFuture.runAsync(() -> System.out.println("ASyn 1")),
//                CompletableFuture.runAsync(() -> System.out.println("ASyn 2")),
//                CompletableFuture.runAsync(() -> System.out.println("ASyn 3"))
//        );
//
//        voidCompletableFuture.join();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture.runAsync(() -> {
            System.out.println("Thread name " + Thread.currentThread().getName());
            System.out.println("Run async");
        }, executorService);
    }
}
