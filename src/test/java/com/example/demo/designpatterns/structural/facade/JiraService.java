package com.example.demo.designpatterns.structural.facade;

public class JiraService {

    int createTask() {
        int id = 10;
        System.out.println("Jira: creating task with id = " + id);
        return id;
    }

    void completeTask(int id) {
        System.out.println("Jira: changing task status to DONE for task id = " + id);
    }
}
