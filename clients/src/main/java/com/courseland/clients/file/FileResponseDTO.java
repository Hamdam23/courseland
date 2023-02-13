package com.courseland.clients.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileResponseDTO {

    private Long id;

    private String name;

    private String url;

    private String type;

    private long size;
}
