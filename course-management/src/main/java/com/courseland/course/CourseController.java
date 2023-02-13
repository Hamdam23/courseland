package com.courseland.course;

import com.courseland.course.dtos.CourseRequestDTO;
import com.courseland.course.dtos.CourseResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponseDTO> createUser(@RequestBody CourseRequestDTO requestDto) {
        log.info("new course creation {}", requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(courseService.createCourse(requestDto));
    }
}
