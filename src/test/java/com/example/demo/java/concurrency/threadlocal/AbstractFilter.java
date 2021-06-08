package com.example.demo.java.concurrency.threadlocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractFilter {

    private final AbstractFilter neighbourFilter;

    public AbstractFilter(AbstractFilter filter) {
        this.neighbourFilter = filter;
    }

    abstract protected void doProcess(Request request, Response response);

    public void process(Request request, Response response) {
        if (neighbourFilter != null) {
            log.info("Filter {} delegating processing down the chain to {}", this.getClass().getSimpleName(),
                    neighbourFilter.getClass().getSimpleName());
            neighbourFilter.process(request, response);
        }

        log.info("Filter {} processing the request", this.getClass().getSimpleName());
        doProcess(request, response);
    }
}
