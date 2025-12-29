package com.danthedevman.tasks.services;

import com.danthedevman.tasks.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<Task> listTasks(UUID taskListId);
}
