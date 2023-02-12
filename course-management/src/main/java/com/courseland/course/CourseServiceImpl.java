package com.courseland.course;

import com.courseland.file.FileServiceClient;
import com.courseland.course.dtos.CourseRequestDTO;
import com.courseland.course.dtos.CourseResponseDTO;
import com.courseland.user.AppUserServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final FileServiceClient fileServiceClient;
    private final AppUserServiceClient userServiceClient;

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequest) {
        Course course = courseMapper.toEntity(courseRequest);
        CourseResponseDTO response = courseMapper.toResponseDTO(course);
        response.setTeachers(userServiceClient.getUsersFromIds(courseRequest.getTeachers()).getBody());
        response.setPupils(userServiceClient.getUsersFromIds(courseRequest.getPupils()).getBody());
        response.setFiles(fileServiceClient.getFilesFromIds(courseRequest.getFiles()).getBody());
        return response;
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequest) {
        return null;
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return null;
    }

    @Override
    public CourseResponseDTO getCourse(Long id) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {

    }
}
