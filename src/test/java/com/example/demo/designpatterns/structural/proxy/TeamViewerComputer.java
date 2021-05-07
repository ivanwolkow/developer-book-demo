package com.example.demo.designpatterns.structural.proxy;

import java.util.List;
import java.util.function.Supplier;

/*
    Remote proxy implementation which doesn't delegate to "original" object
 */
public class TeamViewerComputer implements Computer{

    private final String hostPort;
    private final String credentials;

    public TeamViewerComputer(String hostPort, String credentials) {
        this.hostPort = hostPort;
        this.credentials = credentials;
    }

    @Override
    public List<String> getDirectoryContent(String dir) {
        List<String> response = sendTeamViewerCommand(() -> {
            System.out.printf("Sending TeamViewer command over TCP: teamviewer.getdircontent(%s)\n", dir);
            return List.of("remotefile1.txt", "remotefile2.txt");
        });

        return response;
    }

    @Override
    public void reboot() {
        sendTeamViewerCommand(() -> {
            System.out.println("Sending TeamViewer command over TCP: teamviewer.reboot()");
            return null;
        });
    }

    private <T> T sendTeamViewerCommand(Supplier<T> supplier) {
        System.out.printf("Opening TeamViewer remote connection to %s with credentials [SECRET]\n", hostPort);
        T result = supplier.get();
        System.out.println("Receiving TeamViewer response");
        System.out.print("Closing TeamViewer connection\n");
        return result;
    }
}
