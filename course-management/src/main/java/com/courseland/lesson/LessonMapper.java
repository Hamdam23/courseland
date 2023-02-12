package com.courseland.lesson;

import com.courseland.BaseMapper;
import com.courseland.file.FileResponseDTO;
import com.courseland.lesson.dtos.LessonRequestDTO;
import com.courseland.lesson.dtos.LessonResponseDTO;
import com.courseland.user.AppUserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public abstract class LessonMapper implements BaseMapper<Lesson, LessonRequestDTO, LessonResponseDTO> {

    @Override
    abstract public Lesson toEntity(LessonRequestDTO lessonRequestDTO);

    @Override
    @Mapping(target = "course", ignore = true)
    @Mapping(target = "relatedResources", ignore = true)
    @Mapping(target = "studyMaterials", ignore = true)
    abstract public LessonResponseDTO toResponseDTO(Lesson lesson);
}
