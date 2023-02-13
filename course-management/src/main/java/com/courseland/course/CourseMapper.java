package com.courseland.course;

import com.courseland.BaseMapper;
import com.courseland.course.dtos.CourseRequestDTO;
import com.courseland.course.dtos.CourseResponseDTO;
import com.courseland.lesson.LessonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = LessonMapper.class
)
public abstract class CourseMapper implements BaseMapper<Course, CourseRequestDTO, CourseResponseDTO> {

    @Override
    @Mapping(target = "lessons", ignore = true)
    abstract public Course toEntity(CourseRequestDTO courseRequestDTO);

    @Override
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "pupils", ignore = true)
    @Mapping(target = "files", ignore = true)
    abstract public CourseResponseDTO toResponseDTO(Course course);
}
