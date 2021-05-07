package com.example.demo.designpatterns.structural.proxy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    void remoteProxyTest() {
        System.out.println("Interacting with local computer:");
        Computer localComputer = new LocalComputer();
        List<String> localDirectoryContent = localComputer.getDirectoryContent("/etc");
        localComputer.reboot();

        System.out.println("\nInteracting with remote computer via TeamViewer:");
        Computer remoteComputer = new TeamViewerComputer("10.120.12.44:4242", "secret_token");
        List<String> remoteDirectoryContent = remoteComputer.getDirectoryContent("/var/lib");
        remoteComputer.reboot();

        assertEquals(localDirectoryContent, List.of("localfile1.txt", "localfile2.txt"));
        assertEquals(remoteDirectoryContent, List.of("remotefile1.txt", "remotefile2.txt"));
    }
}
