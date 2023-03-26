package com.courseland.file;

import com.courseland.clients.file.FileResponseDTO;
import com.courseland.file.helper.FilesIdsRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@Slf4j
@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    //todo handle 415 unsupported media type error
    @PostMapping(value = "/upload", consumes = {IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE})
    public ResponseEntity<FileResponseDTO> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(fileService.uploadFile(file));
    }

    @GetMapping(value = "/download/{id}", produces = {IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        return ResponseEntity.ok().body(fileService.downloadFile(id));
    }

    @GetMapping()
    public ResponseEntity<List<FileResponseDTO>> getFiles() {
        return ResponseEntity.status(HttpStatus.OK).body(fileService.getAllFiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileResponseDTO> getFile(@PathVariable Long id) {
        return ResponseEntity.ok(fileService.getFile(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Long id) {
        fileService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/get-files-from-ids")
    public ResponseEntity<List<FileResponseDTO>> getFilesFromIds(@RequestBody FilesIdsRequest request) {
        log.info("request to get files from ids {}", request);
        return ResponseEntity.ok(fileService.getFilesFromIds(request));
    }
}
