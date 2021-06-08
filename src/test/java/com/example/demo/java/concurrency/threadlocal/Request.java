package com.example.demo.java.concurrency.threadlocal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {
    private String username;
    private String password;
    private String data;
}
