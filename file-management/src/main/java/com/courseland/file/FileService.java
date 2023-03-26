package com.courseland.file;

import com.courseland.clients.file.FileResponseDTO;
import com.courseland.file.helper.FilesIdsRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    FileResponseDTO uploadFile(MultipartFile file) throws IOException;

    byte[] downloadFile(Long id);

    List<FileResponseDTO> getAllFiles();

    FileResponseDTO getFile(Long id);

    void deleteFile(Long id);

    List<FileResponseDTO> getFilesFromIds(FilesIdsRequest request);
}
