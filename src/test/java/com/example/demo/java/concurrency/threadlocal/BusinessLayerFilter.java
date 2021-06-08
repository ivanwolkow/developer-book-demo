package com.example.demo.java.concurrency.threadlocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BusinessLayerFilter extends AbstractFilter {
    public BusinessLayerFilter(AbstractFilter filter) {
        super(filter);
    }

    @Override
    protected void doProcess(Request request, Response response) {
        String data = request.getData();
        String username = CustomContextHolder.loadUserName();

        log.info("Handling request for user {} which sent data: {}", username, data);
        response.setData(username);
    }
}
