package com.courseland.lesson;

import com.courseland.commons.BaseMapper;
import com.courseland.clients.file.FileServiceClient;
import com.courseland.clients.file.FilesIdsRequest;
import com.courseland.lesson.dtos.LessonRequestDTO;
import com.courseland.lesson.dtos.LessonResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public abstract class LessonMapper implements BaseMapper<Lesson, LessonRequestDTO, LessonResponseDTO> {

    @Autowired
    private FileServiceClient fileServiceClient;

    @Override
    abstract public Lesson toEntity(LessonRequestDTO lessonRequestDTO);

    @Override
    @Mapping(target = "studyMaterials", ignore = true)
    @Mapping(target = "relatedResources", ignore = true)
    public abstract LessonResponseDTO toResponseDTO(Lesson lesson);

    public LessonResponseDTO toWithFilesResponseDTO(Lesson lesson) {
        LessonResponseDTO responseDTO = toResponseDTO(lesson);
        responseDTO.setStudyMaterials(fileServiceClient.getFilesFromIds(new FilesIdsRequest(lesson.getStudyMaterials())).getBody());
        responseDTO.setRelatedResources(fileServiceClient.getFilesFromIds(new FilesIdsRequest(lesson.getRelatedResources())).getBody());

        return responseDTO;
    }
}
