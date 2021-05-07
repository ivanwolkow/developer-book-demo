package com.example.demo.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CompositeWorkingUnit extends AbstractWorkingUnit {
    private List<WorkingUnit> workingUnits = new ArrayList<>();

    public CompositeWorkingUnit(String name) {
        super(name);
    }

    public void add(WorkingUnit unit) {
        this.workingUnits.add(unit);
    }

    public void add(Collection<WorkingUnit> units) {
        this.workingUnits.addAll(units);
    }

    @Override
    public void doJob() {
        System.out.println(name + ": making product");
        for (WorkingUnit unit : workingUnits) {
            unit.doJob();
        }
    }
}
