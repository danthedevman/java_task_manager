package com.danthedevman.tasks.services.impl;

import com.danthedevman.tasks.domain.dto.UpdateTaskListDto;
import com.danthedevman.tasks.domain.entities.TaskList;
import com.danthedevman.tasks.mappers.TaskListMapper;
import com.danthedevman.tasks.repositories.TaskListRepository;
import com.danthedevman.tasks.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;
    private final TaskListMapper taskListMapper;

    public TaskListServiceImpl(TaskListRepository taskListRepository, TaskListMapper taskListMapper) {
        this.taskListRepository = taskListRepository;
        this.taskListMapper = taskListMapper;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        if (taskList.getId() != null) {
            throw new IllegalArgumentException("Task list is already defined!");
        }

        if (taskList.getTitle() == null || taskList.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task list title cannot be blank!");
        }

        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));
    }

    @Override
    public Optional<TaskList> getTaskList(UUID id) {
        return taskListRepository.findById(id);
    }

    @Override
    public TaskList updateTaskList(UUID taskListId, UpdateTaskListDto dto) {
        TaskList existing = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new IllegalArgumentException("Task list not found!"));

        // Apply updates (no id involved)
        taskListMapper.updateEntityFromDto(dto, existing);

        existing.setUpdated(LocalDateTime.now());

        // (optional) validate title if your API requires it for PUT
        if (existing.getTitle() == null || existing.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task list title cannot be blank!");
        }

        return taskListRepository.save(existing);
    }

    @Override
    public void deleteTaskList(UUID taskListId) {
        taskListRepository.deleteById(taskListId);
    }
}
