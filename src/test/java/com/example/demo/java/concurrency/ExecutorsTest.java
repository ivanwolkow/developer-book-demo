package com.example.demo.java.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static com.google.common.util.concurrent.Uninterruptibles.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ExecutorsTest {

    @Test
    void customExecutor() {
        ThreadPoolExecutor ex = new ThreadPoolExecutor(4, 4, 0, SECONDS,
                new ArrayBlockingQueue<>(1000),
                Thread::new,
                (task, executor) -> putUninterruptibly(executor.getQueue(), task));
    }

    @Test
    void predefinedExecutorsTest() {

        ExecutorService fixedThreadPoolEx = Executors.newFixedThreadPool(8);
        CompletableFuture.runAsync(() -> System.out.println("Handled by fixedThreadPoolExecutor"));

        ExecutorService cachedThreadPoolEx = Executors.newCachedThreadPool();
        CompletableFuture.runAsync(() -> System.out.println("Handled by cachedThreadPoolExecutor"));

        ScheduledExecutorService scheduledEx = Executors.newScheduledThreadPool(4);
        scheduledEx.scheduleAtFixedRate(() -> System.out.println("Scheduled task"), 0, 1, SECONDS);

        ExecutorService singleThreadEx = Executors.newSingleThreadExecutor();
        CompletableFuture.runAsync(() -> System.out.println("Handled by a singleThreadExecutor"));

        sleepUninterruptibly(10, SECONDS);

        System.out.println("Shutting down...");
        shutdown(fixedThreadPoolEx, cachedThreadPoolEx, scheduledEx, singleThreadEx);
        awaitTermination(fixedThreadPoolEx, cachedThreadPoolEx, scheduledEx, singleThreadEx);
    }

    private void shutdown(ExecutorService ... executorServices) {
        for (ExecutorService ex : executorServices) {
            ex.shutdown();
        }
    }

    private void awaitTermination(ExecutorService ... executors) {
        for (ExecutorService ex: executors) {
            awaitTerminationUninterruptibly(ex);
        }
    }
}
