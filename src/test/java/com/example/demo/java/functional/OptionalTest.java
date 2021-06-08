package com.example.demo.java.functional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptionalTest {

    @Test
    void optionalTest() {

        Optional<String> notNullOptional = Optional.of("im not null");
        assertTrue(notNullOptional.isPresent());

        Optional<Object> nullPassedOptional = Optional.ofNullable(null);
        assertTrue(nullPassedOptional.isEmpty());

        Optional<Object> emptyOptional = Optional.empty();
        assertTrue(nullPassedOptional.isEmpty());

        notNullOptional.map(s -> s.substring(0, 2))
                .ifPresent(System.out::println);

        Object orElse = emptyOptional.orElse("default");
        assertEquals("default", orElse);

        //loadFromSomewhere will run only if optional is empty
        Object orElseGet = emptyOptional.orElseGet(this::loadFromSomewhere);
        assertEquals("loaded from somewhere", orElseGet);

        String value = notNullOptional
                .filter(s -> s.contains("im"))
                .map(s -> s.substring(0, 5))
                .orElseThrow(() -> new RuntimeException("value with 'im' is not present!"));
        assertEquals("im no", value);
    }

    String loadFromSomewhere() {
        return "loaded from somewhere";
    }
}
