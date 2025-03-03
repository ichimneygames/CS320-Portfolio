package org.snhu.cs320.task;

public class Task {
    private final String taskId;
    private String TaskName;
    private String TaskDescription;

    
    //task invalid tests
    public Task(String taskId, String TaskName, String TaskDescription) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid ID for Task");
        }
        if (TaskName == null || TaskName.length() > 20) {
            throw new IllegalArgumentException("Invalid Name for Task");
        }
        if (TaskDescription == null || TaskDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid Description for Task");
        }
        this.taskId = taskId;
        this.TaskName = TaskName;
        this.TaskDescription = TaskDescription;
    }
//get task id
    public String getTaskId() {
        return taskId;
    }
//get task name
    public String getTaskName() {
        return TaskName;
    }
//invalid name
    public void setTaskName(String TaskName) {
        if (TaskName == null || TaskName.length() > 20) {
            throw new IllegalArgumentException("Invalid Name for Task");
        }
        this.TaskName = TaskName;
    }

    public String getTaskDescription() {
        return TaskDescription;
    }
//invalid description
    public void setTaskDescription(String TaskDescription) {
        if (TaskDescription == null || TaskDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid Description for Task");
        }
        this.TaskDescription = TaskDescription;
    }
}