package com.courseland.lesson;

import com.courseland.BaseMapper;
import com.courseland.clients.file.FileResponseDTO;
import com.courseland.lesson.dtos.LessonRequestDTO;
import com.courseland.lesson.dtos.LessonResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public abstract class LessonMapper implements BaseMapper<Lesson, LessonRequestDTO, LessonResponseDTO> {

    @Override
    abstract public Lesson toEntity(LessonRequestDTO lessonRequestDTO);

    @Override
    @Mapping(target = "studyMaterials", ignore = true)
    @Mapping(target = "relatedResources", ignore = true)
    abstract public LessonResponseDTO toResponseDTO(Lesson lesson);

    public LessonResponseDTO toWithFilesResponseDTO(
            Lesson lesson,
            List<FileResponseDTO> studyMaterials,
            List<FileResponseDTO> relatedResources
    ) {
        LessonResponseDTO responseDTO = toResponseDTO(lesson);
        responseDTO.setStudyMaterials(studyMaterials);
        responseDTO.setRelatedResources(relatedResources);

        return responseDTO;
    }
}
