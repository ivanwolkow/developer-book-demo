package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsoleRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("Hi there!");
    }


}