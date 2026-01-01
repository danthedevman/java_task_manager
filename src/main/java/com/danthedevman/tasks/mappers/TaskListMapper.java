package com.danthedevman.tasks.mappers;

import com.danthedevman.tasks.domain.dto.TaskListDto;
import com.danthedevman.tasks.domain.dto.UpdateTaskListDto;
import com.danthedevman.tasks.domain.entities.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto tasklistDto);
    TaskListDto toDto(TaskList taskList);
    void updateEntityFromDto(UpdateTaskListDto dto, TaskList taskList);
}
