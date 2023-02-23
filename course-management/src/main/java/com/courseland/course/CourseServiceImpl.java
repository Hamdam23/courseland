package com.courseland.course;

import com.courseland.course.dtos.CourseRequestDTO;
import com.courseland.course.dtos.CourseResponseDTO;
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
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequest) {
        Course course = courseRepository.save(courseMapper.toEntity(courseRequest));

        return courseMapper.toWithJoins(course);
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequest) {
        return null;
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream().map(courseMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponseDTO getCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));

        return courseMapper.toResponseDTO(course);
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) throw new RuntimeException("invalid id");
        courseRepository.deleteById(id);
    }
}
