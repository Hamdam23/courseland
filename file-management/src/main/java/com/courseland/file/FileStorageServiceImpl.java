package com.courseland.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {

    private final FileRepository fileRepository;
    private final FileMapper fileMapper;

    @Override
    public FileResponseDTO uploadFile(MultipartFile multipartFile) throws IOException {
        File file = new File();
        file.setName(getOriginalFileName(multipartFile));
        file.setType(multipartFile.getContentType());
        file.setSize(multipartFile.getSize());

        return fileMapper.toResponse(fileRepository.save(file));
    }

    @Override
    public byte[] downloadFile(Long id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found!"))
                .getData();
    }

    @Override
    public List<FileResponseDTO> getAllFiles() {
        return fileRepository.findAll().stream().map(file -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(file.getId().toString())
                    .toUriString();

            return new FileResponseDTO(
                    file.getId(),
                    file.getName(),
                    fileDownloadUri,
                    file.getType(),
                    file.getSize());
        }).collect(Collectors.toList());
    }

    @Override
    public FileResponseDTO getFile(Long id) {
        return fileMapper.toResponse(fileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found!")));
    }

    @Override
    public void deleteFile(Long id) {
        if (!fileRepository.existsById(id)) {
            throw new RuntimeException("File not found!");
        }
        fileRepository.deleteById(id);
    }

    @Override
    public void checkFileId(Long id) {
        if (!fileRepository.existsById(id)) throw new RuntimeException("File not found with id " + id);
    }

    @Override
    public List<FileResponseDTO> getFilesFromIds(List<Long> ids) {
        return fileRepository.findAllByIdIn(ids).stream().map(fileMapper::toResponse).collect(Collectors.toList());
    }

    private String getOriginalFileName(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        if (originalFilename == null || originalFilename.isBlank()) {
            originalFilename = "file";
        }
        String filenameExtension = StringUtils.getFilenameExtension(originalFilename);
        String fileName = originalFilename.substring(0, originalFilename.indexOf("." + filenameExtension));
        fileName = fileName.replaceAll(" ", "-").concat("-" + System.currentTimeMillis());
        return fileName;
    }
}
