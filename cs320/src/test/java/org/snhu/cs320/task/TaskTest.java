package org.snhu.cs320.task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {
	//task create test
    @Test
    public void testTaskCreation() {
        Task task = new Task("123", "Test Task", "This is a task test");
        assertEquals("123", task.getTaskId());
        assertEquals("Test Task", task.getTaskName());
        assertEquals("This is a task test", task.getTaskDescription());
    }
//task name test
    @Test
    public void testTaskNameValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("456", null, "Description is under 50");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("456", "TaskNameTaskNameTaskName", "Description is under 50");
        });
    }
//task description test
    @Test
    public void testTaskDescriptionValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("789", "Name is Valid", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("789", "Name is Valid", "TaskDescriptionTaskDescriptionTaskDescriptionTaskDescription");
        });
    }
}
