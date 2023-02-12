package com.courseland.course;

import com.courseland.course.dtos.CourseRequestDTO;
import com.courseland.course.dtos.CourseResponseDTO;

import java.util.List;

public interface CourseService {

    CourseResponseDTO createCourse(CourseRequestDTO courseRequest);

    CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequest);

    List<CourseResponseDTO> getAllCourses();

    CourseResponseDTO getCourse(Long id);

    void deleteCourse(Long id);
}
