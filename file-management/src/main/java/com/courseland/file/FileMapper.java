package com.courseland.file;

import com.courseland.clients.file.FileResponseDTO;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface FileMapper {

    FileResponseDTO toResponse(File file);
}
