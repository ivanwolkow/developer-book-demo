package com.example.demo.java.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly;
import static java.lang.Thread.currentThread;

public class VisibilityProblemTest {

    @Test
    void visibilityTest() {
        MySharedObject mySharedObject = new MySharedObject();

        new Thread(() -> mySharedObject.waitForFlag(), "ReaderThread").start();

        sleepUninterruptibly(1, TimeUnit.SECONDS);
        System.out.println(currentThread().getName() + ": changing state of shared resource now");
        mySharedObject.flag = true;
        sleepUninterruptibly(10, TimeUnit.SECONDS);
    }

    static class MySharedObject {
        //volatile boolean flag = false;
        boolean flag = false;

        public void waitForFlag() {
            while (!flag) {}
            System.out.println(currentThread().getName() + ": other thread changed shared resource AND I CAN SEE IT");
        }
    }

}
