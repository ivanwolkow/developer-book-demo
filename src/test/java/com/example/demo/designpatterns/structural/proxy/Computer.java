package com.example.demo.designpatterns.structural.proxy;

import java.util.List;

public interface Computer {

    List<String> getDirectoryContent(String dir);

    void reboot();
}
