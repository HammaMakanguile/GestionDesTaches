package com.example.taskmanager.services;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task getTaskById(Long id);
    List<Task> getAllTask();

    Task updateTask(Task task);

    void deleteTask(Long id);

}
