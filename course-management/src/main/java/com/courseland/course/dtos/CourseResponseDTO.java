package com.courseland.course.dtos;

import com.courseland.file.FileResponseDTO;
import com.courseland.lesson.dtos.LessonResponseDTO;
import com.courseland.user.AppUserResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseResponseDTO {

    private Long id;

    private String subject;

    private List<AppUserResponseDTO> teachers;

    private List<AppUserResponseDTO> pupils;

    private List<FileResponseDTO> files;

    private List<LessonResponseDTO> lessons;

    private Double price;
}
