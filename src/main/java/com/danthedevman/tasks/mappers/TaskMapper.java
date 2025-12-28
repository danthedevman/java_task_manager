package com.danthedevman.tasks.mappers;

import com.danthedevman.tasks.domain.dto.TaskDto;
import com.danthedevman.tasks.domain.entities.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
