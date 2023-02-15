package com.courseland.lesson.dtos;

import com.courseland.clients.file.FileResponseDTO;
import com.courseland.lesson.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LessonResponseDTO {

    private Long id;

    private String title;

    private Type type;

    private List<FileResponseDTO> studyMaterials;

    private List<FileResponseDTO> relatedResources;
}
