package com.courseland.user;

import com.courseland.user.dtos.AppUserResponseDTO;
import com.courseland.user.dtos.AppUserRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class AppUserController {

    private final AppUserService userService;

    @PostMapping
    public ResponseEntity<AppUserResponseDTO> createUser(@RequestBody AppUserRequestDTO requestDto) {
        log.info("new user creation {}", requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(requestDto));
    }

    @PatchMapping("{id}")
    public ResponseEntity<AppUserResponseDTO> updateUser(
            @PathVariable Long id,
            @RequestBody AppUserRequestDTO requestDto
    ) {
        log.info("Request to update user");
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, requestDto));
    }

    @GetMapping
    public ResponseEntity<List<AppUserResponseDTO>> getAllUsers() {
        log.info("Request to get all users");
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<AppUserResponseDTO> getUser(@PathVariable Long id) {
        log.info("Request to get a user");
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        log.info("Request to delete a user");
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("get-users-from-ids")
    public ResponseEntity<List<AppUserResponseDTO>> getFilesFromIds(@RequestBody List<Long> ids) {
        log.info("request to get users from ids {}", ids);
        return ResponseEntity.ok(userService.getUsersFromIds(ids));
    }
}
