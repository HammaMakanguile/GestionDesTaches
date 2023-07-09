package com.example.taskmanager.services;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl (TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task) ;
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Tache introuvable"+id));
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task task) {
        if (task.getId() != null){
            return taskRepository.save(task) ;

        }else {
            throw new IllegalArgumentException("Id Tache Invalide");
        }
    }

    @Override
    public void deleteTask(Long id) {
       Task task = taskRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Tache Introuvable"));
       taskRepository.delete(task);

    }
}
