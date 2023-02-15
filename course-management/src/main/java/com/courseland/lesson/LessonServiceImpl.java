package com.courseland.lesson;

import com.courseland.clients.file.FilesIdsRequest;
import com.courseland.course.CourseMapper;
import com.courseland.lesson.dtos.LessonRequestDTO;
import com.courseland.clients.file.FileServiceClient;
import com.courseland.lesson.dtos.LessonResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final FileServiceClient fileServiceClient;

    @Override
    public LessonResponseDTO createLesson(LessonRequestDTO lessonRequestDTO) {
        Lesson lesson = lessonRepository.save(lessonMapper.toEntity(lessonRequestDTO));

        return lessonMapper.toWithFilesResponseDTO(lesson);
    }

    @Override
    public LessonResponseDTO updateLesson(Long id, LessonRequestDTO lessonRequestDTO) {
        Lesson user = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));
        lessonMapper.partialUpdate(user, lessonRequestDTO);

        LessonResponseDTO response = lessonMapper.toResponseDTO(user);
        response.setStudyMaterials(fileServiceClient.getFilesFromIds(new FilesIdsRequest(lessonRequestDTO.getStudyMaterials())).getBody());
        response.setRelatedResources(fileServiceClient.getFilesFromIds(new FilesIdsRequest(lessonRequestDTO.getRelatedResources())).getBody());

        return response;
    }

    @Override
    public List<LessonResponseDTO> getAllLessons() {

        return lessonRepository.findAll()
                .stream().map(lessonMapper::toWithFilesResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LessonResponseDTO getLesson(Long id) {
        Lesson user = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));

        return lessonMapper.toResponseDTO(user);
    }

    @Override
    public void deleteLesson(Long id) {
        if(!lessonRepository.existsById(id)) throw new RuntimeException("invalid id");
        lessonRepository.deleteById(id);
    }
}
