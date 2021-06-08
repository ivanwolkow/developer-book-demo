package com.example.demo.java.concurrency.threadlocal;

import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * This is a simplistic implementation of how web application request could be processed.
 * It uses a ThreadLocal variable to store and access an authentication data within a processing thread.
 * This implementation is potentially vulnerable to data leaking: the application can borrow the same thread
 * to process another request. When using thread pools always take care of clearing ThreadLocal variables!
 */
public class ClientTest {

    @SuppressWarnings("UnstableApiUsage")
    @Test
    void threadLocalTest() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        AbstractFilter filterChain = new BusinessLayerFilter(new AuthenticationFilter(null));

        Response firstResponse = new Response();
        executor.submit(() -> filterChain.process(
                new Request("Ivan_admin", "12345qwerty", "Ivan's request"),
                firstResponse));

        Response secondResponse = new Response();
        executor.submit(() -> filterChain.process(
                new Request("John_admin", "qwerty12345", "John's request"),
                secondResponse));

        executor.shutdown();
        Uninterruptibles.awaitTerminationUninterruptibly(executor);

        assertEquals("Ivan_admin", firstResponse.getData());
        assertEquals("John_admin", secondResponse.getData());
        assertNull(CustomContextHolder.loadUserName());
    }
}
