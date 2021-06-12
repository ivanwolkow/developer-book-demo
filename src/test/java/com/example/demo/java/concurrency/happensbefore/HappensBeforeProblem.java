package com.example.demo.java.concurrency.happensbefore;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class HappensBeforeProblem {

    public static class StateContainer {
        public int a = 0;
        public int b = 0;
        public int r1 = 0;
        public int r2 = 0;
    }

    /**
     * It may appear that reading "1" from s.b happens after s.r1 is set.
     * However, compilers are allowed to reorder the instructions in either thread,
     * when this does not affect the execution of that thread in isolation.
     * So in fact s.r1=s.a might happen after reading "1" from s.b!
     *
     * Expected result: (s.a==2 and s.b==1) is never true
     * Actual result: it is allowed for the compiler to reorder statements so that (s.a==2 and s.b==1) is true
     *
     * Happens-before guarantee can be achieved by following means:
     * - An unlock on a monitor happens-before every subsequent lock on that monitor.
     * - A write to a volatile field happens-before every subsequent read of that field.
     * - A call to start() on a thread happens-before any actions in the started thread.
     * - All actions in a thread happen-before any other thread successfully returns from a join() on that thread.
     * - The default initialization of any object happens-before any other actions (other than default-writes) of a program.
     */
    @Test
    @SneakyThrows
    void test() {

        StateContainer s = new StateContainer();

        Thread thread1 = new Thread(() -> {
            s.r1 = s.a;
            s.b = 1;
        });

        Thread thread2 = new Thread(() -> {
            s.r2 = s.b;
            s.a = 2;
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(s.a);
        System.out.println(s.b);
    }
}
