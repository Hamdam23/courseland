package com.courseland.lesson;

import com.courseland.lesson.dtos.LessonRequestDTO;
import com.courseland.lesson.dtos.LessonResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public LessonResponseDTO createLesson(LessonRequestDTO lessonRequestDTO) {
        Lesson lesson = lessonRepository.save(lessonMapper.toEntity(lessonRequestDTO));

        return lessonMapper.toWithJoinsResponseDTO(lesson);
    }

    @Override
    public LessonResponseDTO updateLesson(Long id, LessonRequestDTO lessonRequestDTO) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));
        lessonMapper.partialUpdate(lesson, lessonRequestDTO);
        lessonRepository.save(lesson);

        return lessonMapper.toWithJoinsResponseDTO(lesson);
    }

    @Override
    public List<LessonResponseDTO> getAllLessons() {

        return lessonRepository.findAll()
                .stream().map(lessonMapper::toWithJoinsResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LessonResponseDTO getLesson(Long id) {
        Lesson user = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));

        return lessonMapper.toWithJoinsResponseDTO(user);
    }

    @Override
    public void deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) throw new RuntimeException("invalid id");
        lessonRepository.deleteById(id);
    }
}
