package org.snhu.cs320.task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        for (Task t : taskList) {
            if (t.getTaskId().equals(task.getTaskId())) {
                throw new IllegalArgumentException("Task ID already exists"); //id already exists for task
            }
        }
        taskList.add(task);
    }
//delete
    public void deleteTask(String taskId) {
        Task taskToRemove = null;
        for (Task t : taskList) {
            if (t.getTaskId().equals(taskId)) {
                taskToRemove = t;
                break;
            }
        }
        if (taskToRemove == null) {
            throw new IllegalArgumentException("Task ID not found");
        }
        taskList.remove(taskToRemove);
    }
//update
    public void updateTask(String taskId, String name, String description) {
        for (Task t : taskList) {
            if (t.getTaskId().equals(taskId)) {
                t.setTaskName(name);
                t.setTaskDescription(description);
                return;
            }
        }
        throw new IllegalArgumentException("Task ID not found");
    }
//get task
    public Task getTask(String taskId) {
        for (Task t : taskList) {
            if (t.getTaskId().equals(taskId)) {
                return t;
            }
        }
        return null;
    }
}
