package org.snhu.cs320.task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    //do easy ones first
    
    //test update for teask that doesnt exist
    @Test
    public void testUpdateNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTask("456", "New Task Name", "New Task Description"));
    }
    
    //test to delete task that doesnt exist
    @Test
    public void testDeleteNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("345"));
    }
    
    //test to add task
    
    @Test
    public void testAddTask() {
        Task task = new Task("123", "Test Task", "This is a test of task 123");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("123"));
    }
    
    //test to delete task
    
    @Test
    public void testDeleteTask() {
        Task task = new Task("789", "Task To Delete", "This task will be deleted");
        taskService.addTask(task);
        taskService.deleteTask("789");
        assertNull(taskService.getTask("789"));
    }

    // test to make sure you dont add the same tsak twice

    @Test
    public void testAddDuplicateTaskId() {
        Task task1 = new Task("901", "Task NineZeroOne", "Task 901");
        Task task2 = new Task("901", "Task FourFiveSix", "Task 456");
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
    }
    
//test to update test

    @Test
    public void testUpdateTask() {
        Task task = new Task("678", "Initial Name", "Initial Description");
        taskService.addTask(task);
        taskService.updateTask("678", "Updated task Name", "Updated task Description");
        assertEquals("Updated task Name", taskService.getTask("678").getTaskName());
        assertEquals("Updated task Description", taskService.getTask("678").getTaskDescription());
    }
    

    
}
