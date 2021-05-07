package com.example.demo.designpatterns.structural.bridge;

import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    void bridgeTest() {

        ItDepartment itDepartment1 = new ItDepartment(new JuniorDeveloper());
        ItDepartment itDepartment2 = new ItDepartment(new SeniorDeveloper());

        System.out.println("IT Department 1: ");
        itDepartment1.doJob();

        System.out.println("IT Department 2: ");
        itDepartment2.doJob();
    }
}
