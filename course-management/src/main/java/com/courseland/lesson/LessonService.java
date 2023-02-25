package com.courseland.lesson;

import com.courseland.lesson.dtos.LessonRequestDTO;
import com.courseland.lesson.dtos.LessonResponseDTO;
import com.courseland.lesson.dtos.LessonWithJoinsResponseDTO;

import java.util.List;

public interface LessonService {

    LessonWithJoinsResponseDTO createLesson(LessonRequestDTO userRequestDto);

    LessonWithJoinsResponseDTO updateLesson(Long id, LessonRequestDTO userRequestDto);

    List<LessonWithJoinsResponseDTO> getAllLessons();

    LessonWithJoinsResponseDTO getLesson(Long id);

    void deleteLesson(Long id);
}
