package com.courseland.course;

import com.courseland.exception.ResourceNotFoundException;
import com.courseland.course.dtos.CourseRequestDTO;
import com.courseland.course.dtos.CourseWithJoinsResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseWithJoinsResponseDTO createCourse(CourseRequestDTO courseRequest) {
        Course course = courseRepository.save(courseMapper.toEntity(courseRequest));

        return courseMapper.toWithJoins(course);
    }

    @Override
    public CourseWithJoinsResponseDTO updateCourse(Long id, CourseRequestDTO courseRequest) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id"));

        courseMapper.partialUpdate(course, courseRequest);

        return courseMapper.toWithJoins(course);
    }

    @Override
    public List<CourseWithJoinsResponseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream().map(courseMapper::toWithJoins)
                .collect(Collectors.toList());
    }

    @Override
    public CourseWithJoinsResponseDTO getCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id"));

        return courseMapper.toWithJoins(course);
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) throw new ResourceNotFoundException("Course", "id");
        courseRepository.deleteById(id);
    }
}
