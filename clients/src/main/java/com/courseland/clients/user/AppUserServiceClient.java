package com.courseland.clients.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "app-user-management")
public interface AppUserServiceClient {

    @GetMapping("/api/v1/users/get-users-from-ids")
    ResponseEntity<List<AppUserResponseDTO>> getUsersFromIds(@RequestBody List<Long> ids);
}
