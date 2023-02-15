package com.courseland.lesson.dtos;

import com.courseland.lesson.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LessonRequestDTO {

    @NotBlank
    private String title;

    @NonNull
    private Type type;

    private List<Long> studyMaterials;

    private List<Long> relatedResources;
}
