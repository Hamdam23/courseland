package com.courseland.user;

import com.courseland.clients.file.FileResponseDTO;
import com.courseland.clients.file.FileServiceClient;
import com.courseland.clients.file.FilesIdsRequest;
import com.courseland.user.dtos.AppUserRequestDTO;
import com.courseland.user.dtos.AppUserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepository;
    private final AppUserMapper userMapper;
    private final FileServiceClient fileServiceClient;

    @Override
    public AppUserResponseDTO createUser(AppUserRequestDTO userRequestDto) {

        List<FileResponseDTO> re = fileServiceClient.getFilesFromIds(
                new FilesIdsRequest(List.of(23L, 24L))
        ).getBody();
        AppUser user = userRepository.save(userMapper.toEntity(userRequestDto));
        AppUserResponseDTO response = userMapper.toResponse(user);
        response.setAvatar(getFileById(user.getAvatarId()));
        return response;
    }

    @Override
    public AppUserResponseDTO updateUser(Long id, AppUserRequestDTO userRequestDto) {
        AppUser user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));
        userMapper.partialUpdate(userRequestDto, user);
        AppUserResponseDTO response = userMapper.toResponse(user);
        response.setAvatar(getFileById(user.getAvatarId()));
        return response;
    }

    @Override
    public List<AppUserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public AppUserResponseDTO getUsers(Long id) {
        AppUser user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));
        return userMapper.toResponse(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));
        userRepository.deleteById(id);
    }

    @Override
    public List<AppUserResponseDTO> getUsersFromIds(List<Long> ids) {
        return userRepository.findAllByIdIn(ids).stream().map(userMapper::toResponse).collect(Collectors.toList());
    }

    private FileResponseDTO getFileById(Long id) {
        return fileServiceClient.getFile(id).getBody();
    }
}
