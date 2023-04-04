package com.courseland.lesson;

import com.courseland.commons.mapstruct.BaseMapper;
import com.courseland.clients.file.FileServiceClient;
import com.courseland.clients.file.FilesIdsRequest;
import com.courseland.course.CourseMapper;
import com.courseland.lesson.dtos.LessonRequestDTO;
import com.courseland.lesson.dtos.LessonResponseDTO;
import com.courseland.lesson.dtos.LessonWithJoinsResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        uses = CourseMapper.class
)
public abstract class LessonMapper implements BaseMapper<Lesson, LessonRequestDTO, LessonResponseDTO> {

    @Autowired
    private FileServiceClient fileServiceClient;

    @Override
    @Mapping(target = "course.id", source = "courseId")
    abstract public Lesson toEntity(LessonRequestDTO lessonRequestDTO);

    @Mapping(target = "studyMaterials", ignore = true)
    @Mapping(target = "relatedResources", ignore = true)
    public abstract LessonWithJoinsResponseDTO toWithJoinsBaseResponseDTO(Lesson lesson);

    public LessonWithJoinsResponseDTO toWithJoinsResponseDTO(Lesson lesson) {
        LessonWithJoinsResponseDTO responseDTO = toWithJoinsBaseResponseDTO(lesson);

        responseDTO.setStudyMaterials(fileServiceClient.getFilesFromIds(new FilesIdsRequest(lesson.getStudyMaterials())).getBody());
        responseDTO.setRelatedResources(fileServiceClient.getFilesFromIds(new FilesIdsRequest(lesson.getRelatedResources())).getBody());

        return responseDTO;
    }
}
