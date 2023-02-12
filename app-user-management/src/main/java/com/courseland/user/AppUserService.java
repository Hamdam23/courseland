package com.courseland.user;

import com.courseland.user.dtos.AppUserRequestDTO;
import com.courseland.user.dtos.AppUserResponseDTO;

import java.util.List;

public interface AppUserService {

    AppUserResponseDTO createUser(AppUserRequestDTO userRequestDto);

    AppUserResponseDTO updateUser(Long id, AppUserRequestDTO userRequestDto);

    List<AppUserResponseDTO> getAllUsers();

    AppUserResponseDTO getUsers(Long id);

    void deleteUser(Long id);

    List<AppUserResponseDTO> getUsersFromIds(List<Long> ids);
}
