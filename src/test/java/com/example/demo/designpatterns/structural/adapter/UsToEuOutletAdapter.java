package com.example.demo.designpatterns.structural.adapter;

public class UsToEuOutletAdapter implements EuOutlet {

    private final UsOutlet usOutlet;

    public UsToEuOutletAdapter(UsOutlet usOutlet) {
        this.usOutlet = usOutlet;
    }

    @Override
    public String get220V() {
        String baseVoltage = usOutlet.get110V();
        return transformVoltage(baseVoltage);
    }

    private String transformVoltage(String sourceVoltage){
        if (!sourceVoltage.contains("110V")) {
            throw new RuntimeException("Bad voltage");
        }

        return sourceVoltage.replace("110V", "220V");
    }
}
