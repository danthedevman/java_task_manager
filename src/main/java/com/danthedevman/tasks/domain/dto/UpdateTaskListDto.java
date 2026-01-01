package com.danthedevman.tasks.domain.dto;

import java.util.List;

public record UpdateTaskListDto(String title,
                                String description,
                                Integer count,
                                Double progress,
                                List<TaskDto> tasks) {
}
