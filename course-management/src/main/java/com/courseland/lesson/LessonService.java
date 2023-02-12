package com.courseland.lesson;

import com.courseland.lesson.dtos.LessonRequestDTO;
import com.courseland.lesson.dtos.LessonResponseDTO;

import java.util.List;

public interface LessonService {

    LessonResponseDTO createLesson(LessonRequestDTO userRequestDto);

    LessonResponseDTO updateLesson(Long id, LessonRequestDTO userRequestDto);

    List<LessonResponseDTO> getAllLessons();

    LessonResponseDTO getLesson(Long id);

    void deleteLesson(Long id);
}
