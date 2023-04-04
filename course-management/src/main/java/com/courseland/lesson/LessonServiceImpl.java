package com.courseland.lesson;

import com.courseland.exception.ResourceNotFoundException;
import com.courseland.lesson.dtos.LessonRequestDTO;
import com.courseland.lesson.dtos.LessonWithJoinsResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public LessonWithJoinsResponseDTO createLesson(LessonRequestDTO lessonRequestDTO) {
        Lesson lesson = lessonRepository.save(lessonMapper.toEntity(lessonRequestDTO));

        return lessonMapper.toWithJoinsResponseDTO(lesson);
    }

    @Override
    public LessonWithJoinsResponseDTO updateLesson(Long id, LessonRequestDTO lessonRequestDTO) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson", "id"));
        lessonMapper.partialUpdate(lesson, lessonRequestDTO);
        lessonRepository.save(lesson);

        return lessonMapper.toWithJoinsResponseDTO(lesson);
    }

    @Override
    public List<LessonWithJoinsResponseDTO> getAllLessons() {

        return lessonRepository.findAll()
                .stream().map(lessonMapper::toWithJoinsResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LessonWithJoinsResponseDTO getLesson(Long id) {
        Lesson user = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson", "id"));

        return lessonMapper.toWithJoinsResponseDTO(user);
    }

    @Override
    public void deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) throw new ResourceNotFoundException("Lesson", "id");
        lessonRepository.deleteById(id);
    }
}
