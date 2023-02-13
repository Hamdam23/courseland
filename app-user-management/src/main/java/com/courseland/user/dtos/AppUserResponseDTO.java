package com.courseland.user.dtos;

import com.courseland.clients.file.FileResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUserResponseDTO {

    private Long id;
    private String name;
    private String username;
    private FileResponseDTO avatar;
}
