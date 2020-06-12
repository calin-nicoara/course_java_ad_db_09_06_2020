package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import ro.esolacad.javaad.util.ThreadUtil;

public class CompletableFutureTest {

    @Test
    public void testThenAccept() {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture
                .supplyAsync(() -> new Random().nextInt(1000))
                .thenApply(a -> a + 100);

        integerCompletableFuture.thenAccept(System.out::println);
    }

    @Test
    public void testGetNowWithSleep() {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture
                .supplyAsync(() -> 20)
                .thenApply(a -> {
                    ThreadUtil.sleep(1000);
                    return a + 100;
                });

        Integer now = integerCompletableFuture.getNow(200);

        assert now == 200;
    }

    @Test
    public void testGetNow() {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture
                .supplyAsync(() -> 20)
                .thenApply(a -> a + 100);

        Integer now = integerCompletableFuture.getNow(200);

        assert now == 120;
    }

    @Test
    public void testJoin() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            ThreadUtil.sleep(500);
            completableFuture.complete("Hello");
        });

        String join = completableFuture.join();

        assert join.equals("Hello");
    }

    @Test
    public void testComposeFutures() {
        CompletableFuture<Integer> composedFutures = CompletableFuture.supplyAsync(() -> 1)
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + 2));

        composedFutures.join();
        assert 3 == composedFutures.getNow(0);
    }

    @Test
    public void testCombineFutures() {
        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(() -> "World"),
                        (result1, result2) -> result1 + " " + result2);

        helloFuture.join();

        assert "Hello World".equals(helloFuture.getNow(null));
    }

}
