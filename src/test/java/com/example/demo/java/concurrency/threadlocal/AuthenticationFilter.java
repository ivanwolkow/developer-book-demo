package com.example.demo.java.concurrency.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;

@Slf4j
public class AuthenticationFilter extends AbstractFilter {
    public AuthenticationFilter(AbstractFilter filter) {
        super(filter);
    }

    @Override
    protected void doProcess(Request request, Response response) {
        if (StringUtils.isBlank(request.getUsername()) || StringUtils.isBlank(request.getPassword())) {
            throw new RuntimeException("Bad credentials for user " + request.getUsername());
        }

        if (request.getUsername().contains("admin") && request.getPassword().contains("qwerty")) {
            log.info("Successfully authenticated!");
            CustomContextHolder.saveUserName(request.getUsername());
        }

    }
}
