package com.courseland.file;

import com.courseland.clients.file.FileResponseDTO;
import com.courseland.exception.ResourceNotFoundException;
import com.courseland.file.helper.FilesIdsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final FileMapper fileMapper;

    @Override
    public FileResponseDTO uploadFile(MultipartFile multipartFile) throws IOException {
        File file = new File();
        file.setName(FileStorageUtils.getOriginalFileName(multipartFile));
        file.setType(multipartFile.getContentType());
        file.setSize(FileStorageUtils.getFileSizeInMB(multipartFile.getSize()));
        file.setData(multipartFile.getBytes());

        return fileMapper.toResponse(fileRepository.save(file));
    }

    @Override
    public byte[] downloadFile(Long id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File", "id"))
                .getData();
    }

    @Override
    public List<FileResponseDTO> getAllFiles() {
        return fileRepository.findAll().stream()
                .map(fileMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FileResponseDTO getFile(Long id) {
        return fileMapper.toResponse(fileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File", "id")));
    }

    @Override
    public void deleteFile(Long id) {
        if (!fileRepository.existsById(id)) {
            throw new ResourceNotFoundException("File", "id");
        }
        fileRepository.deleteById(id);
    }

    @Override
    public List<FileResponseDTO> getFilesFromIds(FilesIdsRequest request) {
        return fileRepository.findAllByIdIn(request.getIds()).stream()
                .map(fileMapper::toResponse)
                .collect(Collectors.toList());
    }
}
