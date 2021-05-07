package com.example.demo.java.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.google.common.util.concurrent.Uninterruptibles.joinUninterruptibly;

public class AtomicityProblemTest {

    @Test
    void atomicityProblemTest() {
        var mySharedObject = new MySharedObject1();
        Thread thread = new Thread(mySharedObject);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            mySharedObject.doReadWriteOnSharedResource();
        }

        joinUninterruptibly(thread);
        System.out.println("Result: " + mySharedObject.cnt);
    }

    class MySharedObject1 implements Runnable {
        //AtomicInteger cnt = new AtomicInteger(0);
        int cnt;

        //synchronized void doReadWriteOnSharedResource() {
        void doReadWriteOnSharedResource() {
            cnt++;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                doReadWriteOnSharedResource();
            }
        }
    }

    class MySharedObject2 implements Runnable {
        int cnt = 0;
        Lock lock = new ReentrantLock();

        void doReadWriteOnSharedResource() {
            lock.lock();
            try {
                cnt++;
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                doReadWriteOnSharedResource();
            }
        }
    }
}
