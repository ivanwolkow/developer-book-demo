package com.example.demo.designpatterns.structural.composite;

import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    void compositePatternTest() {
        CompositeWorkingUnit team1 = new CompositeWorkingUnit("new team");
        team1.add(new Developer("Junior developer 1"));
        team1.add(new Developer("Junior developer 2"));
        team1.add(new QaEngineer("QA Manual 1"));

        CompositeWorkingUnit team2 = new CompositeWorkingUnit("skilled team");
        team2.add(new Developer("Senior developer 1"));
        team2.add(new QaEngineer("QA Automation 1"));

        CompositeWorkingUnit department = new CompositeWorkingUnit("it department");
        department.add(team1);
        department.add(team2);

        department.doJob();
    }
}
