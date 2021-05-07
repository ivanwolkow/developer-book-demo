package com.example.demo.designpatterns.structural.proxy;

import java.util.List;

public class LocalComputer implements Computer{

    @Override
    public List<String> getDirectoryContent(String dir) {
        System.out.printf("Running command in terminal 'ls %s'\n", dir);
        return List.of("localfile1.txt", "localfile2.txt");
    }

    @Override
    public void reboot() {
        System.out.print("Running command in terminal 'reboot'\n");
    }
}
