package com.example.demo.java.functional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    void optionalTest() {

        Optional<String> notNullOptional = Optional.of("im not null");
        Assertions.assertTrue(notNullOptional.isPresent());

        Optional<Object> nullPassedOptional = Optional.ofNullable(null);
        Assertions.assertTrue(nullPassedOptional.isEmpty());

        Optional<Object> emptyOptional = Optional.empty();
        Assertions.assertTrue(nullPassedOptional.isEmpty());

        notNullOptional.map(s -> s.substring(0, 2))
                .ifPresent(System.out::println);

        Object orElse = emptyOptional.orElse("default");
        Object orElseGet = emptyOptional.orElseGet(this::loadFromSomewhere);

        String value = notNullOptional
                .filter(s -> s.contains("im"))
                .map(s -> s.substring(0, 5))
                .orElseThrow(() -> new RuntimeException("value with 'im' is not present!"));
    }

    String loadFromSomewhere() {
        return "loaded from somewhere";
    }
}
