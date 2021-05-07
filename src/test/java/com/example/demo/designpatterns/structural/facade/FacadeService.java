package com.example.demo.designpatterns.structural.facade;

public class FacadeService {

    private final AnalyticalService analyticalService = new AnalyticalService();
    private final GitService gitService = new GitService();
    private final JiraService jiraService = new JiraService();
    private final QaService qaService = new QaService();
    private final DeployService deployService = new DeployService();

    void createFeature() {
        analyticalService.collectRequirements();
        int taskId = jiraService.createTask();

        boolean testPassed = false;

        while (!testPassed) {
            gitService.pushChanges();
            deployService.deployBuild();
            testPassed = qaService.testBuild();
        }

        jiraService.completeTask(taskId);
    }

}
