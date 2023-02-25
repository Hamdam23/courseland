package com.courseland.course;

import com.courseland.course.dtos.CourseRequestDTO;
import com.courseland.course.dtos.CourseResponseDTO;
import com.courseland.course.dtos.CourseWithJoinsResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseWithJoinsResponseDTO> createCourse(@RequestBody CourseRequestDTO requestDto) {
        log.info("Request to create a new course {}!", requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(courseService.createCourse(requestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CourseWithJoinsResponseDTO> updateCourse(
            @PathVariable Long id,
            @RequestBody CourseRequestDTO requestDto
    ) {
        log.info("Request to update course {} with id {}!", requestDto, id);

        return ResponseEntity.ok().body(courseService.updateCourse(id, requestDto));
    }

    @GetMapping
    public ResponseEntity<List<CourseWithJoinsResponseDTO>> getAllCourses() {
        log.info("Request to get all courses!");

        return ResponseEntity.ok().body(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseWithJoinsResponseDTO> getCourse(@PathVariable Long id) {
        log.info("Request to get a course with id {}!", id);

        return ResponseEntity.ok().body(courseService.getCourse(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        log.info("Request to delete a course with id {}!", id);

        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
