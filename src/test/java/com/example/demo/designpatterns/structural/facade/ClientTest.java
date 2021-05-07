package com.example.demo.designpatterns.structural.facade;

import org.junit.jupiter.api.Test;

public class ClientTest {
    @Test
    void createProductFeature() {
        FacadeService facadeService = new FacadeService();
        facadeService.createFeature();
    }
}
