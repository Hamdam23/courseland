package com.courseland;

import com.courseland.lesson.Lesson;
import com.courseland.lesson.dtos.LessonResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface BaseMapper<Entity, RequestDTO, ResponseDTO> {
    Entity toEntity(RequestDTO dto);

    ResponseDTO toResponseDTO(Entity entity);

    void update(@MappingTarget Entity entity, RequestDTO DTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Entity entity, RequestDTO DTO);
}
