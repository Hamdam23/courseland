package com.courseland.lesson.dtos;

import com.courseland.lesson.Type;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class LessonRequestDTO {

    @NotBlank
    private String title;

    @NotNull
    private Long courseId;

    @NonNull
    private Type type;

    private List<Long> studyMaterials;

    private List<Long> relatedResources;
}
