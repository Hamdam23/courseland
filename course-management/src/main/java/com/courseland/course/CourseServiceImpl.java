package com.courseland.course;

import com.courseland.clients.file.FileServiceClient;
import com.courseland.clients.user.AppUserServiceClient;
import com.courseland.course.dtos.CourseRequestDTO;
import com.courseland.course.dtos.CourseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final FileServiceClient fileServiceClient;
    private final AppUserServiceClient userServiceClient;

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequest) {
        Course course = courseRepository.save(courseMapper.toEntity(courseRequest));
        CourseResponseDTO response = courseMapper.toResponseDTO(course);
//        response.setTeachers(userServiceClient.getUsersFromIds(courseRequest.getTeachers()).getBody());
//        response.setPupils(userServiceClient.getUsersFromIds(courseRequest.getPupils()).getBody());
//        response.setFiles(fileServiceClient.getFilesFromIds(courseRequest.getFiles()).getBody());
        return response;
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
