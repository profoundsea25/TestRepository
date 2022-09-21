package com.example.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Slf4j
public class FutureTest {

    @Test
    void futureTest() {
        CompletableFuture.supplyAsync(this::testMethod)
                .thenApply(Integer::parseInt)
                .completeExceptionally(new Exception("dd"));
    }

    @Test
    void threadTest() {
        CompletableFuture<String> future = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(3000);
//            future.cancel(false);
            future.complete("Finished");
            return null;
        });
    }

    private String testMethod() {
        log.info("testMethod sleeps soon");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "this is test";
    }
}
