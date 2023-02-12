package com.courseland.lesson.dtos;

import com.courseland.file.FileResponseDTO;
import com.courseland.course.dtos.CourseResponseDTO;
import com.courseland.lesson.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LessonResponseDTO {

    private Long id;

    private String title;

    private CourseResponseDTO course;

    private Type type;

    private List<FileResponseDTO> studyMaterials;

    private List<FileResponseDTO> relatedResources;
}
