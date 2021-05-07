package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);


        HashSet<Object> objects = new HashSet<>();



        Stream.of("A", "B", "C")
                .collect(Collectors.joining(",","[","]"));
    }


}

