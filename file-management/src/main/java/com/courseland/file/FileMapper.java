package com.courseland.file;

import com.courseland.clients.file.FileResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FileMapper {

    @Mapping(target = "size", ignore = true)
    FileResponseDTO toResponse(File file);
}
