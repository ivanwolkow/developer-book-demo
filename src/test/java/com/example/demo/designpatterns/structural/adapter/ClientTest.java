package com.example.demo.designpatterns.structural.adapter;

import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    void name() {
        EuOutletImpl euOutlet = new EuOutletImpl();
        UsOutletImpl usOutlet = new UsOutletImpl();

        System.out.println("euOutlet: " + euOutlet.get220V());
        System.out.println("usOutlet: " + usOutlet.get110V());

        EuOutlet euOutletAdapter = new UsToEuOutletAdapter(usOutlet);
        System.out.println("using usOutlet as euOutlet: " + euOutletAdapter.get220V());
    }
}
