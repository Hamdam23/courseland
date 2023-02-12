package com.courseland.course.dtos;

import com.courseland.lesson.Lesson;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseRequestDTO {

    private String subject;

    private List<Long> teachers;

    private List<Long> pupils;

    private List<Long> files;

    private List<Lesson> lessons;

    private Double price;
}
