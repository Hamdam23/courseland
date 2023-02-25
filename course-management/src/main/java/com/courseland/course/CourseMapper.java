package com.courseland.course;

import com.courseland.clients.file.FileServiceClient;
import com.courseland.clients.file.FilesIdsRequest;
import com.courseland.clients.user.AppUserServiceClient;
import com.courseland.commons.BaseMapper;
import com.courseland.course.dtos.CourseRequestDTO;
import com.courseland.course.dtos.CourseResponseDTO;
import com.courseland.course.dtos.CourseWithJoinsResponseDTO;
import com.courseland.lesson.LessonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        uses = LessonMapper.class
)
public abstract class CourseMapper implements BaseMapper<Course, CourseRequestDTO, CourseResponseDTO> {

    @Autowired
    private FileServiceClient fileServiceClient;

    @Autowired
    private AppUserServiceClient userServiceClient;

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lessons", ignore = true)
    abstract public Course toEntity(CourseRequestDTO courseRequestDTO);

    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "pupils", ignore = true)
    @Mapping(target = "files", ignore = true)
    @Mapping(target = "lessons", ignore = true)
    public abstract CourseWithJoinsResponseDTO toWithJoinsBase(Course course);

    public CourseWithJoinsResponseDTO toWithJoins(Course course) {
        CourseWithJoinsResponseDTO courseResponse = toWithJoinsBase(course);

        courseResponse.setTeachers(userServiceClient.getUsersFromIds(course.getTeachers()).getBody());
        courseResponse.setPupils(userServiceClient.getUsersFromIds(course.getPupils()).getBody());
        courseResponse.setFiles(fileServiceClient.getFilesFromIds(new FilesIdsRequest(course.getFiles())).getBody());

        return courseResponse;
    }
}
