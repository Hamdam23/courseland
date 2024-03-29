package com.courseland.course.dtos;

import com.courseland.clients.file.FileResponseDTO;
import com.courseland.lesson.dtos.LessonResponseDTO;
import com.courseland.clients.user.AppUserResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseResponseDTO {

    private Long id;

    private String subject;

    private Double price;
}
