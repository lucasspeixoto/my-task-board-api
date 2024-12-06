package com.lspeixotodev.my_task_board_api.mappers;


import com.lspeixotodev.my_task_board_api.dtos.CategoryDTO;
import com.lspeixotodev.my_task_board_api.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION
)
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    CategoryDTO entityToDTO(Category entity);

    @Mapping(target = "id", expression = "java(dto.getId() != null ? java.util.UUID.fromString(dto.getId()) : null)")
    Category dtoToEntity(CategoryDTO dto);

    List<CategoryDTO> entitiesToDtos(List<Category> entities);

    List<Category> dtosToEntities(List<CategoryDTO> dtos);
}
