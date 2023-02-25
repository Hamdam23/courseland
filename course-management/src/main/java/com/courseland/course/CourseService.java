package com.courseland.course;

import com.courseland.course.dtos.CourseRequestDTO;
import com.courseland.course.dtos.CourseResponseDTO;
import com.courseland.course.dtos.CourseWithJoinsResponseDTO;

import java.util.List;

public interface CourseService {

    CourseWithJoinsResponseDTO createCourse(CourseRequestDTO courseRequest);

    CourseWithJoinsResponseDTO updateCourse(Long id, CourseRequestDTO courseRequest);

    List<CourseWithJoinsResponseDTO> getAllCourses();

    CourseWithJoinsResponseDTO getCourse(Long id);

    void deleteCourse(Long id);
}
