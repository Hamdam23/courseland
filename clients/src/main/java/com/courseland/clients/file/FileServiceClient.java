package com.courseland.clients.file;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "file-management")
public interface FileServiceClient {

    @GetMapping("/api/v1/files/check-file-id/{id}")
    void checkFileId(@PathVariable Long id);

    @GetMapping("/api/v1/files/{id}")
    ResponseEntity<FileResponseDTO> getFile(@PathVariable Long id);

    @GetMapping("/api/v1/files/get-files-from-ids")
    ResponseEntity<List<FileResponseDTO>> getFilesFromIds(@RequestBody FilesIdsRequest request);
}
