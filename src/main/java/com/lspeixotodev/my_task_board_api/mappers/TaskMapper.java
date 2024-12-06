package com.lspeixotodev.my_task_board_api.mappers;

import com.lspeixotodev.my_task_board_api.dtos.TaskDTO;
import com.lspeixotodev.my_task_board_api.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "categoryId", expression = "java(entity.getCategory().getId() != null ? entity.getCategory().getId().toString() : null)")
    TaskDTO entityToDTO(Task entity);

    Task dtoToEntity(TaskDTO dto);

    List<TaskDTO> entitiesToDtos(List<Task> entities);

    List<Task> dtosToEntities(List<TaskDTO> dtos);
}
