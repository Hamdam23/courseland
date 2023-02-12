package com.courseland.user.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AppUserRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String username;

    private Long avatarId;
}
