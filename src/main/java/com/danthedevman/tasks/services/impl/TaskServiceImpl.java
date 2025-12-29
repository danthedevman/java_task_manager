package com.danthedevman.tasks.services.impl;

import com.danthedevman.tasks.domain.entities.Task;
import com.danthedevman.tasks.repositories.TaskRepository;
import com.danthedevman.tasks.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }
}
