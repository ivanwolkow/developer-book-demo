package com.example.demo.java.concurrency.threadlocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomContextHolder {
    private static final ThreadLocal<String> username = new ThreadLocal<>();

    public static void saveUserName(String u) {
        log.info("Saving username {} to context ThreadLocal", u);
        username.set(u);
    }

    public static String loadUserName() {
        String u = username.get();
        log.info("Obtaining username from context ThreadLocal: {}", u);
        return u;
    }
}
